package com.equida.common.bdd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Hippodrome.TABLE)
public class Hippodrome {
	
	public final static String TABLE = "HIPPODROME";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "VILLE")
	private String ville;

	@Column(name = "RUE")
	private String rue;

	@Column(name = "CODE_POSTAL")
	private String codePostal;
	
	@Column(name = "TEL")
	private String tel;
	
	@Column(name = "FAX")
	private String fax;
	
	@Column(name = "LIEN")
	private String lien;
	
	@Column(name = "COURSES_TROT")
	private Boolean coursesTrot;
	
	@Column(name = "COURSES_OBSTACLES")
	private Boolean coursesObstacles;
	
	@Column(name = "COURSES_PLAT")
	private Boolean coursesPlat;
	
	@Column(name = "LIEN_PLAN")
	private String lienPlan;
	
	public Hippodrome() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public Boolean getCoursesTrot() {
		return coursesTrot;
	}

	public void setCoursesTrot(Boolean coursesTrot) {
		this.coursesTrot = coursesTrot;
	}

	public Boolean getCoursesObstacles() {
		return coursesObstacles;
	}

	public void setCoursesObstacles(Boolean coursesObstacles) {
		this.coursesObstacles = coursesObstacles;
	}

	public Boolean getCoursesPlat() {
		return coursesPlat;
	}

	public void setCoursesPlat(Boolean coursesPlat) {
		this.coursesPlat = coursesPlat;
	}

	public String getLienPlan() {
		return lienPlan;
	}

	public void setLienPlan(String lienPlan) {
		this.lienPlan = lienPlan;
	}
	
	
}
