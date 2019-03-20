<#include "/layouts/base.ftl"/>

<#macro content>
	<h1 class="center-align">Bienvenue sur Equida!</h1>

	<div class="row">
		<div class="col s12 carousel carousel-slider">
			<a class="carousel-item" href="#one!"><img class="responsive-img" src="/assets/img/1.jpg"></a>
			<a class="carousel-item" href="#two!"><img class="responsive-img" src="/assets/img/2.jpg"></a>
			<a class="carousel-item" href="#three!"><img class="responsive-img" src="/assets/img/3.jpg"></a>
		</div>
	</div>

	<div class="row">
		<ul class="col s12 l6 left collection with-header">
			<li class="collection-header"><h4>Nouveaux chevaux</h4></li>
			
			<li class="collection-item">
				<p>
					<a href="#">Nom cheval</a><br/>
					Race<br/>
					Prix€
				</p>
			</li>
			<li class="collection-item"><a href="/lots">Plus d'infos</a></li>
		</ul>

		<ul class="col s12 l6 right collection with-header">
			<li class="collection-header"><h4>Ventes à venir</h4></li>
				
			<li class="collection-item">
				<p>
					<a href="#">Nom vente</a><br/>
					Categorie vente<br/>
					date ouverture
				</p>
			</li>
			
			<li class="collection-item"><a href="/ventes">Plus d'infos</a></li>
		</ul>
	</div>
</#macro>

<@render_html/>