<div class="row row-eq-height">
    <div class="col s12">
        <#list lots as lot>
			<div class="col s12 m4 l3">
				<div class="card">
					<div class="card-image">
						<img src="/assets/img/2.jpg">
						<span class="card-title">${lot.cheval.nom}</span>
					</div>
					
					<div class="card-content">
						<p>Race : ${lot.cheval.raceCheval.libelle}</p>
						<p>Sexe : ${lot.cheval.sexe}</p>
						<p>Prix de départ : ${lot.prixDepart}€</p>
					</div>
					
					<div class="card-action">
						<a href="/chevaux/${lot.cheval.id}">Voir plus</a>
					</div>
				</div>
			</div>
        </#list>
    </div>
</div>