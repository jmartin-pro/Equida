<#include "/layouts/base.ftl"/>

<#macro content>
	
	<h2>Ajouter une enchère</h2>
	
	<form class="row" action="" method="POST">
		<div class="col l9 s12">
			
			<div class="input-field">
				<select name="idClient">
					<#list clients as c>
						<option value="${c.id}" <#if form.idClient?? && c.id == form.idClient>selected</#if>>${c.nom}</option>
					</#list>
				</select>
				<label for="idClient">Client</label>
			</div>
			
			<div class="s12 l6 input-field">
				<input class="validate" type="text" id="montant" name="montant" value="<#if form.montant??>${form.montant}</#if>"/>
				<label for="montant">Montant</label>
			</div>
			<div><button type="submit" class="waves-effect waves-light btn green white-text darken-3">Enregistrer</button></div>
		</div>
	</form>
	
	<h2>Liste des enchères</h2>
	<#if encheres?size == 0>
		<p>Ce cheval n'a pas encore d'enchères.</p>
	<#else>
		<#include "/view/encheres/lister.ftl"/>
	</#if>
</#macro>

<@render_html/>
