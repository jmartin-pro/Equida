<#include "/layouts/base.ftl"/>

<#assign title=cheval.nom>

<#macro content>

    <h2 class="center-align">${cheval.nom}</h2>
	
	<#if user?? && user.hasRole("ADMIN")>
		<div>
			<a href="/chevaux/update" class="waves-effect waves-light btn green right darken-3">Modifier</a>
		</div>
	</#if>
	
	<div class="row">
		<p>SIRE : ${cheval.sire}</p>
		<p>Sexe : ${cheval.sexe}</p>
		<p>Race : ${cheval.raceCheval.libelle}</p>
		<p>Propriétaire : ${cheval.client.nom}</p>
		<#if lot?? && lot.validation??>
			<p>Prix : </p>
		<#elseif lot?? && !lot.validation??>
			<p>Ce cheval n'est pas encore validé.</p>
		</#if>
	</div>

</#macro>

<@render_html/>
