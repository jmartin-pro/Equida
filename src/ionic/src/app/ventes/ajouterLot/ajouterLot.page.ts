import { Component, OnInit } from '@angular/core';
import { RestApiService } from '../../rest-api/rest-api.service';
import { LoadingController, NavController } from '@ionic/angular';
import { ActivatedRoute } from '@angular/router';

@Component({
	selector: 'app-ajouterLot',
	templateUrl: './ajouterLot.page.html',
	styleUrls: ['./ajouterLot.page.scss'],
})
export class AjouterLotPage implements OnInit {

	chevaux : any;
	prixDepart : number;
	idCheval : number;
	idVente : string;

	constructor(
	private api: RestApiService,
	private loadingController: LoadingController,
	private navCtrl: NavController,
	public route: ActivatedRoute ) { }

	async ngOnInit() {
		this.idVente = this.route.snapshot.paramMap.get('id');
		await this.api.getAll(this.api.getChevauxDispoVente)
			.then(async res => {
				this.chevaux = res;
			});
	}

	async addLotClient() {
		const loading = await this.loadingController.create({
			message: 'Envoie des informations'
		});
		await loading.present();

		await this.api.addLotClient(this.idVente, this.idCheval, this.prixDepart)
			.then(res => {
			loading.dismiss();
			this.navCtrl.navigateForward('/ventes');
		},
			err => {
			console.log(err);
			loading.dismiss();
		});
	}

}
