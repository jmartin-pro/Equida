<#include "/layouts/base.ftl"/>

<#assign title=utilisateur.nom>

<#macro content>

    <h2 class="center-align">${utilisateur.nom} ${utilisateur.prenom}</h2>
	
	<div>
		<#if user?? && user.hasRole("ADMIN")|| user?? && user.hasRole("USER") && user.compte.utilisateur.id == utilisateur.id >
			<a href="/utilisateurs/${utilisateur.id}/update" class="waves-effect waves-light btn green right darken-3">Modifier</a>
		</#if>
		<#if user?? && user.hasRole("ADMIN")>
			<a href="/utilisateurs/${utilisateur.id}/delete" class="waves-effect waves-light btn red right darken-3">Supprimer</a>
		</#if>
	</div>
	
	<div class="row">
		<p>Rue : ${utilisateur.rue}</p>
		<p>Code postal : ${utilisateur.copos}</p>
		<p>Ville : ${utilisateur.ville}</p>
		<p>Pays : <#if utilisateur.pays??>${utilisateur.pays.libelle}<#else> Non renseigné</#if></p>
		<p>Mail : ${utilisateur.mail}</p>
		<#if utilisateur.compte??>
			<p>Login : ${utilisateur.compte.login}</p>
		<#else>
			<p>Pensez à demander vos identifiants à votre administrateur ou à nous contacter.</p>
		</#if>
	</div>
	
</#macro>

<@render_html/>
