<#include "/layouts/base.ftl"/>

<#macro content>

    <h2 class="center-align">Mes chevaux</h2>
	
	<div>
		<a href="/chevaux/add" class="waves-effect waves-light btn green right darken-3">Ajouter</a>
	</div>
	
	<table class="table highlight">
		<thead>
			<th>Nom</th>
            <th>Sexe</th>
            <th>Race</th>
            <th>Sire</th>
		</thead>
	
		<tbody>
			<#list chevaux as c>
				<tr>
					<td>${c.nom}</td>
					<td>${c.sexe}</td>
					<td><a class="tooltipped" data-position="bottom" data-tooltip="${c.raceCheval.description}">${c.raceCheval.libelle}</a></td>
					<td>${c.sire}</td>
					<td class="rigth table-actions">
						<a href="/chevaux/${c.id}/update"><i class="material-icons">create</i></a><a href="/chevaux/${c.id}/delete" class="modal-delete-confirm"><i class="material-icons">delete</i></a>
					</td>
				</tr>
			</#list>
		</tbody>
	</table>
</#macro>

<@render_html/>
