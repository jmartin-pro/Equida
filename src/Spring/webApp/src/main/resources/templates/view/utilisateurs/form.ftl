<#include "/layouts/base.ftl"/>

<#macro content>
	<h2 class="center-align"><#if form.isCreation>Ajouter <#else>Modifier </#if>un utilisateur</h2>
	
	<form class="row" action="" method="POST">
		<div class="col l9 s12">
			<div class="input-field">
				<input class="validate" type="text" id="nom" name="nom" value="<#if form.nom??>${form.nom}</#if>"/>
				<label for="nom">Nom</label>                                
			</div>
			<div class="s12 l6 input-field">
				<input class="validate" type="text" id="prenom" name="prenom" value="<#if form.prenom??>${form.prenom}</#if>"/>
				<label for="prenom">Prenom</label>
			</div>
			<div class="s12 l6 input-field">
				<input class="validate" type="text" id="mail" name="mail" value="<#if form.mail??>${form.mail}</#if>"/>
				<label for="mail">Mail</label>
			</div>
			<div class="s12 l6 input-field">
				<input class="validate" type="text" id="rue" name="rue" value="<#if form.rue??>${form.rue}</#if>"/>
				<label for="rue">Rue</label>
			</div>
			<div class="s12 l6 input-field">
				<input class="validate" type="text" id="copos" name="copos" value="<#if form.copos??>${form.copos}</#if>"/>
				<label for="copos">Code postal</label>
			</div>
			<div class="s12 l6 input-field">
				<input class="validate" type="text" id="ville" name="ville" value="<#if form.ville??>${form.ville}</#if>"/>
				<label for="ville">Ville</label>
			</div>
			<div class="input-field">
				<select name="idPays">
					<#list pays as p>
						<option value="${p.id}" <#if form.idPays?? && p.id == form.idPays>selected</#if>>${p.libelle}</option>
					</#list>
				</select>
				<label for="idPays">Pays</label>
			</div>
			<div class="s12 l6 input-field">
				<input class="validate" type="text" id="login" name="login" value="<#if form.login??>${form.login}</#if>"/>
				<label for="login">Login</label>
			</div>
			<div class="s12 l6 input-field">
				<input class="validate" type="password" id="mdp" name="mdp"/>
				<label for="mdp">Mot de passe</label>
			</div>
			<div class="input-field">
				<select name="idRole">
					<#list roles as r>
						<option value="${r.id}" <#if form.idRole?? && r.id == form.idRole>selected</#if>>${r.libelle}</option>
					</#list>
				</select>
				<label for="idRole">Role</label>
			</div>
		</div>
		
		<div class="col l2 s12 center-align">
			<p><button type="submit" class="waves-effect waves-light btn green white-text darken-3">Enregistrer</button></p>
			<p><a href="/utilisateurs">Annuler les modifications</a></p>
		</div>
	</form>
</#macro>
	
<@render_html/>
