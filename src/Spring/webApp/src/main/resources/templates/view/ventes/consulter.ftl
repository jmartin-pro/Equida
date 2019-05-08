<#include "/layouts/base.ftl"/>

<#assign title=vente.nom>

<#macro content>

    <h2 class="center-align">${vente.nom}</h2>
	
	<#if user?? && user.hasRole("ADMIN")>
		<div>
			<a href="/ventes/update" class="waves-effect waves-light btn green right darken-3">Modifier</a>
		</div>
	</#if>
	
	<div class="row">
		<p>Catégorie : ${vente.categVente.libelle}</p>
		<p>Lieu : ${vente.lieu.ville}</p>
		<p>Date vente : ${vente.dateVente?string["dd/MM/yyyy"]}</p>
		<#if isInscriptionOuverte>
			<p>Les inscriptions sont ouvertes jusqu'au ${vente.dateFin?string["dd/MM/yyyy"]}</p>
		<#else>
			<p>Les inscriptions sont uniquement ouvertes du ${vente.dateDebut?string["dd/MM/yyyy"]} au ${vente.dateFin?string["dd/MM/yyyy"]}</p>
		</#if>
	</div>
	
	<h3>Lots en vente</h3>	
	
	<#if user?? && user.hasRole("USER")>
		<a href="#ajouterCheval" onclick="$('#ajouterChevalVente').show(); $(this).hide();">Ajouter un cheval à la vente</a>
		<div class="row">
			<form class="col s12" id="ajouterChevalVente" style="display: none;" action="/lots/add" method="POST">			
				<#if chevaux?size == 0>
					<p>Vous n'avez plus de chevaux à vendre, vous ne pouvez donc pas en ajouter à cette vente.</p>
				<#else>
					<input type="hidden" value="${vente.id}" name="idVente"/>
					<div class="row">
						<div class="input-field col s12 l6">
							<select name="idCheval" class="validate">
								<#list chevaux as c>
									<option value="${c.id}">${c.nom} - ${c.sire}</option>
								</#list>
							</select>
							<label for="idCheval">Cheval</label>
						</div>

						<div class="input-field col s12 l4">
							<input type="text" class="validate" name="prix"/>
							<label for="prix">Prix</label>
						</div>

						<div class="input-field col s12 l2">
							<input type="submit" value="Inscrire à la vente"/>
						</div>
					</div>
				</#if>
			</form>
		</div>
	</#if>

	<#if lots?size == 0>
		<p>La vente ne possède aucun lot en vente pour le moment.</p>
	<#else>
		<#include "/view/include/lotLister.ftl"/>
	</#if>
</#macro>

<@render_html/>
