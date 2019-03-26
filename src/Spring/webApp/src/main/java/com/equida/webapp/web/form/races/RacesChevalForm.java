package com.equida.webapp.web.form.races;

import com.equida.common.bdd.entity.RaceCheval;
import com.equida.webapp.web.form.IForm;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public abstract class RacesChevalForm extends IForm<RaceCheval> {
	private static final String ERROR_LIBELLE_NULL = "Le champ libellé est obligatoire.";
	private static final String ERROR_LIBELLE_MAX = "Le champ libellé doit faire entre 2 et 50 caractères.";
	
	private static final String ERROR_DESCRIPTION_NULL = "Le champ description est obligatoire.";
	private static final String ERROR_DESCRIPTION_MAX = "Le champ description doit faire entre 2 et 255 caractères.";
	
	@NotNull(message = ERROR_LIBELLE_NULL)
	@Length(min = 2, max = 50, message = ERROR_LIBELLE_MAX)
	private String libelle;
	
	@NotNull(message = ERROR_DESCRIPTION_NULL)
	@Length(min = 2, max = 255, message = ERROR_DESCRIPTION_MAX)
	private String description;

	public RacesChevalForm(boolean isCreation) {
		super(isCreation);
	}

	@Override
	public void fillFromEntity(RaceCheval entity) {
		this.libelle = entity.getLibelle();
		this.description = entity.getDescription();
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}