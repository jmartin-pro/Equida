<#include "/layouts/base.ftl"/>

<#macro content>
	<h2 class="center-align"><#if form.isCreation>Ajouter <#else>Modifier </#if>une vente</h2>
	
	<form class="row" action="" method="POST">
		<div class="col l9 s12">
			<div class="input-field">
				<input class="validate" type="text" id="nom" name="nom" value="<#if form.nom??>${form.nom}</#if>"/>
				<label for="nom">Nom</label>                                
			</div>
			
			<div class="input-field">
				<select name="idCategVente">
					<#list categVentes as cv>
						<option value="${cv.id}" <#if form.idCategVente?? && cv.id == form.idCategVente>selected</#if>>${cv.id}</option>
					</#list>
				</select>
				<label for="idCategVente">Catégorie vente</label>
			</div>
			
			<div class="input-field">
				<select name="idLieu">
					<#list lieux as l>
						<option value="${l.id}" <#if form.idLieu?? && l.id == form.idLieu>selected</#if>>${l.id}</option>
					</#list>
				</select>
				<label for="idLieu">Lieu vente</label>
			</div>
			
			<div class="input-field">
				<input class="validate" type="date" id="dateDebut" name="dateDebut" value="<#if form.dateDebut??>${form.dateDebut?string["yyyy-MM-dd"]}</#if>"/>
				<label for="dateDebut">Date de début des inscriptions</label>
			</div>
			<div class="input-field">
				<input class="validate" type="date" id="dateFin" name="dateFin" value="<#if form.dateFin??>${form.dateFin?string["yyyy-MM-dd"]}</#if>"/>
				<label for="dateFin">Date de fin des inscriptions</label>
			</div>
			<div class="input-field">
				<input class="validate" type="date" id="dateVente" name="dateVente" value="<#if form.dateVente??>${form.dateVente?string["yyyy-MM-dd"]}</#if>"/>
				<label for="dateVente">Date de la vente</label>
			</div>
		</div>
		
		<div class="col l2 s12 center-align">
			<p><button type="submit" class="waves-effect waves-light btn green white-text darken-3">Enregistrer</button></p>
			<p><a href="/ventes">Annuler les modifications</a></p>
		</div>
	</form>
</#macro>

<@render_html/>
