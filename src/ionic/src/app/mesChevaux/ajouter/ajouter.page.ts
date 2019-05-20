import { Component, OnInit } from '@angular/core';
import { RestApiService } from '../../rest-api/rest-api.service';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-ajouter',
  templateUrl: './ajouter.page.html',
  styleUrls: ['./ajouter.page.scss'],
})
export class AjouterPage implements OnInit {

	nom: string;
	sexe: string;
	sire: string;
	race: string;
	sireMere: string;
	sirePere: string;

	races: any;

	constructor(public api: RestApiService,
	private navCtrl: NavController) { }

	async ngOnInit() {
		await this.api.getAll(this.api.getRacesCheval).then(async r => {
			this.races = r;
		});
	}

	async addCheval() {
		await this.api.addCheval(this.nom, this.sexe, this.sire, this.race, this.sireMere, this.sirePere)
			.then(res => {
			this.navCtrl.pop();
		});
	}

}
