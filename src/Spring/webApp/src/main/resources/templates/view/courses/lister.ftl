<#include "/layouts/base.ftl"/>

<#macro content>

    <h2 class="center-align">Liste des courses</h2>
	
	<div>
		<a href="/courses/add" class="waves-effect waves-light btn green right darken-3">Ajouter</a>
	</div>
	
	<table class="table highlight">
		<thead>
			<th>Nom</th>
                        <th>Date de la course</th>
                        <th>Ville</th>
		</thead>
	
		<tbody>
			<#list courses as c>
				<tr>
					<td>${c.nom}</td>
                                        <td>${c.dateCourse}</td>
                                        <td>${c.ville}</td>
					<td class="rigth table-actions">
						<a href="/courses/${c.id}/update"><i class="material-icons">create</i></a><a href="/courses/${c.id}/delete" class="modal-delete-confirm"><i class="material-icons">delete</i></a>
					</td>
				</tr>
			</#list>
		</tbody>
	</table>
</#macro>

<@render_html/>
