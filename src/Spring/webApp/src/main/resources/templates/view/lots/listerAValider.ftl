<#include "/layouts/base.ftl"/>

<#macro content>

<#if user?? && user.hasRole("ADMIN")>
    <h2 class="center-align">Liste des lots à valider</h2>
	
	<#list lots as l>
		<div class="row valign-wrapper">
			<div class="col s12 l9">
				<h3>${l.cheval.nom}</h3>
				<p>Sire : ${l.cheval.sire}</p>
				<p>Sexe : ${l.cheval.sexe}</p>
				<p>Vente : ${l.vente.nom}</p>
				<p>Prix : ${l.prixDepart}</p>
			</div>
		
			<div class="col s12 l3">
				<a class="btn waves-effect waves-light green white-text darken-3" href="/chevaux/${l.cheval.id}">Voir plus</a>
			</div>
		
			<hr/>
		</div>
	</#list>
</#if>
	
</#macro>

<@render_html/>