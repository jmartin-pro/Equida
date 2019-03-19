<#macro render_html>
    <!DOCTYPE html>
    <html lang="fr">
        <head>

            <title><#if title??>${title} - </#if>Equida</title>

            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <#include "style.ftl"/>

        </head>

        <body>
			<#include "nav.ftl"/>

			<main class="container">
			  <@content/>
			</main>

			<#include "footer.ftl"/>

            <@extra/>

            <#include "script.ftl"/>

        </body>

    </html>
</#macro>

<#macro content>
</#macro>

<#macro extra>
</#macro>
