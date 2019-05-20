import { Component, OnInit } from '@angular/core';
import { RestApiService } from '../../rest-api/rest-api.service';
import { NavController } from '@ionic/angular';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-modifier',
  templateUrl: './modifier.page.html',
  styleUrls: ['./modifier.page.scss'],
})
export class ModifierPage implements OnInit {

	idCheval: string;
	nom: string;
	sexe: string;
	sire: string;
	race: string;
	sireMere: string;
	sirePere: string;

	races: any;

	constructor(
		public api: RestApiService,
		private navCtrl: NavController,
		public route: ActivatedRoute) { }

	async ngOnInit() {
		this.idCheval = this.route.snapshot.paramMap.get('id');
		await this.api.getChevalById(this.idCheval)
			.then(async res => {
				this.nom = res.nom;
				this.sexe = res.sexe;
				this.sire = res.sire;
				this.race = res.idRaceCheval;
				this.sireMere = res.sireMere;
				this.sirePere = res.sirePere;
			});

		await this.api.getAll(this.api.getRacesCheval).then(async r => {
			this.races = r;
		});
	}

	async updateCheval() {
		await this.api.updateCheval(this.idCheval, this.nom, this.sexe, this.sire, this.race, this.sireMere, this.sirePere)
			.then(res => {
			this.navCtrl.pop();
		});
	}

}
