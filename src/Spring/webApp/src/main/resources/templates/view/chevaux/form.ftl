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
		<div class="col l9 s12">
			<div class="input-field col s6">
				<select id="idCourse">
					<#list courses as c>
						<option value="${c.id}">${c.nom} - ${c.ville} ${c.dateCourse?string["dd/MM/YYYY"]}</option>
					</#list>
				</select>
				<label for="idCourse">Course</label>
			</div>

			<div class="input-field col s6">
				<input class="validate" id="classementCourse" type="number"/>
				<label for="classementCourse">Classement de la course</label>
			</div>

			<button class="waves-effect waves-light btn green white-text darken-3" id="ajouterCourse">Ajouter la course</button>

			<div class="collection" id="listeCourses">
				<#if form.classement??>
					<#assign i=0/>
					<#list form.classement as c>
						<a href="#" class="collection-item"><input name="idCourse[]" type="hidden" value="${form.idCourse[i]}"><input name="classement[]" type="hidden" value="${c}"><span class="badge">X</span>${form.course[i]} - Position : ${c}</a>
						<#assign i=i+1/>
					</#list>
				</#if>
			</div>
		</div>
		
		<div class="col l2 s12 center-align">
			<p><button type="submit" class="waves-effect waves-light btn green white-text darken-3">Enregistrer</button></p>
			<#if user?? && user.hasRole("ADMIN")>
				<p><a href="/lots">Annuler les modifications</a></p>
			<#else>
				<p><a href="/chevaux">Annuler les modifications</a></p>
			</#if>
		</div>
	</form>
</#macro>
	
<#macro extra>
	<script src="/assets/js/chevaux/courses.js"></script>
</#macro>

<@render_html/>
