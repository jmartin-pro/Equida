import { Component, OnInit } from '@angular/core';

import { LoadingController } from '@ionic/angular';
import { RestApiService } from '../rest-api.service';

@Component({
	selector: 'app-list',
	templateUrl: 'list.page.html',
	styleUrls: ['list.page.scss']
})

export class ListPage implements OnInit {
	private pays: any;

	public items: Array<{ title: string; note: string; icon: string }> = [];
	constructor(public api: RestApiService, public loadingController: LoadingController) { }

	ngOnInit() {
		this.getPays();
	}

	async getPays() {
		const loading = await this.loadingController.create({
			message: 'Loading'
		});

		await loading.present();
		await this.api.getPays()
		.subscribe(res => {
			console.log(res);
			this.pays = res;
			loading.dismiss();
		}, err => {
			console.log(err);
			loading.dismiss();
		});
	}
}
