<#if messages??>
	<ul class="browser-default messages-info">
		<#list messages as msg>
			<li>${msg}</li>
		</#list>
	</ul>
</#if>

<#if errors??>
	<ul class="browser-default messages-error">
		<#list errors?values as error>
			<li>${error}</li>
		</#list>
	</ul>
</#if>