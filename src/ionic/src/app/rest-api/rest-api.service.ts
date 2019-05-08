import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';


const httpOptions = {
	headers: new HttpHeaders({'Content-Type': 'application/json',
		'Authorization' : 'Basic Y2RlbHRvdXI6dGVzdA=='
	}),
};
const apiUrl = "http://127.0.0.1:1515/api";

@Injectable({
	providedIn: 'root'
})

export class RestApiService {
	constructor(private http: HttpClient) { }

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


	addPays(libelle: string): Promise<any> {
		let data = {
			libelle : libelle
		};

		const url = `${apiUrl}/pays`;
		return this.http.post(url, data, httpOptions).pipe(
		map(this.extractData),
		catchError(this.handleError)).toPromise();
	}

	deletePays(id: string): Promise<any> {
		const url = `${apiUrl}/pays/${id}`;
		return this.http.delete(url, httpOptions).pipe(
		map(this.extractData),
		catchError(this.handleError)).toPromise();
	}

	getChevalById(id: string): Promise<any> {
		const url = `${apiUrl}/chevaux/${id}`;
		return this.http.get(url, httpOptions).pipe(
		map(this.extractData),
		catchError(this.handleError)).toPromise();
	}

	getLots(offset : number): Promise<any> {
		const url = `${apiUrl}/lots?offset=${offset}`;
		console.log('url ' + url);
		return this.http.get(url, httpOptions).pipe(
		map(this.extractData),
		catchError(this.handleError)).toPromise();
	}

	getLotById(id: string): Promise<any> {
		const url = `${apiUrl}/lots/${id}`;
		return this.http.get(url, httpOptions).pipe(
		map(this.extractData),
		catchError(this.handleError)).toPromise();
	}

	getPays(): Promise<any> {
		const url = `${apiUrl}/pays`;
		console.log('url ' + url);
		return this.http.get(url, httpOptions).pipe(
		map(this.extractData),
		catchError(this.handleError)).toPromise();
	}

	getPaysById(id: string): Promise<any> {
		const url = `${apiUrl}/pays/${id}`;
		return this.http.get(url, httpOptions).pipe(
		map(this.extractData),
		catchError(this.handleError)).toPromise();
	}

	getRaceChevalById(id: string): Promise<any> {
		const url = `${apiUrl}/racesChevaux/${id}`;
		return this.http.get(url, httpOptions).pipe(
		map(this.extractData),
		catchError(this.handleError)).toPromise();
	}
}
