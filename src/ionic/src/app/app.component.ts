import { Component } from '@angular/core';

import { Platform } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';

@Component({
	selector: 'app-root',
	templateUrl: 'app.component.html'
})
export class AppComponent {
	menuAlt = [];

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
		}
	];

	public userAppPages = [
		{
			title: 'Mes chevaux',
			url: '/mesChevaux',
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
			title: 'Lots à valider',
			url: '/validerLots',
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

	ngDoCheck() {
		this.menuAlt = this.getAuthentifiedUserAppPages();
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
