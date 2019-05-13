import { Component, OnInit } from '@angular/core';
import { RestApiService } from '../rest-api/rest-api.service';
import {NavController} from '@ionic/angular';


@Component({
  selector: 'app-logout',
  templateUrl: './logout.page.html',
  styleUrls: ['./logout.page.scss'],
})
export class LogoutPage implements OnInit {

  constructor(public navCtrl: NavController, private api: RestApiService) { }

  ngOnInit() {
	  this.api.removeCredentials();
	  this.navCtrl.navigateForward('/home');
  }

}
