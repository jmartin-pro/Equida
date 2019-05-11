package com.equida.webapp.web.form.encheres;

import com.equida.webapp.web.form.encheres.*;
import com.equida.common.bdd.entity.Course;
import com.equida.common.bdd.entity.Enchere;
import com.equida.common.converter.DateConverter;
import com.equida.webapp.web.form.IForm;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public abstract class EncheresForm extends IForm<Enchere> {
	
	private static final String ERROR_CLIENT_NULL = "L'id du client est obligatoire.";
	private static final String ERROR_MONTANT_NULL = "Le montant est obligatoire.";
	
	@NotNull(message = ERROR_CLIENT_NULL)
	private Long idClient;
	
	@NotNull(message = ERROR_MONTANT_NULL)
	private Float montant;
	
	public EncheresForm(boolean isCreation) {
		super(isCreation);
	}

	@Override
	public void fillFromEntity(Enchere entity) {
		this.montant = entity.getMontant();
		
		if(entity.getClient()!= null)
			this.idClient = entity.getClient().getId();
	}
	
	public Float getMontant() {
		return montant;
	}

	public void setMontant(Float montant) {
		this.montant = montant;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
}