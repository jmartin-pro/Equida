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
<<<<<<< HEAD
	{
=======
	{ 
		path: 'ajouter/ventes',
		loadChildren: './ventes/ajouter/ajouter.module#AjouterPageModule' 
	},
	{ 	
>>>>>>> feat : Ajouter une vente
		path: 'consulter',
		loadChildren: './ventes/consulter/consulter.module#ConsulterPageModule'
	},
	{
		path: 'lots',
		loadChildren: './lots/lister/lister.module#ListerPageModule'
	},
	{
		path: 'lots/:id',
		loadChildren: './lots/consulter/consulter.module#ConsulterPageModule'
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
<<<<<<< HEAD
	{
		path: 'ventes',
		loadChildren: './ventes/liste/liste.module#ListePageModule'
=======
	{	
		path: 'ventes', 
		loadChildren: './ventes/lister/lister.module#ListerPageModule'
>>>>>>> feat : Ajouter une vente
	},
	{
		path: 'ventes/:id',
		loadChildren: './ventes/consulter/consulter.module#ConsulterPageModule'
	}
<<<<<<< HEAD
=======

>>>>>>> feat : Ajouter une vente
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule {}
