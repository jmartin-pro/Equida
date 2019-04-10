<#include "/layouts/base.ftl"/>

<#macro content>

    <h2 class="center-align">Liste des ventes</h2>
	
	<#if user?? && user.hasRole("ADMIN")>
		<div>
			<a href="/ventes/add" class="waves-effect waves-light btn green right darken-3">Ajouter</a>
		</div>
	</#if>
	
	<#list ventes as v>
		<div class="row valign-wrapper">
			<div class="col s12 l9">
				<h3>${v.nom}</h3>
				<p>Catégorie : ${v.categVente.libelle}</p>
				<p>Lieu : ${v.lieu.ville}</p>
				<p>Date vente : ${v.dateVente?string["dd/MM/yyyy"]}</p>
				<p>Inscription : ${v.dateDebut?string["dd/MM/yyyy"]} - ${v.dateFin?string["dd/MM/yyyy"]}</p>
			</div>
		
			<div class="col s12 l3">
				<a class="btn waves-effect waves-light green white-text darken-3" href="/ventes/${v.id}">Voir plus</a>
			</div>
		
			<hr/>
		</div>
	</#list>
</#macro>

<@render_html/>
