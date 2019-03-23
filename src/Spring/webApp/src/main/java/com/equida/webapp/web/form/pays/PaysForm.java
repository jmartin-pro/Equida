package com.equida.webapp.web.form.pays;

import com.equida.common.bdd.entity.Pays;
import com.equida.webapp.web.form.IForm;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


public abstract class PaysForm extends IForm<Pays> {
	
	private static final String ERROR_LIBELLE_NULL = "Le champ libellé est obligatoire.";
	private static final String ERROR_LIBELLE_MAX = "Le champ libellé doit faire entre 2 et 30 caractères.";
	
	@NotNull(message = ERROR_LIBELLE_NULL)
	@Length(min = 2, max = 30, message = ERROR_LIBELLE_MAX)
	private String libelle;

	public PaysForm(boolean isCreation) {
		super(isCreation);
	}

	@Override
	public void fillFromEntity(Pays entity) {
		this.libelle = entity.getLibelle();
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
