<#include "/layouts/base.ftl"/>

<#macro content>

	
	<h2 class="center-align"><#if form.isCreation>Ajouter un pays<#else>Modifier un pays</#if></h2>
	
	<form action="" method="POST">
		<input type="text" name="libelle" placeholder="Libellé" value="<#if form.libelle??>${form.libelle}</#if>"/>
		<input type="submit" value="Enregistrer"/>
	</form>
</#macro>

<@render_html/>
