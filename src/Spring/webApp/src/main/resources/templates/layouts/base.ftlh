<#macro render_html>
    <!DOCTYPE html>
    <html lang="fr">
        <head>

            <title><#if title??>${title} - </#if>Equida</title>

            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <#include "style.ftlh"/>

        </head>

        <body>
			<main class="container">
			  <@content/>
			</main>

            <@extra/>

            <#include "script.ftlh"/>

        </body>

    </html>
</#macro>

<#macro content>
</#macro>

<#macro extra>
</#macro>
