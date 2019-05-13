import { Component } from '@angular/core';

import { Platform } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';

@Component({
	selector: 'app-root',
	templateUrl: 'app.component.html'
})
export class AppComponent {
	public appPages = [
		{
			title: 'Accueil',
			url: '/home',
			icon: 'home'
		},
		{
			title: 'Lots',
			url: '/lots',
			icon: 'cart'
		},
		{
			title: 'Ventes',
			url: '/ventes',
			icon: 'paper'
		},
		{
	      title: 'Mes chevaux',
	      url: '/chevaux',
	      icon: 'body'
	    }
	];

	public userAppPages = [
		{
			title: 'User',
			url: '/home',
			icon: 'home'
		},
		{
			title: 'Déconnexion',
			url: '/logout',
			icon: 'exit'
		}
	];

	public adminAppPages = [
		{
			title: 'Admin',
			url: '/home',
			icon: 'home'
		},
		{
			title: 'Déconnexion',
			url: '/logout',
			icon: 'exit'
		}
	];

	constructor(
		private platform: Platform,
		private splashScreen: SplashScreen,
		private statusBar: StatusBar
		) {
		this.initializeApp();
	}

	initializeApp() {
		this.platform.ready().then(() => {
			this.statusBar.styleDefault();
			this.splashScreen.hide();
		});
	}

	getAuthentifiedUserAppPages() {
		if(localStorage.getItem("role") == "ADMIN") {
			return this.adminAppPages;
		} else if(localStorage.getItem("role") == "USER") {
			return this.userAppPages;
		} else {
			return [];
		}
	}
}
