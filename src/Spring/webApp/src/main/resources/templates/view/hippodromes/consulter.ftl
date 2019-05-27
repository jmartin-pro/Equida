<#include "/layouts/base.ftl"/>

<#assign title="Hippodrome de "+hippodrome.ville>

<#macro content>

    <h2 class="center-align">${hippodrome.ville}</h2>
	
	<p>${hippodrome.rue} - ${hippodrome.codePostal} ${hippodrome.ville}</p>
	<p>T : ${hippodrome.tel}</p>
	<p>F : ${hippodrome.fax}</p>
	<a href="${hippodrome.lien}">${hippodrome.lien}</a>
	
	<!-- Informations sur le secrétariat et map-->
	
	<hr/>
	
	<img src="${hippodrome.lienPlan}"/>
	
	<#if hippodrome.coursesTrot>
		<img src="/assets/img/hippodromes/trot.PNG"/>
	</#if>
		
	<#if hippodrome.coursesObstacles>
		<img src="/assets/img/hippodromes/obstacle.PNG"/>
	</#if>
		
	<#if hippodrome.coursesPlat>
		<img src="/assets/img/hippodromes/galop.PNG"/>
	</#if>
	
</#macro>

<@render_html/>
