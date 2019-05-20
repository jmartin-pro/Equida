import { Component, OnInit } from '@angular/core';
import { RestApiService } from '../../rest-api/rest-api.service';
import { LoadingController, NavController } from '@ionic/angular';
import { ActivatedRoute } from '@angular/router';

@Component({
	selector: 'app-modifier',
	templateUrl: './modifier.page.html',
	styleUrls: ['./modifier.page.scss'],
})
export class ModifierPage implements OnInit {

	categVente : any;
	lieu : any;
	nom : string;
	dateDebut : string;
	dateFin : string;
	dateVente : string;
	idLieu : number;
	idCategVente : number;
	idVente : string;

	constructor(private api: RestApiService,
	private loadingController: LoadingController,
	private navCtrl: NavController,
	public route: ActivatedRoute ) { }

	async ngOnInit() {
		this.idVente = this.route.snapshot.paramMap.get('id');
		await this.api.getVenteById(this.idVente)
			.then(res => {
				console.log(res);
				
				this.nom = res.nom,
				this.dateDebut = this.api.deformatDate(res.dateDebut);
				this.dateFin = this.api.deformatDate(res.dateFin);
				this.dateVente = this.api.deformatDate(res.dateVente);
				this.idLieu = res.idLieu;
				this.idCategVente = res.idCategVente;
			});
		
		await this.api.getAll(this.api.getCategVente)
			.then(async res => {
				this.categVente = res;
			});

		await this.api.getAll(this.api.getLieux)
			.then(async res => {
				this.lieu = res;
			});
	}

	async updateVente() {
		console.log(this.dateDebut);
		const loading = await this.loadingController.create({
			message: 'Envoie des informations'
		});
		await loading.present();

		await this.api.updateVente(this.idVente, this.nom, this.dateDebut, this.dateFin, this.dateVente, this.idLieu, this.idCategVente)
			.then(res => {
			loading.dismiss();
			this.navCtrl.pop();
		},
			err => {
			console.log(err);
			loading.dismiss();
		});
	}
}
