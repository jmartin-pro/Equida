<table class="table highlight">
	<thead>
		<th>Client</th>
		<th>Montant</th>
	</thead>

	<tbody>
		<#list encheres as e>
			<tr>
				<td>${e.client.nom}</a></td>
				<td>${e.montant}</td>
				<#if user?? && user.hasRole("ADMIN")>		
					<td class="rigth table-actions">
						<a href="/encheres/${e.lot.cheval.id}/${e.id}/delete" class="modal-delete-confirm"><i class="material-icons">delete</i></a>
					</td>
				</#if>
			</tr>
		</#list>
	</tbody>
</table>