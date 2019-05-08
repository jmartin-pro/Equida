<header>
	<nav class="nav-extended">
		<div class="nav-wrapper light-green darken-4">
			<a href="/" class="brand-logo"><img class="brand-logo" src="/assets/img/logo_blanc.png"/></a>
			<a href="#" data-target="mobileNav" class="sidenav-trigger"><i class="material-icons">menu</i></a>
			
			<ul class="menu right hide-on-med-and-down nav-mobile">
				<#if !user??>
					<li><a href="/login"><i class="material-icons left">account_circle</i>Connexion</a></li>
				<#else>
					<li><a href="/logout"><i class="material-icons left">exit_to_app</i>Déconnexion</a></li>
				</#if>
			</ul>
		</div>
		<div class="nav-wrapper light-green darken-3">
			<div class="nav-mobile">
				<ul class="menu right hide-on-med-and-down">
					<#if user?? && user.hasRole("ADMIN")>
						<#-- Liens admin -->
						<li><a href="/pays">Pays</a></li>
						<li><a href="/races">Races</a></li>
						<li><a href="/lieux">Lieux</a></li>
						<li><a href="/lots">Lots en attente</a></li>
						<li><a href="/courses">Courses</a></li>
						<li><a href="/categ-ventes">Catégories de vente</a></li>
					</#if>

					<#if user?? && user.hasRole("USER")>
						<#-- Liens user -->
						<li><a href="/chevaux">Mes chevaux</a></li>
					</#if>

					<#-- Liens publiques -->
					<li><a href="/lots">Lots</a></li>
					<li><a href="/ventes">Ventes</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<ul class="sidenav" id="mobileNav">
	</ul>
</header>