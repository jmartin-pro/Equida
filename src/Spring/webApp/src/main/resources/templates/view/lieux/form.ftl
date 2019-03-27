<#include "/layouts/base.ftl"/>

<#macro content>
	<h2 class="center-align"><#if form.isCreation>Ajouter un lieu<#else>Modifier un lieu</#if></h2>
	
	<form class="row" action="" method="POST">
		<div class="col l9 s12">
			<div class="input-field">
				<input class="validate" type="text" id="ville" name="ville" value="<#if form.ville??>${form.ville}</#if>"/>
				<label for="ville">Ville</label>
			</div>
                        <div class="input-field">
				<input class="validate" type="number" id="nbBoxes" name="nbBoxes" value="<#if form.nbBoxes??>${form.nbBoxes}</#if>"/>
				<label for="nbBoxes">Nombre de boxes</label>
			</div>
                        <div class="input-field">
				<input class="validate" type="text" id="commentaire" name="commentaire" value="<#if form.commentaire??>${form.commentaire}</#if>"/>
				<label for="commentaire">Commentaire</label>
			</div>
		</div>
		
		<div class="col l2 s12 center-align">
			<p><button type="submit" class="waves-effect waves-light btn green white-text darken-3">Enregistrer</button></p>
			<p><a href="/lieux">Annuler les modifications</a></p>
		</div>
	</form>
</#macro>

<@render_html/>
