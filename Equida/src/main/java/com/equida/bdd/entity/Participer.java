package com.equida.bdd.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = Participer.TABLE)
public class Participer {

	public static final String TABLE = "PARTICIPER";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CHEVAL")
	private Cheval cheval;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COURSE")
	private Course course;
	
	@Column(name = "CLASSEMENT")
	private Integer classement;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cheval getCheval() {
		return cheval;
	}

	public void setCheval(Cheval cheval) {
		this.cheval = cheval;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getClassement() {
		return classement;
	}

	public void setClassement(Integer classement) {
		this.classement = classement;
	}

	
}
