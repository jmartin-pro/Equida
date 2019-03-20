<#include "/layouts/base.ftl"/>

<#global title="Oups ! Une erreur est survenue">

<#macro content>

	<p>Une erreur est survenue...</p>
    <p>Nous nous efforçons de corriger le problème.</p>
    <p>Si le problème persiste, merci de contacter votre administrateur.</p>

    <!--
        <#if url?? && exception??>
            Failed URL: ${url}
            Exception:  ${exception.message}
            <#list exception.stackTrace as trace>
                ${trace}
            </#list>
        <#else>
            No trace!
        </#if>
    -->

</#macro>

<@render_html/>