package com.equida.webapp.web.form.courses;

import com.equida.common.bdd.entity.Course;
import com.equida.common.converter.DateConverter;
import com.equida.webapp.web.form.IForm;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public abstract class CoursesForm extends IForm<Course> {
	
	private static final String ERROR_NOM_NULL = "Le champ nom est obligatoire.";
	private static final String ERROR_NOM_MAX = "Le champ nom doit faire entre 2 et 32 caractères.";
	
	private static final String ERROR_DATE_NULL = "Le champ date est obligatoire.";
	
	private static final String ERROR_VILLE_NULL = "Le champ ville est obligatoire.";
	private static final String ERROR_VILLE_MAX = "Le champ ville doit faire entre 2 et 32 caractères.";
	
	@NotNull(message = ERROR_NOM_NULL)
	@Length(min = 2, max = 32, message = ERROR_NOM_MAX)
	private String nom;
	
	@NotNull(message = ERROR_DATE_NULL)
	private Date dateCourse;
	
	@NotNull(message = ERROR_VILLE_NULL)
	@Length(min = 2, max = 32, message = ERROR_VILLE_MAX)
	private String ville;

	private DateConverter dateConverter;
	
	public CoursesForm(boolean isCreation) {
		super(isCreation);
		
		this.dateConverter = new DateConverter();
	}

	@Override
	public void fillFromEntity(Course entity) {
		this.nom = entity.getNom();
		this.dateCourse = entity.getDateCourse();
		this.ville = entity.getVille();
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Date getDateCourse() {
		return dateCourse;
	}

	public void setDateCourse(String dateCourse) {
		this.dateCourse = dateConverter.convertToEntityAttribute(dateCourse);
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
}