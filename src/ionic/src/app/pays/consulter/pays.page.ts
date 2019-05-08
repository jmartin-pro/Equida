import { Component, OnInit } from '@angular/core';
import { LoadingController } from '@ionic/angular';
import { RestApiService } from '../../rest-api/rest-api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
	selector: 'app-pays',
	templateUrl: './pays.page.html',
	styleUrls: ['./pays.page.scss'],
})
export class PaysPage implements OnInit {

	pays: any = {};

	constructor(public api: RestApiService,
	public loadingController: LoadingController,
	public route: ActivatedRoute,
	public router: Router) { }

	ngOnInit() {
		this.getPaysById();
	}
	async getPaysById() {
		const loading = await this.loadingController.create({
			message: 'Loading'
		});
		await loading.present();
		await this.api.getPaysById(this.route.snapshot.paramMap.get('id'))
		.then(res => {
			console.log(res);
			this.pays = res;
			loading.dismiss();
		}, err => {
			console.log(err);
			loading.dismiss();
		});
	}

	async deletePays() {
		const loading = await this.loadingController.create({
			message: 'Envoi des informations'
		});
		await loading.present();
		await this.api.deletePays(this.route.snapshot.paramMap.get('id'))
		.then(res => {
			console.log(res);
			loading.dismiss();
		}, err => {
			console.log(err);
			loading.dismiss();
		});
	}
}
