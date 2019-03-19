<#if messages??>
    <ul class="messages messages--info">
        <#list messages>
            <#items as msg>
                <li class="msg">${msg}</li>
            </#items>
        </#list>
    </ul>
</#if>

<#if errors??>
    <ul class="messages messages--error">
        <#list errors?values as error>
            <li class="msg">${error}</li>
        </#list>
    </ul>
</#if>