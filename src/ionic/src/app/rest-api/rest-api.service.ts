import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import {NavController} from '@ionic/angular';

const apiUrl = "http://127.0.0.1:1515/api";

@Injectable({
	providedIn: 'root'
})

export class RestApiService {

	constructor(public navCtrl: NavController, private http: HttpClient) {
	}

	public saveCredentials(username : string, passwd : string, role: string) {
		localStorage.setItem("username", username);
		localStorage.setItem("passwd", passwd);
		localStorage.setItem("role", role);
	}

	public removeCredentials() {
		localStorage.removeItem("username");
		localStorage.removeItem("passwd");
		localStorage.removeItem("role");
	}

	checkLogin(username : string, passwd : string): Promise<any> {
		const url = `${apiUrl}/login`;
		return this.execGetMethod(url);
	}

	addPays(libelle: string): Promise<any> {
		let data = {
			libelle : libelle
		};

		const url = `${apiUrl}/pays`;
		return this.execPostMethod(url, data);
	}

	deletePays(id: string): Promise<any> {
		const url = `${apiUrl}/pays/${id}`;
		return this.execDeleteMethod(url);
	}

	getChevalById(id: string): Promise<any> {
		const url = `${apiUrl}/chevaux/${id}`;
		return this.execGetMethod(url);
	}

	getLots(offset : number): Promise<any> {
		const url = `${apiUrl}/lots?offset=${offset}`;
		return this.execGetMethod(url);
	}

	getLotById(id: string): Promise<any> {
		const url = `${apiUrl}/lots/${id}`;
		return this.execGetMethod(url);
	}

	getPays(): Promise<any> {
		const url = `${apiUrl}/pays`;
		return this.execGetMethod(url);
	}

	getPaysById(id: string): Promise<any> {
		const url = `${apiUrl}/pays/${id}`;
		return this.execGetMethod(url);
	}

	getRaceChevalById(id: string): Promise<any> {
		const url = `${apiUrl}/racesChevaux/${id}`;
		return this.execGetMethod(url);
	}

	public execGetMethod(url: string): Promise<any> {
		return this.http.get(url, this.getHttpOptions()).pipe(
		map(this.extractData),
		catchError(err => {
			this.removeCredentials();
			return this.handleError(err);
		})).toPromise();
	}

	public execPostMethod(url: string, data: any): Promise<any> {
		return this.http.post(url, data, this.getHttpOptions()).pipe(
			map(this.extractData),
			catchError(err => {
				this.removeCredentials();
				return this.handleError(err);
			})).toPromise();
	}

	public execDeleteMethod(url: string): Promise<any> {
		return this.http.delete(url, this.getHttpOptions()).pipe(
		map(this.extractData),
		catchError(err => {
			this.removeCredentials();
			return this.handleError(err);
		})).toPromise();
	}

	private getHttpOptions() {
		let username = localStorage.getItem("username");
		let passwd = localStorage.getItem("passwd");

		if(username == undefined || passwd == undefined) {
			this.navCtrl.navigateForward('/login');
			return;
		}

		let base64Auth = btoa(username+":"+passwd);
		const httpOptions = {
			headers: new HttpHeaders({'Content-Type': 'application/json',
				'Authorization' : 'Basic '+base64Auth
			}),
		};

		return httpOptions;
	}

	private handleError(error: HttpErrorResponse) {
		if (error.error instanceof ErrorEvent) {
			// A client-side or network error occurred. Handle it accordingly.
			console.error('An error occurred:', error.error.message);
		} else {
			// The backend returned an unsuccessful response code.
			// The response body may contain clues as to what went wrong,
			console.error(
				`Backend returned code ${error.status}, ` +
				`body was: ${error.error}`
			);
		}

		return throwError('Something bad happened; please try again later.');
	}

	private extractData(res: Response) {
		let body = res;
		return body || { };
	}
}
