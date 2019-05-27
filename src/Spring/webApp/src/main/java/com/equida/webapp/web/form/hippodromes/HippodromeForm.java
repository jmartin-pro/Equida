package com.equida.webapp.web.form.hippodromes;

import com.equida.common.bdd.entity.Hippodrome;
import com.equida.common.bdd.entity.Vente;
import com.equida.common.converter.DateConverter;
import com.equida.webapp.web.form.IForm;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public abstract class HippodromeForm extends IForm<Hippodrome> {
	private static final String ERROR_VILLE_NULL = "Le champ ville est obligatoire.";
	private static final String ERROR_VILLE_MAX = "Le champ ville doit faire entre 2 et 50 caractères.";
	
	private static final String ERROR_RUE_NULL = "Le champ ville est obligatoire.";
	private static final String ERROR_RUE_MAX = "Le champ ville doit faire entre 2 et 50 caractères.";
	
	
	@NotNull(message = ERROR_VILLE_NULL)
	@Length(min = 2, max = 50, message = ERROR_VILLE_MAX)
	private String ville;
	
	@NotNull(message = ERROR_VILLE_NULL)
	@Length(min = 2, max = 50, message = ERROR_VILLE_MAX)
	private String rue;
	
	@NotNull(message = ERROR_VILLE_NULL)
	@Length(min = 2, max = 50, message = ERROR_VILLE_MAX)
	private String codePostal;
	
	@NotNull(message = ERROR_VILLE_NULL)
	@Length(min = 2, max = 50, message = ERROR_VILLE_MAX)
	private String tel;
			
	@NotNull(message = ERROR_VILLE_NULL)
	@Length(min = 2, max = 50, message = ERROR_VILLE_MAX)
	private String fax;

	@NotNull(message = ERROR_VILLE_NULL)
	@Length(min = 2, max = 50, message = ERROR_VILLE_MAX)
	private String lien;
	
	@NotNull(message = ERROR_VILLE_NULL)
	@Length(min = 2, max = 50, message = ERROR_VILLE_MAX)
	private Boolean coursesTrot;

	public HippodromeForm(boolean isCreation) {
		super(isCreation);
	}
	
	
	
}