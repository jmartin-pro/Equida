import { Component, OnInit } from '@angular/core';
import { RestApiService } from '../rest-api/rest-api.service';
import { LoadingController } from '@ionic/angular';
import {NavController} from '@ionic/angular';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss']
})
export class LoginPage implements OnInit {

	username: any;
	passwd: any;
	error = "";

	constructor(public navCtrl: NavController, public loadingController: LoadingController, private api: RestApiService) { }

	ngOnInit() {
	}

	async checkCredentials() {
		this.api.saveCredentials(this.username, this.passwd, "");

		const loading = await this.loadingController.create({
			message: 'Connexion en cours...'
		});
		await loading.present();

		try {
			await this.api.checkLogin(this.username, this.passwd).then(role => {
				this.api.saveCredentials(this.username, this.passwd, role.libelle);
				this.navCtrl.navigateForward('/home');
			});
		} catch(ex) {
			this.error = "Le nom d'utilisateur ou le mot de passe est incorrect";
		}

		loading.dismiss();
	}
}
