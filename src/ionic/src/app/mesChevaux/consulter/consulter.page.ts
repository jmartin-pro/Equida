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

	cheval: any = null;
	lot: any = null;
	message: string;
	role: string;

	constructor(public api: RestApiService,
		public loadingController: LoadingController,
		public route: ActivatedRoute,
		public router: Router) { }

	async ngOnInit() {
		this.role = localStorage.getItem("role");

		await this.getLotById();
		await this.getCheval();
	}

	async getCheval() {
		await this.api.getChevalById(this.route.snapshot.paramMap.get('id')).then(async c => {
			this.cheval = c;
			await this.api.getRaceChevalById(this.cheval.idRaceCheval).then(async rc => {
					this.cheval.raceCheval = rc;
				}, err => {
					console.log(err);
				});
			}, err => {
				console.log(err);
			});
	}

	async getLotById() {
		await this.api.getLotByChevalId(this.route.snapshot.paramMap.get('id'))
			.then(async res => {
				if(res != null)
					this.lot = res;
			}, err => {
				console.log(err);
			});
	}

	async acceptLot() {
		let idLot = this.lot.id;
		await this.api.acceptLot(idLot).then(res => {
				this.message = "Le lot à été ajouté à la vente";
			}, err => {
				console.log(err);
			}
		);
	}

	async denyLot() {
		let idLot = this.lot.id;
		await this.api.denyLot(idLot).then(res => {
				this.message = "Le lot à été refusé à la vente";
			}, err => {
				console.log(err);
			}
		);
	}

}
