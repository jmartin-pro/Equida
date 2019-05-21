import { Component, OnInit } from '@angular/core';

import { LoadingController } from '@ionic/angular';
import { RestApiService } from '../../rest-api/rest-api.service';

@Component({
  selector: 'app-lister',
  templateUrl: './lister.page.html',
  styleUrls: ['./lister.page.scss'],
})
export class ListerPage implements OnInit {

	public role;
  	public chevaux: any;
  	private currentOffset: number;
  	private shouldDisableInfiniteScroll : boolean;

  	constructor(public api: RestApiService, public loadingController: LoadingController) { }

  	ngOnInit() {
		this.role = localStorage.getItem("role");
  		this.currentOffset = 0;
  		this.chevaux = [];
  		this.shouldDisableInfiniteScroll = false;
  		this.getChevaux();
  	}

  	async getChevaux() {
  		const loading = await this.loadingController.create({
  			message: 'Chargement'
  		});

  		await loading.present();

  		this.loadChevaux();

  		loading.dismiss();
  	}

  	async loadData(event) {
  		this.currentOffset += 1;

  		this.loadChevaux();

  		if(this.shouldDisableInfiniteScroll)
  			event.target.disabled = true;

  		event.target.complete();
  	}

  	async loadChevaux() {
  		await this.api.getMesChevaux(this.currentOffset)
  			.then(async res => {
  				console.log(res);

  				if(res.length == 0) {
  					this.shouldDisableInfiniteScroll = true;
  				} else {
  					for(let i = 0 ; i < res.length ; i++) {

						await this.api.getRaceChevalById(res[i].idRaceCheval).then(async rc => {
							res[i].raceCheval = rc;
						}, err => {
							console.log(err);
						});

  						this.chevaux.push(res[i]);
  					}
  				}
  			}, err => {
  				console.log(err);
  			});
  	}
}
