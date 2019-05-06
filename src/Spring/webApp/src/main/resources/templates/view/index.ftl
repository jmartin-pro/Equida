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
			
			<#if lots?size == 0>
				<li class="collection-item">Aucun lot en vente</li>
			</#if>

			<#list lots as l>
				<li class="collection-item">
					<a href="/chevaux/${l.cheval.id}">${l.cheval.nom}</a><br/>
					${l.cheval.raceCheval.libelle}<br/>
					${l.prixDepart}€
				</li>
			</#list>

			<li class="collection-item"><a href="/lots">Voir plus de lots</a></li>
		</ul>

		<ul class="col s12 l6 right collection with-header">
			<li class="collection-header"><h4>Ventes à venir</h4></li>
				
			<#if ventes?size == 0>
				<li class="collection-item">Aucune vente à venir</li>
			</#if>

			<#list ventes as v>
				<li class="collection-item">
					<a href="/ventes/${v.id}">${v.nom}</a><br/>
					${v.categVente.libelle}<br/>
					${v.dateVente?string["dd/MM/yyyy"]}
				</li>
			</#list>

			<li class="collection-item"><a href="/ventes">Voir plus de ventes</a></li>
		</ul>
	</div>
</#macro>

<@render_html/>