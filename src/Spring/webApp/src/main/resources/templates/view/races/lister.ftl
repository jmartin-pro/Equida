<#include "/layouts/base.ftl"/>

<#macro content>

    <h2 class="center-align">Liste des races cheval</h2>
	
	<div>
		<a href="/races/add" class="waves-effect waves-light btn green right darken-3">Ajouter</a>
	</div>
	
	<table class="table highlight">
		<thead>
			<th>Libellé</th>
                        <th>Description</th>
		</thead>
	
		<tbody>
			<#list races as r>
				<tr>
					<td>${r.libelle}</td>
                                        <td>${r.description}</td>
					<td class="rigth table-actions">
						<a href="/races/${r.id}/update"><i class="material-icons">create</i></a><a href="/races/${r.id}/delete" class="modal-delete-confirm"><i class="material-icons">delete</i></a>
					</td>
				</tr>
			</#list>
		</tbody>
	</table>
</#macro>

<@render_html/>
