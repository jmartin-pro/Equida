<#include "/layouts/base.ftl"/>

<#macro content>

    <h2 class="center-align">Liste des catégories de vente</h2>
	
	<div>
		<a href="/categ-ventes/add" class="waves-effect waves-light btn green right darken-3">Ajouter</a>
	</div>
	
	<table class="table highlight">
		<thead>
			<th>Libellé</th>
		</thead>
	
		<tbody>
			<#list categVentes as cv>
				<tr>
					<td>${cv.libelle}</td>
					<td class="rigth table-actions">
						<a href="/categ-ventes/${cv.id}/update"><i class="material-icons">create</i></a><a href="/categ-ventes/${cv.id}/delete" class="modal-delete-confirm"><i class="material-icons">delete</i></a>
					</td>
				</tr>
			</#list>
		</tbody>
	</table>
</#macro>

<@render_html/>
