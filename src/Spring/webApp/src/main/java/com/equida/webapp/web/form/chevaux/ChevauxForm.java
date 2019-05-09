package com.equida.webapp.web.form.chevaux;

import com.equida.common.bdd.entity.Cheval;
import com.equida.common.bdd.entity.Participer;
import com.equida.common.utils.DateUtils;
import com.equida.webapp.web.form.IForm;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public abstract class ChevauxForm extends IForm<Cheval> {
	private static final String ERROR_NOM_NULL = "Le champ nom est obligatoire.";
	private static final String ERROR_NOM_MAX = "Le champ nom doit faire entre 2 et 50 caractères.";
	
	private static final String ERROR_SEXE_NULL = "Le champ sexe est obligatoire.";
	private static final String ERROR_SEXE_INVALIDE = "Le champ sexe est invalide.";
	
	private static final String ERROR_SIRE_NULL = "Le champ sire est obligatoire.";
	private static final String ERROR_SIRE_MAX = "Le champ sire doit faire entre 2 et 50 caractères.";
	
	private static final String ERROR_RACE_CHEVAL_NULL = "Le champ race cheval est obligatoire.";
	private static final String ERROR_RACE_INVALIDE = "Le champ race est invalide.";
	
	
	@NotNull(message = ERROR_NOM_NULL)
	@Length(min = 2, max = 50, message = ERROR_NOM_MAX)
	private String nom;
	
	@NotNull(message = ERROR_SEXE_NULL)
	private Character sexe;
	
	@NotNull(message = ERROR_SIRE_NULL)
	@Length(min = 1, max = 100, message = ERROR_SIRE_MAX)
	private String sire;
			
	@NotNull(message = ERROR_RACE_CHEVAL_NULL)
	private Long idRaceCheval;
		
	private String sireMere;
	
	private String sirePere;
	
	private List<Long> idCourse;
	
	private List<Integer> classement;

	public ChevauxForm(boolean isCreation) {
		super(isCreation);
	}

	@Override
	public void fillFromEntity(Cheval entity) {
		this.nom = entity.getNom();
		this.sexe = entity.getSexe();
		this.sire = entity.getSire();
		
		if(entity.getMere() != null)
			this.sireMere = entity.getMere().getSire();
		
		if(entity.getPere()!= null)
			this.sirePere = entity.getPere().getSire();
		
		if(entity.getRaceCheval()!= null)
			this.idRaceCheval = entity.getRaceCheval().getId();
		
		this.classement = new ArrayList<>();
		this.idCourse = new ArrayList<>();
		
		for(Participer p : entity.getParticiper()) {
			this.classement.add(p.getClassement());
			this.idCourse.add(p.getCourse().getId());
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Character getSexe() {
		return sexe;
	}

	public void setSexe(Character sexe) {
		this.sexe = sexe;
	}

	public String getSire() {
		return sire;
	}

	public void setSire(String sire) {
		this.sire = sire;
	}

	public Long getIdRaceCheval() {
		return idRaceCheval;
	}

	public void setIdRaceCheval(Long idRaceCheval) {
		this.idRaceCheval = idRaceCheval;
	}

	public String getSireMere() {
		return sireMere;
	}

	public void setSireMere(String sireMere) {
		this.sireMere = sireMere;
	}

	public String getSirePere() {
		return sirePere;
	}

	public void setSirePere(String sirePere) {
		this.sirePere = sirePere;
	}

	public List<Long> getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(List<Long> idCourse) {
		this.idCourse = idCourse;
	}

	public List<Integer> getClassement() {
		return classement;
	}

	public void setClassement(List<Integer> classement) {
		this.classement = classement;
	}
}