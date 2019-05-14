import { Component, OnInit } from '@angular/core';
import { RestApiService } from '../../rest-api/rest-api.service';
import { LoadingController, NavController } from '@ionic/angular';

@Component({
	selector: 'app-ajouter',
	templateUrl: './ajouter.page.html',
	styleUrls: ['./ajouter.page.scss'],
})
export class AjouterPage implements OnInit {

	categVente : any;
	lieu : any;
	nom : string;
	dateDebut : Date;
	dateFin : Date;
	dateVente : Date;
	idLieu : number;
	idCategVente : number;
	
	
	constructor(private api: RestApiService,
	private loadingController: LoadingController,
	private navCtrl: NavController) { }

	async ngOnInit() {
		this.categVente = [];
		this.lieu = [];
		let offset = 0;
		let shouldBreak = false;
		while(true){
			await this.api.getCategVente(offset)
				.then(async res => {
					console.log(res);
					if(res.length == 0){
						shouldBreak = true;
					} else {
						for(let i = 0 ; i < res.length ; i++) {
							this.categVente.push(res[i]);
						}
					}
				});
				offset ++;
				if (shouldBreak) { 
					break ;
				}
		}
		
		offset = 0;
		shouldBreak = false;
		while(true){
			await this.api.getLieux(offset)
				.then(async res => {
					console.log(res);
					if(res.length == 0){
						shouldBreak = true;
					} else {
						for(let i = 0 ; i < res.length ; i++) {
							this.lieu.push(res[i]);
						}
					}
				});
				offset ++;
				if (shouldBreak) { 
					break ;
				}
		}
	}

	async addVente() {
		console.log(this.dateDebut);
		const loading = await this.loadingController.create({
			message: 'Envoie des informations'
		});
		await loading.present();

		await this.api.addVente(this.nom, this.dateDebut, this.dateFin, this.dateVente, this.idLieu, this.idCategVente)
			.then(res => {
			loading.dismiss();
			this.navCtrl.pop();
		},
			err => {
			console.log(err);
			loading.dismiss();
		});
	}

}
