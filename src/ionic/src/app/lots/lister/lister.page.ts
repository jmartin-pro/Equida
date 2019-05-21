import { Component, OnInit } from '@angular/core';

import { LoadingController } from '@ionic/angular';
import { RestApiService } from '../../rest-api/rest-api.service';

@Component({
  selector: 'app-lister',
  templateUrl: './lister.page.html',
  styleUrls: ['./lister.page.scss'],
})
export class ListerPage implements OnInit {

	public lots: any;
	private currentOffset: number;
	private shouldDisableInfiniteScroll : boolean;

	constructor(public api: RestApiService, public loadingController: LoadingController) { }

	ngOnInit() {
		this.currentOffset = 0;
		this.lots = [];
		this.shouldDisableInfiniteScroll = false;
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

	async loadData(event) {
		this.currentOffset += 1;

		this.loadLots();

		if(this.shouldDisableInfiniteScroll)
			event.target.disabled = true;

		event.target.complete();
	}

	async loadLots() {
		await this.api.getLots(this.currentOffset)
			.then(async res => {
				console.log(res);

				if(res.length == 0) {
					this.shouldDisableInfiniteScroll = true;
				} else {
					for(let i = 0 ; i < res.length ; i++) {
						await this.api.getChevalById(res[i].idCheval).then(async c => {
								res[i].cheval = c;
								await this.api.getRaceChevalById(res[i].cheval.idRaceCheval).then(async rc => {
									res[i].cheval.raceCheval = rc;
								}, err => {
									console.log(err);
								});

							}, err => {
								console.log(err);
							});
						
						
						this.lots.push(res[i]);
					}
				}
			}, err => {
				console.log(err);
			});
	}
}
