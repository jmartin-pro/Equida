import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { AlertController, NavController } from '@ionic/angular';

@Injectable({
	providedIn: 'root'
})

export class RestApiService {

	apiUrl = "http://127.0.0.1:1515/api";

	constructor(public navCtrl: NavController, private http: HttpClient, public alertController: AlertController) {
	}

	public saveCredentials(username : string, passwd : string, role: string, userId: string) {
		localStorage.setItem("username", username);
		localStorage.setItem("passwd", passwd);
		localStorage.setItem("role", role);
		localStorage.setItem("user-id", userId);
	}

	public removeCredentials() {
		localStorage.removeItem("username");
		localStorage.removeItem("passwd");
		localStorage.removeItem("role");
		localStorage.removeItem("user-id");
	}

	checkLogin(username : string, passwd : string): Promise<any> {
		const url = this.apiUrl+'/login';
		return this.http.get(url, this.getHttpOptions()).pipe(map(this.extractData)).toPromise();
	}

	addVente(nom: string, dateDebut:string, dateFin:string, dateVente:string, idLieu:number, idCategVente:number): any {
		let data = {
			nom : nom,
			dateDebut : this.formatDate(dateDebut),
			dateFin : this.formatDate(dateFin),
			dateVente : this.formatDate(dateVente),
			idLieu : idLieu,
			idCategVente : idCategVente

		};

		const url = this.apiUrl+'/ventes';
		return this.execPostMethod(url, data);
	}
	
	addLotClient(idVente: string, idCheval:number, prixDepart : number): any {
		let data = {
			idVente : idVente,
			idCheval : idCheval,
			prixDepart : prixDepart

		};

		const url = this.apiUrl+'/lots';
		return this.execPostMethod(url, data);
	}

	addPays(libelle: string): Promise<any> {
		let data = {
			libelle : libelle
		};

		const url = this.apiUrl+'/pays';
		return this.execPostMethod(url, data);
	}

	deleteCheval(id: string): Promise<any> {
		const url = this.apiUrl+'/chevaux/'+id;
		return this.execDeleteMethod(url);
	}

	deletePays(id: string): Promise<any> {
		const url = this.apiUrl+'/pays/'+id;
		return this.execDeleteMethod(url);
	}

	deleteVente(id: string): Promise<any> {
		const url = this.apiUrl+'/ventes/'+id;
		return this.execDeleteMethod(url);
	}

	getCategVente(offset : number): Promise<any> {
		const url = this.apiUrl+'/categoriesVente?offset='+offset;
		return this.execGetMethod(url);
	}

	getCategVenteById(id: string): Promise<any> {
		const url = this.apiUrl+'/categoriesVente/'+id;
		return this.execGetMethod(url);
	}

	getChevalById(id: string): Promise<any> {
		const url = this.apiUrl+'/chevaux/'+id;
		return this.execGetMethod(url);
	}
	
	getChevauxDispoVente(offset : number): Promise<any> {
		const url = this.apiUrl+'/lots/dispoVente?offset='+offset;
		return this.execGetMethod(url);
	}

	getClientById(id: string): Promise<any> {
		const url = this.apiUrl+'/clients/'+id;
		return this.execGetMethod(url);
	}

	getCourseById(id: string): Promise<any> {
		const url = this.apiUrl+'/courses/'+id;
		return this.execGetMethod(url);
	}

	getLotsAValider(offset : number): Promise<any> {
		const url = this.apiUrl+'/lotsAValider?offset='+offset;
		return this.execGetMethod(url);
	}

	getLieux(offset : number): Promise<any> {
		const url = this.apiUrl+'/lieux?offset='+offset;
		return this.execGetMethod(url);
	}

	getLieuById(id: string): Promise<any> {
		const url = this.apiUrl+'/lieux/'+id;
		return this.execGetMethod(url);
	}

	denyLot(id: string) : Promise<any> {
		const url = this.apiUrl+'/lotsAValider/'+id+'/deny';
		return this.execPostMethod(url, {});
	}

	acceptLot(id: string) : Promise<any> {
		const url = this.apiUrl+'/lotsAValider/'+id+'/accept';
		return this.execPostMethod(url, {});
	}

	getLots(offset : number): Promise<any> {
		const url = this.apiUrl+'/lots?offset='+offset;
		return this.execGetMethod(url);
	}

	getLotById(id: string): Promise<any> {
		const url = this.apiUrl+'/lots/'+id;
		return this.execGetMethod(url);
	}

	getLotByChevalId(id: string): Promise<any> {
		const url = this.apiUrl+'/chevaux/'+id+"/lot";
		return this.execGetMethod(url);
	}

	getLotsByIdVente(id: string, offset: number): Promise<any> {
		const url = this.apiUrl+'/ventes/'+id+'/lots?offset='+offset;
		return this.execGetMethod(url);
	}

