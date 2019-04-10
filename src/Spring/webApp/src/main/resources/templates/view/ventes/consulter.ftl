<#include "/layouts/base.ftl"/>

<#assign title=vente.nom>

<#macro content>

    <h2 class="center-align">${vente.nom}</h2>
	
	<#if user?? && user.hasRole("ADMIN")>
		<div>
			<a href="/ventes/update" class="waves-effect waves-light btn green right darken-3">Modifier</a>
		</div>
	</#if>
	
	<div class="row">
		<p>Catégorie : ${vente.categVente.libelle}</p>
		<p>Lieu : ${vente.lieu.ville}</p>
		<p>Date vente : ${vente.dateVente?string["dd/MM/yyyy"]}</p>
		<#if isInscriptionOuverte>
			<p>Les inscriptions sont ouvertes jusqu'au ${vente.dateFin?string["dd/MM/yyyy"]}</p>
		<#else>
			<p>Les inscriptions sont uniquement ouvertes du ${vente.dateDebut?string["dd/MM/yyyy"]} au ${vente.dateFin?string["dd/MM/yyyy"]}</p>
		</#if>
	</div>
</#macro>

<@render_html/>
