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

	client: any = {};

  constructor(public api: RestApiService,
  public loadingController: LoadingController,
  public route: ActivatedRoute,
  public router: Router) { }

  ngOnInit() {
	  this.getClientById();
  }

  async getClientById() {
	  const loading = await this.loadingController.create({
		  message: 'Chargement'
	  });
	  await loading.present();
	  await this.api.getClientById(this.route.snapshot.paramMap.get('id'))
	  .subscribe(res => {
		  console.log(res);
		  this.client = res;
		  loading.dismiss();
	  }, err => {
		  console.log(err);
		  loading.dismiss();
	  });
  }

}
