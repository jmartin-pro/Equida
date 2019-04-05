<#include "/layouts/base.ftl"/>

<#macro content>
	<h2 class="center-align">Connexion</h2>
	
	<form class="row" action="" method="POST">
		<div class="col s12">
			<div class="input-field">
				<input class="validate" type="text" id="username" name="username"/>
				<label for="username">Login</label>
			</div>
			<div class="input-field">
				<input class="validate" type="password" id="password" name="password"/>
				<label for="password">Mot de passe</label>
			</div>
		</div>
		
		<div class="col s12 center-align">
			<button type="submit" class="waves-effect waves-light btn green white-text darken-3">Connexion</button>
		</div>
	</form>
</#macro>

<@render_html/>