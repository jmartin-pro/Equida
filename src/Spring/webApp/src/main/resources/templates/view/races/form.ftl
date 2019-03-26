<#include "/layouts/base.ftl"/>

<#macro content>
	<h2 class="center-align"><#if form.isCreation>Ajouter une race cheval<#else>Modifier une race cheval</#if></h2>
	
	<form class="row" action="" method="POST">
		<div class="col l9 s12">
			<div class="input-field">
				<input class="validate" type="text" id="libelle" name="libelle" value="<#if form.libelle??>${form.libelle}</#if>"/>
				<label for="libelle">Libellé</label>                                
			</div>
                        <div class="input-field">
                                <input class="validate" type="text" id="description" name="description" value="<#if form.description??>${form.description}</#if>"/>
				<label for="description">Description</label>
                        </div>
		</div>
		
		<div class="col l2 s12 center-align">
			<p><button type="submit" class="waves-effect waves-light btn green white-text darken-3">Enregistrer</button></p>
			<p><a href="/pays">Annuler les modifications</a></p>
		</div>
	</form>
</#macro>

<@render_html/>
