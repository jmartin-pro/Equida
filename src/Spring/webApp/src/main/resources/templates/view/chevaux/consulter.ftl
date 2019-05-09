<#include "/layouts/base.ftl"/>

<#assign title=cheval.nom>

<#macro content>

    <h2 class="center-align">${cheval.nom}</h2>
	
	<#if user?? && user.hasRole("ADMIN")>
		<div>
			<p><a href="/chevaux/${cheval.id}/update" class="waves-effect waves-light btn green right darken-3">Modifier</a></p>
			<#if lot??>
				<a href="/lots/${lot.id}/valider" class="waves-effect waves-light btn green right darken-3">Accepter</a>
				<a href="/lots/${lot.id}/delete" class="waves-effect waves-light btn green right darken-3">Refuser</a>
			</#if>
		</div>
	</#if>
	
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

</#macro>

<@render_html/>
