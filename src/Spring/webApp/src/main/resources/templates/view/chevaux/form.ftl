<#include "/layouts/base.ftl"/>

<#macro content>
	<h2 class="center-align"><#if form.isCreation>Ajouter <#else>Modifier </#if>un cheval</h2>
	
	<form class="row" action="" method="POST">
		<div class="col l9 s12">
			<div class="input-field">
				<input class="validate" type="text" id="nom" name="nom" value="<#if form.nom??>${form.nom}</#if>"/>
				<label for="nom">Nom</label>                                
			</div>
			
			<div class="input-field s12 l3">
				<select name="sexe">
					<option value="M">Mâle</option>
					<option value="F">Femelle</option>
				</select>
				<label for="sexe">Sexe</label> 
			</div>
			
			<div class="s12 l6 input-field">
				<input class="validate" type="text" id="sire" name="sire" value="<#if form.sire??>${form.sire}</#if>"/>
				<label for="sire">Sire</label>
			</div>
			
			<div class="input-field">
				<select name="idRaceCheval">
					<#list races as r>
						<option value="${r.id}" <#if form.idRaceCheval?? && r.id == form.idRaceCheval>selected</#if>>${r.libelle}</option>
					</#list>
				</select>
				<label for="idRaceCheval">Race cheval</label>
			</div>
			
			<div class="input-field">
				<input class="validate" type="text" id="sireMere" name="sireMere" value="<#if form.sireMere??>${form.sireMere}</#if>"/>
				<label for="sireMere">Sire de la mère</label>
			</div>
			
			<div class="input-field">
				<input class="validate" type="text" id="sirePere" name="sirePere" value="<#if form.sirePere??>${form.sirePere}</#if>"/>
				<label for="sirePere">Sire du père</label>
			</div>
		</div>
		
		<div class="col l2 s12 center-align">
			<p><button type="submit" class="waves-effect waves-light btn green white-text darken-3">Enregistrer</button></p>
			<p><a href="/chevaux">Annuler les modifications</a></p>
		</div>
	</form>
</#macro>

<@render_html/>
