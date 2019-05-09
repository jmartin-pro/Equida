import { Component, OnInit } from '@angular/core';
import { LoadingController } from '@ionic/angular';
import { RestApiService } from '../../rest-api/rest-api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
	selector: 'app-consulter',
	templateUrl: './consulter.page.html',
	styleUrls: ['./consulter.page.scss'],
})
export class ConsulterPage implements OnInit {

	lot: any = null;

	constructor(public api: RestApiService,
		public loadingController: LoadingController,
		public route: ActivatedRoute,
		public router: Router) { }

	async ngOnInit() {
		await this.getLotById();
	}

	async getLotById() {
		await this.api.getLotById(this.route.snapshot.paramMap.get('id'))
			.then(async res => {
				await this.api.getChevalById(res.idCheval).then(async c => {
						res.cheval = c;
						await this.api.getRaceChevalById(res.cheval.idRaceCheval).then(async rc => {
							res.cheval.raceCheval = rc;
						}, err => {
							console.log(err);
						});

					}, err => {
						console.log(err);
					});


				this.lot = res;
			}, err => {
				console.log(err);
			});
	}

}
