import { Component, OnInit } from '@angular/core';
import { RestApiService } from '../../rest-api/rest-api.service';
import { LoadingController, NavController } from '@ionic/angular';

@Component({
  selector: 'app-ajout',
  templateUrl: './ajout.page.html',
  styleUrls: ['./ajout.page.scss'],
})
export class AjoutPage implements OnInit {

	libelle : string

  constructor(private api: RestApiService,
  	private loadingController: LoadingController,
	private navCtrl: NavController) { }

  ngOnInit() {
  }

  async addPays() {
	  const loading = await this.loadingController.create({
	  	message: 'Envoie des informations'
	  });
	  await loading.present();

	  await this.api.addPays(this.libelle)
	  .subscribe(res => {
		  loading.dismiss();
		  this.navCtrl.pop();
	  },
		  err => {
		  console.log(err);
		  loading.dismiss();
	  });
  }

}
