package com.equida.webapp.web.form.lot;

import com.equida.common.bdd.entity.Lot;
import com.equida.webapp.web.form.IForm;
import javax.validation.constraints.NotNull;


public abstract class LotsForm extends IForm<Lot> {
	
	private static final String ERROR_PRIX_NULL = "Le champ prix est obligatoire.";
	private static final String ERROR_CHEVAL_NULL = "La sélection du cheval est obligatoire.";
	private static final String ERROR_VENTE_NULL = "L'id de la vente est obligatoire.";
	
	@NotNull(message = ERROR_PRIX_NULL)
	private Float prix;
	
	@NotNull(message = ERROR_CHEVAL_NULL)
	private Long idCheval;
	
	@NotNull(message = ERROR_VENTE_NULL)
	private Long idVente;
	
	public LotsForm(boolean isCreation) {
		super(isCreation);
	}

	@Override
	public void fillFromEntity(Lot entity) {
		this.idCheval = entity.getCheval().getId();
		this.idVente = entity.getVente().getId();
		this.prix = entity.getPrixDepart();
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public Long getIdCheval() {
		return idCheval;
	}

	public void setIdCheval(Long idCheval) {
		this.idCheval = idCheval;
	}

	public Long getIdVente() {
		return idVente;
	}

	public void setIdVente(Long idVente) {
		this.idVente = idVente;
	}
	
}
