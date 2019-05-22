<#include "/layouts/base.ftl"/>

<#assign title=cheval.nom>

<#macro content>

    <h2 class="center-align">${cheval.nom}</h2>
	
	<div>
		<#if user?? && user.hasRole("USER") && user.compte.utilisateur.id == cheval.client.id >
			<a href="/chevaux/${cheval.id}/delete" class="waves-effect waves-light btn red right darken-3">Supprimer</a>
		</#if>
		<#if user?? && user.hasRole("USER") && user.compte.utilisateur.id == cheval.client.id >
			<a href="/chevaux/${cheval.id}/update" class="waves-effect waves-light btn green right darken-3">Modifier</a>
		</#if>
		<#if user?? && user.hasRole("ADMIN")>
			<#if lot??>
				<a href="/lots/${lot.id}/delete" class="waves-effect waves-light btn red right darken-3">Refuser</a>
				<a href="/lots/${lot.id}/valider" class="waves-effect waves-light btn green right darken-3">Accepter</a>
			</#if>
		</#if>
	</div>
	
	<div class="row">
		<p>SIRE : ${cheval.sire}</p>
		<p>Sexe : ${cheval.sexe}</p>
		<p>Race : ${cheval.raceCheval.libelle}</p>
		<p>Pere : <#if cheval.pere??><a href="/chevaux/${cheval.pere.id}">${cheval.pere.nom}</a> <#else> Non renseigné</#if></p>
		<p>Mere : <#if cheval.mere??><a href="/chevaux/${cheval.mere.id}">${cheval.mere.nom}</a> <#else> Non renseignée</#if></p>
		<p>Propriétaire : ${cheval.client.nom}</p>
		<#if lot?? && lot.validation??>
			<p>Prix : ${lot.prixDepart}</p>
			<p> Vente : <a href="/ventes/${lot.vente.id}">${lot.vente.nom}</a></p>
		<#elseif lot?? && !lot.validation??>
			<p>Ce cheval n'est pas encore validé.</p>
		</#if>
	</div>
	
	<h3>Les courses</h3>
	
	<#if participations?size != 0>
		<div class="row">
			<table class="table highlight">
				<thead>
					<th>Nom course</th>
					<th>Ville</th>
					<th>Date</th>
					<th>Classement</th>
				</thead>

				<tbody>
					<#list participations as p>
						<tr>
							<td>${p.course.nom}</td>
							<td>${p.course.ville}</td>
							<td>${p.course.dateCourse?string["dd/MM/YYYY"]}</td>
							<td>${p.classement}</td>
						</tr>
					</#list>
				</tbody>
			</table>
		</div>
	<#else>
		<p>Ce cheval n'a participé à aucune course.</p>
	</#if>
	
	<#if encheres??>
		<h3>Les enchères</h3>

		<#if user?? && user.hasRole("ADMIN")>		
			<div>
				<a href="/encheres/${lot.id}/add" class="waves-effect waves-light btn green right darken-3">Ajouter</a>
			</div>
		</#if>

		<#if encheres?size == 0>
			<p>Ce cheval n'a pas encore d'enchères</p>
		<#else>
			<#include "/view/encheres/lister.ftl"/>
		</#if>
	</#if>

</#macro>

<@render_html/>
