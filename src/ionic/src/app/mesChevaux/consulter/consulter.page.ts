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

	idClient: string;
	cheval: any = null;
	lot: any = null;
	participations: any = null;
	message: string;
	role: string;

	constructor(public api: RestApiService,
		public loadingController: LoadingController,
		public route: ActivatedRoute,
		public router: Router,
		public navCtrl: NavController) { }

	async ngOnInit() {
		this.role = localStorage.getItem("role");
		this.idClient = localStorage.getItem("user-id");

		await this.getLotById();
		await this.getCheval();
		await this.getParticipations();
	}

	async getCheval() {
		await this.api.getChevalById(this.route.snapshot.paramMap.get('id')).then(async c => {
			this.cheval = c;
			await this.api.getRaceChevalById(this.cheval.idRaceCheval).then(async rc => {
					this.cheval.raceCheval = rc;
				}, err => {
					console.log(err);
				});

			if(c.idMere != null)
				await this.api.getChevalById(c.idMere).then(m => {
					this.cheval.mere = m;
				});

			if(c.idPere != null)
				await this.api.getChevalById(c.idPere).then(p => {
					this.cheval.pere = p;
				});

			await this.api.getClientById(c.idClient).then(c => {
				this.cheval.client = c;
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

	async getParticipations() {
		await this.api.getAll(this.api.getParticipationByIdCheval, this.route.snapshot.paramMap.get('id'))
			.then(async res => {
				for(let i = 0 ; i < res.length ; i++) {
					await this.api.getCourseById(res[i].idCourse).then(c => {
						res[i].course = c;
					});
				}

				this.participations = res;
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

	async deleteCheval() {
		await this.api.deleteCheval(this.route.snapshot.paramMap.get('id'));
		this.navCtrl.navigateForward('/mesChevaux');
	}

}
