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
		path: 'pays/:id',
		loadChildren: './pays/consulter/pays.module#PaysPageModule'
	},
	{
		path: 'ajout/pays',
		loadChildren: './pays/ajout/ajout.module#AjoutPageModule'
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
	}
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule {}
