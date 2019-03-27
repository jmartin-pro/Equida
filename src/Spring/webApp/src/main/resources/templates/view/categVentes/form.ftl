<#include "/layouts/base.ftl"/>

<#macro content>
	<h2 class="center-align"><#if form.isCreation>Ajouter une catégorie de vente<#else>Modifier une catégorie de vente</#if></h2>
	
	<form class="row" action="" method="POST">
		<div class="col l9 s12">
			<div class="input-field">
				<input class="validate" type="text" id="libelle" name="libelle" value="<#if form.libelle??>${form.libelle}</#if>"/>
				<label for="libelle">Libellé</label>
			</div>
		</div>
		
		<div class="col l2 s12 center-align">
			<p><button type="submit" class="waves-effect waves-light btn green white-text darken-3">Enregistrer</button></p>
			<p><a href="/categ-ventes">Annuler les modifications</a></p>
		</div>
	</form>
</#macro>

<@render_html/>
