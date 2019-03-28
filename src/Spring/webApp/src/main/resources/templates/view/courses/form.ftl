<#include "/layouts/base.ftl"/>

<#macro content>
	<h2 class="center-align"><#if form.isCreation>Ajouter une course<#else>Modifier une course</#if></h2>
	
	<form class="row" action="" method="POST">
		<div class="col l9 s12">
			<div class="input-field">
				<input class="validate" type="text" id="nom" name="nom" value="<#if form.nom??>${form.nom}</#if>"/>
				<label for="nom">Nom</label>                                
			</div>
                        <div class="input-field">
                                <input class="validate" type="date" id="dateCourse" name="dateCourse" value="<#if form.dateCourseStr??>${form.dateCourseStr}</#if>"/>
				<label for="dateCourse">Date de la course</label>
                        </div>
                        <div class="input-field">
                                <input class="validate" type="text" id="ville" name="ville" value="<#if form.ville??>${form.ville}</#if>"/>
				<label for="ville">Ville</label>
                        </div>
		</div>
		
		<div class="col l2 s12 center-align">
			<p><button type="submit" class="waves-effect waves-light btn green white-text darken-3">Enregistrer</button></p>
			<p><a href="/courses">Annuler les modifications</a></p>
		</div>
	</form>
</#macro>

<@render_html/>
