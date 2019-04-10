import { Component, OnInit } from '@angular/core';

import { LoadingController } from '@ionic/angular';
import { RestApiService } from '../../rest-api.service';

@Component({
  selector: 'app-lister',
  templateUrl: './lister.page.html',
  styleUrls: ['./lister.page.scss'],
})
export class ListerPage implements OnInit {
	private clients: any;

  constructor(public api: RestApiService, public loadingController: LoadingController) { }

  ngOnInit() {
	  this.getClients();
  }

  async getClients() {
	  const loading = await this.loadingController.create({
		  message: 'Chargement'
	  });

	  await loading.present();
	  await this.api.getClients()
	  .subscribe(res => {
		  console.log(res);
		  this.clients = res;
		  loading.dismiss();
	  }, err => {
		  console.log(err);
		  loading.dismiss();
	  });
  }
}
