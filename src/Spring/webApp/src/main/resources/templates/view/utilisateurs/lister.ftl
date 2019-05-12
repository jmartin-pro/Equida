<#include "/layouts/base.ftl"/>

<#macro content>

    <h2 class="center-align">Les utilisateurs</h2>
	
	<div>
		<a href="/utilisateurs/add" class="waves-effect waves-light btn green right darken-3">Ajouter</a>
	</div>
	
	<table class="table highlight">
		<thead>
			<th>Nom</th>
            <th>Prenom</th>
            <th>Mail</th>
            <th>Login</th>
			<th>Role</th>
		</thead>
	
		<tbody>
			<#list utilisateurs as u>
				<tr>
					<td><a href="/utilisateurs/${u.id}">${u.nom}</a></td>
					<td>${u.prenom}</td>
					<td>${u.mail}</td>
					<#if u.compte?? >
						<td>${u.compte.login}</td>
						<td>${u.compte.role.libelle}</td>
					<#else>
						<td>Non renseigné</td>
						<td>Non renseigné</td>
					</#if>
					<td class="rigth table-actions">
						<a href="/utilisateurs/${u.id}/update"><i class="material-icons">create</i></a><a href="/utilisateurs/${u.id}/delete" class="modal-delete-confirm"><i class="material-icons">delete</i></a>
					</td>
				</tr>
			</#list>
		</tbody>
	</table>
</#macro>

<@render_html/>