	getMesChevaux(offset: number): Promise<any> {
		const url = this.apiUrl+'/chevaux/?offset='+offset;
		return this.execGetMethod(url);
	}

	getParticipationByIdCheval(id: string, offset: number): Promise<any> {
		const url = this.apiUrl+'/chevaux/'+id+'/courses?offset='+offset;
		return this.execGetMethod(url);
	}

	getPays(): Promise<any> {
		const url = this.apiUrl+'/pays';
		return this.execGetMethod(url);
	}

	getPaysById(id: string): Promise<any> {
		const url = this.apiUrl+'/pays/'+id;
		return this.execGetMethod(url);
	}

	getRaceChevalById(id: string): Promise<any> {
		const url = this.apiUrl+'/racesChevaux/'+id;
		return this.execGetMethod(url);
	}

	getVentes(offset : number): Promise<any> {
		const url = this.apiUrl+'/ventes?offset='+offset;
		return this.execGetMethod(url);
	}

	getVenteById(id: string): Promise<any> {
		const url = this.apiUrl+'/ventes/'+id;
		return this.execGetMethod(url);
	}
	
	updateVente(idVente: string, nom: string, dateDebut:string, dateFin:string, dateVente:string, idLieu:number, idCategVente:number): any {
		let data = {
			idVente : idVente,
			nom : nom,
			dateDebut : this.formatDate(dateDebut),
			dateFin : this.formatDate(dateFin),
			dateVente : this.formatDate(dateVente),
			idLieu : idLieu,
			idCategVente : idCategVente

		};

		const url = this.apiUrl+'/ventes/'+idVente;
		return this.execPatchMethod(url, data);
	}

	public execGetMethod(url: string): Promise<any> {
		return this.http.get(url, this.getHttpOptions()).pipe(
		map(this.extractData),
		catchError(async err => {
			if(err.status == 401) {
				this.removeCredentials();
				this.navCtrl.navigateForward('/login');
				return;
			}
			return this.handleError(err);
		})).toPromise();
	}

	public execPostMethod(url: string, data: any): Promise<any> {
		return this.http.post(url, data, this.getHttpOptions()).pipe(
			map(this.extractData),
			catchError(async err => {
				if(err.status == 401) {
					this.removeCredentials();
					this.navCtrl.navigateForward('/login');
					return;
				}
				return this.handleError(err);
			})).toPromise();
	}	
	
	public execPatchMethod(url: string, data: any): Promise<any> {
		return this.http.patch(url, data, this.getHttpOptions()).pipe(
			map(this.extractData),
			catchError(async err => {
				if(err.status == 401) {
					this.removeCredentials();
					this.navCtrl.navigateForward('/login');
					return;
				}
				return this.handleError(err);
			})).toPromise();
	}

	public execDeleteMethod(url: string): Promise<any> {
		return this.http.delete(url, this.getHttpOptions()).pipe(
		map(this.extractData),
		catchError(async err => {
			if(err.status == 401) {
				this.removeCredentials();
				this.navCtrl.navigateForward('/login');
				return;
			}
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

	private async handleError(error: HttpErrorResponse) {
		if (error.error instanceof ErrorEvent) {
			// A client-side or network error occurred. Handle it accordingly.
			console.error('An error occurred:', error.error.message);
		} else {
			// The backend returned an unsuccessful response code.
			// The response body may contain clues as to what went wrong,
			console.error(
				'Backend returned code '+error.status+', ' +
				'body was: '+error.error
			);

			const alert = await this.alertController.create({
		      header: 'Oups...',
		      subHeader: '',
		      message: 'Une erreur s\'est produite. Merci de réessayer plus tard.',
		      buttons: ['Valider']
		    });

		    await alert.present();
		}

		throw new Error('Something bad happened; please try again later.');
	}

	private extractData(res: Response) {
		let body = res;
		return body || null;
	}

	public formatDate(dateStr : string):string{
		let dateArray = dateStr.split("-");
		return dateArray[2]+"/"+dateArray[1]+"/"+dateArray[0];
	}
	
	public deformatDate(dateStr : string):string{
		let dateArray = dateStr.split("/");
		return dateArray[2]+"-"+dateArray[1]+"-"+dateArray[0];
	}

	public async getAll(callback: any, ...args: any[]) {
		let datas = [];
		let offset = 0;
		let shouldBreak = false;

		callback = callback.bind(this);

		while(true){
			await callback(...args, offset)
				.then(async res => {
					console.log(res);
					if(res.length == 0){
						shouldBreak = true;
					} else {
						for(let i = 0 ; i < res.length ; i++) {
							datas.push(res[i]);
						}
					}
				});

				offset++;

				if (shouldBreak) {
					break;
				}
		}
		return datas;
	}
}
