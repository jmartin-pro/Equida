<#include "/layouts/base.ftl"/>

<#macro content>

    <h2 class="center-align">Liste des lieux</h2>
	
	<div>
		<a href="/lieux/add" class="waves-effect waves-light btn green right darken-3">Ajouter</a>
	</div>
	
	<table class="table highlight">
		<thead>
			<th>Ville</th>
                        <th>Nombre de boxes</th>
                        <th>Commentaire</th>
		</thead>
	
		<tbody>
			<#list lieux as l>
				<tr>
					<td>${l.ville}</td>
                                        <td>${l.nbBoxes}</td>
                                        <td>${l.commentaire}</td>
					<td class="rigth table-actions">
						<a href="/lieux/${l.id}/update"><i class="material-icons">create</i></a><a href="/lieux/${l.id}/delete" class="modal-delete-confirm"><i class="material-icons">delete</i></a>
					</td>
				</tr>
			</#list>
		</tbody>
	</table>
</#macro>

<@render_html/>
