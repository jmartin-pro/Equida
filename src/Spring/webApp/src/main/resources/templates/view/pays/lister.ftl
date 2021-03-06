<#include "/layouts/base.ftl"/>

<#macro content>

    <h2 class="center-align">Liste des pays</h2>
	
	<div>
		<a href="/pays/add" class="waves-effect waves-light btn green right darken-3">Ajouter</a>
	</div>
	
	<table class="table highlight">
		<thead>
			<th>Libellé</th>
		</thead>
	
		<tbody>
			<#list pays as p>
				<tr>
					<td>${p.libelle}</td>
					<td class="rigth table-actions">
						<a href="/pays/${p.id}/update"><i class="material-icons">create</i></a><a href="/pays/${p.id}/delete" class="modal-delete-confirm"><i class="material-icons">delete</i></a>
					</td>
				</tr>
			</#list>
		</tbody>
	</table>
</#macro>

<@render_html/>
