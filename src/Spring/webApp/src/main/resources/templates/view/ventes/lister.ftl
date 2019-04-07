<#include "/layouts/base.ftl"/>

<#macro content>

    <h2 class="center-align">Liste des ventes</h2>
	
	<#if user?? && user.hasRole("ADMIN")>
		<div>
			<a href="/ventes/add" class="waves-effect waves-light btn green right darken-3">Ajouter</a>
		</div>
	</#if>
	
	<div class="row">
		<#list ventes as v>
			<h3>${v.nom}</h3>
			<p>Catégorie : ${v.categVente.libelle}</p>
			<p>Lieu : ${v.lieu.ville}</p>
			<p>Date vente: ${v.dateVente?string["dd/MM/yyyy"]}</p>
			<p>Inscription : ${v.dateDebut?string["dd/MM/yyyy"]} - ${v.dateFin?string["dd/MM/yyyy"]}</p>
			<hr/>
		</#list>
	</div>
</#macro>

<@render_html/>
