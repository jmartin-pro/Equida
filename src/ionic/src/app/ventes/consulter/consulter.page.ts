import { Component, OnInit } from '@angular/core';
import { LoadingController } from '@ionic/angular';
import { RestApiService } from '../../rest-api/rest-api.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NavController } from '@ionic/angular';

@Component({
	selector: 'app-consulter',
	templateUrl: './consulter.page.html',
	styleUrls: ['./consulter.page.scss'],
})
export class ConsulterPage implements OnInit {

	vente: any = null;
	lots: any = null;

	constructor(public api: RestApiService,
		public loadingController: LoadingController,
		public route: ActivatedRoute,
		public router: Router,
		public navCtrl: NavController) { }

	async ngOnInit() {
		await this.getVenteById();
		await this.getLotsByIdVente();
	}

	async getVenteById() {
		await this.api.getVenteById(this.route.snapshot.paramMap.get('id'))
			.then(async res => {	
				await this.api.getLieuById(res.idLieu).then(async l => {
					res.lieu = l;
					}, err => {
						console.log(err);
					});
				await this.api.getCategVenteById(res.idCategVente).then(async cv => {
					res.categVente = cv;
					}, err => {
						console.log(err);
					});
				this.vente = res;
			}, err => {
				console.log(err);
			});
	}
	
	async getLotsByIdVente() {
		await this.api.getAll(this.api.getLotsByIdVente, this.route.snapshot.paramMap.get('id'))
			.then(async res => {	
				for(let i = 0; i<res.length; i++){
					await this.api.getChevalById(res[i].idCheval)
						.then(async c => {
							res[i].cheval = c;
						});
					await this.api.getRaceChevalById(res[i].cheval.idRaceCheval)
						.then(async r => {
							res[i].cheval.race = r;
						});
				}
				this.lots = res;
			}, err => {
				console.log(err);
			});
	}
	
	async deleteVente() {
		const loading = await this.loadingController.create({
			message: 'Envoi des informations'
		});
		await loading.present();
		await this.api.deleteVente(this.route.snapshot.paramMap.get('id'))
		.then(res => {
			console.log(res);
			loading.dismiss();
			this.navCtrl.navigateForward('/ventes');
		}, err => {
			console.log(err);
			loading.dismiss();
		});
	}

}
