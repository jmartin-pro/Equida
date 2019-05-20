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
	dateDebut : string;
	dateFin : string;
	dateVente : string;
	idLieu : number;
	idCategVente : number;

	constructor(private api: RestApiService,
	private loadingController: LoadingController,
	private navCtrl: NavController) { }

	async ngOnInit() {
		await this.api.getAll(this.api.getCategVente)
			.then(async res => {
				this.categVente = res;
			});

		await this.api.getAll(this.api.getLieux)
			.then(async res => {
				this.lieu = res;
			});
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
