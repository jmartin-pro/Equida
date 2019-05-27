package com.equida.webapp.web.form.ventes;

import com.equida.common.bdd.entity.Vente;
import com.equida.common.converter.DateConverter;
import com.equida.webapp.web.form.IForm;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public abstract class VentesForm extends IForm<Vente> {
	private static final String ERROR_NOM_NULL = "Le champ nom est obligatoire.";
	private static final String ERROR_NOM_MAX = "Le champ nom doit faire entre 2 et 40 caractères.";
	
	private static final String ERROR_CATEG_VENTE_NULL = "L'id de la categ vente est obligatoire.";
	private static final String ERROR_LIEU_NULL = "L'id du lieu est obligatoire.";
	private static final String ERROR_DATE_DEBUT_NULL = "La date de début ne peut pas être null.";
	private static final String ERROR_DATE_FIN_NULL = "La date de fin ne peut pas être null.";
	private static final String ERROR_DATE_VENTE_NULL = "La date de vente ne peut pas être null.";
	
	@NotNull(message = ERROR_NOM_NULL)
	@Length(min = 2, max = 40, message = ERROR_NOM_MAX)
	private String nom;
	
	@NotNull(message = ERROR_DATE_DEBUT_NULL)
	private Date dateDebut;
	
	@NotNull(message = ERROR_DATE_FIN_NULL)
	private Date dateFin;
	
	@NotNull(message = ERROR_DATE_VENTE_NULL)
	private Date dateVente;
			
	@NotNull(message = ERROR_CATEG_VENTE_NULL)
	private Long idCategVente;

	@NotNull(message = ERROR_LIEU_NULL)
	private Long idLieu;
	
	private DateConverter dateConverter;
	
	public VentesForm(boolean isCreation) {
		super(isCreation);
		
		this.dateConverter = new DateConverter();
	}

	@Override
	public void fillFromEntity(Vente entity) {
		this.nom = entity.getNom();
		this.dateDebut = entity.getDateDebut();
		this.dateFin = entity.getDateFin();
		this.dateVente = entity.getDateVente();
		
		if(entity.getCategVente()!= null)
			this.idCategVente = entity.getCategVente().getId();
		
		if(entity.getLieu()!= null)
			this.idLieu = entity.getLieu().getId();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateConverter.convertToEntityAttribute(dateDebut);
	}

	public Long getIdCategVente() {
		return idCategVente;
	}

	public void setIdCategVente(Long idCategVente) {
		this.idCategVente = idCategVente;
	}

	public Long getIdLieu() {
		return idLieu;
	}

	public void setIdLieu(Long idLieu) {
		this.idLieu = idLieu;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateConverter.convertToEntityAttribute(dateFin);
	}

	public Date getDateVente() {
		return dateVente;
	}

	public void setDateVente(String dateVente) {
		this.dateVente = dateConverter.convertToEntityAttribute(dateVente);
	}

}