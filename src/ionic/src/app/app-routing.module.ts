import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
	{
		path: '',
		redirectTo: 'home',
		pathMatch: 'full'
	},
	{
		path: 'home',
		loadChildren: './home/home.module#HomePageModule'
	},
	{
		path: 'ajout/pays',
		loadChildren: './pays/ajout/ajout.module#AjoutPageModule'
	},
	{
		path: 'ajouter/ventes',
		loadChildren: './ventes/ajouter/ajouter.module#AjouterPageModule'
	},
	{ 	
		path: 'ajouterLot/ventes/:id',
		loadChildren: './ventes/ajouterLot/ajouterLot.module#AjouterLotPageModule'
	},
	{
		path: 'consulter',
		loadChildren: './ventes/consulter/consulter.module#ConsulterPageModule'
	},
	{
		path: 'lots',
		loadChildren: './lots/lister/lister.module#ListerPageModule'
	},
	{
		path: 'login',
		loadChildren: './login/login.module#LoginPageModule'
	},
	{
		path: 'logout',
		loadChildren: './logout/logout.module#LogoutPageModule'
	},
	{
		path: 'validerLots',
		loadChildren: './valider_lots/lister/lister.module#ListerPageModule'
	},
	{
		path: 'pays/:id',
		loadChildren: './pays/consulter/pays.module#PaysPageModule'
	},
	{
		path: 'ventes',
		loadChildren: './ventes/lister/lister.module#ListerPageModule'
	},
	{
		path: 'ventes/:id',
		loadChildren: './ventes/consulter/consulter.module#ConsulterPageModule'
	},
	{
		path: 'mesChevaux',
		loadChildren: './mesChevaux/lister/lister.module#ListerPageModule'
	},
	{
		path: 'chevaux/:id',
		loadChildren: './mesChevaux/consulter/consulter.module#ConsulterPageModule'
	},
	{
		path: 'mesChevaux/ajouter', 
		loadChildren: './mesChevaux/ajouter/ajouter.module#AjouterPageModule'
	}


];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule {}
