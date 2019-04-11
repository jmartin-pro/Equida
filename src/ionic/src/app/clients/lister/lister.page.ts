import { Component, OnInit } from '@angular/core';

import { LoadingController } from '@ionic/angular';
import { RestApiService } from '../../rest-api/rest-api.service';

@Component({
  selector: 'app-lister',
  templateUrl: './lister.page.html',
  styleUrls: ['./lister.page.scss'],
})
export class ListerPage implements OnInit {

	private clients: any;
	private currentOffset: number;
	private shouldDisableInfiniteScroll : boolean;

	constructor(public api: RestApiService, public loadingController: LoadingController) { }

	ngOnInit() {
		this.currentOffset = 0;
		this.clients = [];
		this.shouldDisableInfiniteScroll = false;
		this.getClients();
	}

	async getClients() {
		const loading = await this.loadingController.create({
			message: 'Chargement'
		});

		await loading.present();

		this.loadClients();

		loading.dismiss();
	}

	async loadData(event) {
		this.currentOffset += 1;

		this.loadClients();

		if(this.shouldDisableInfiniteScroll)
			event.target.disabled = true;

		event.target.complete();
	}

	async loadClients() {
		await this.api.getClients(this.currentOffset)
			.subscribe(res => {
				console.log(res);

				if(res.length == 0) {
					this.shouldDisableInfiniteScroll = true;
				} else {
					for(let i = 0 ; i < res.length ; i++) {
						this.clients.push(res[i]);
					}
				}
			}, err => {
				console.log(err);
			});
	}
}
