import { Component, OnInit } from '@angular/core';

import { LoadingController } from '@ionic/angular';
import { RestApiService } from '../rest-api/rest-api.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

	public lots: any;

	constructor(public api: RestApiService, public loadingController: LoadingController) { }

	ngOnInit() {
		this.lots = [];
		this.getLots();
	}

	async getLots() {
		const loading = await this.loadingController.create({
			message: 'Chargement'
		});

		await loading.present();

		this.loadLots();

		loading.dismiss();
	}

	async loadLots() {
		await this.api.getNouveauxLots()
			.then(async res => {
				for(let i = 0 ; i < res.length ; i++) {
					await this.api.getChevalById(res[i].idCheval)
						.then(async c => {
							res[i].cheval = c;
							await this.api.getRaceChevalById(res[i].cheval.idRaceCheval)
								.then(async rc => {
									res[i].cheval.raceCheval = rc;
									}, err => {
										console.log(err);
									});

									}, err => {
										console.log(err);
									});						
					this.lots.push(res[i]);
				}
			});
	}
}
