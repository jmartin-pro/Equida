<#include "/layouts/base.ftl"/>

<#macro content>

    <h2 class="center-align striped">Liste des pays</h2>
	
	<table class="table highlight">
		<thead>
			<th>Libellé</th>
		</thead>
	
		<tbody>
			<#list pays as p>
				<tr>
					<td>${p.libelle}</td>
					<td class="rigth table-actions">
						<a href=""><i class="material-icons">create</i></a><a href=""><i class="material-icons">delete</i></a>
					</td>
				</tr>
			</#list>
		</tbody>
	</table>
</#macro>

<@render_html/>