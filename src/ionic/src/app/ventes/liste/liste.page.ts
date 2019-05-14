import { Component, OnInit } from '@angular/core';

import { LoadingController } from '@ionic/angular';
import { RestApiService } from '../../rest-api/rest-api.service';

@Component({
  selector: 'app-liste',
  templateUrl: './liste.page.html',
  styleUrls: ['./liste.page.scss'],
})
export class ListePage implements OnInit {

	private ventes: any;
	private currentOffset: number;
	private shouldDisableInfiniteScroll : boolean;

	constructor(public api: RestApiService, public loadingController: LoadingController) { }

	ngOnInit() {
		this.currentOffset = 0;
		this.ventes = [];
		this.shouldDisableInfiniteScroll = false;
		this.getVentes();
	}

	async getVentes() {
		const loading = await this.loadingController.create({
			message: 'Chargement'
		});

		await loading.present();

		this.loadVentes();

		loading.dismiss();
	}

	async loadData(event) {
		this.currentOffset += 1;

		this.loadVentes();

		if(this.shouldDisableInfiniteScroll)
			event.target.disabled = true;

		event.target.complete();
	}

	async loadVentes() {
		await this.api.getVentes(this.currentOffset)
			.then(async res => {
				console.log(res);

				if(res.length == 0) {
					this.shouldDisableInfiniteScroll = true;
				} else {
					for(let i = 0 ; i < res.length ; i++) {
						await this.api.getLieuById(res[i].idLieu).then(async l => {
							res[i].lieu = l;
							}, err => {
								console.log(err);
							});
						await this.api.getCategVenteById(res[i].idCategVente).then(async cv => {
							res[i].categVente = cv;
							}, err => {
								console.log(err);
							});
						
						this.ventes.push(res[i]);
					}
				}
			}, err => {
				console.log(err);
			});
	}
}
