package com.equida.rest.api.dto;

import com.equida.common.bdd.entity.Course;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class CourseDto implements IDto<Course, CourseDto> {
	
	private Long id;
	private String nom;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateCourse;
	private String ville;
	private Boolean deleted;

	public CourseDto() {
	}

	public static CourseDto convertToDto(Course entity) {
		CourseDto course = new CourseDto();
		
		course.setId(entity.getId());
		course.setNom(entity.getNom());
		course.setDateCourse(entity.getDateCourse());
		course.setVille(entity.getVille());
		course.setDeleted(entity.getDeleted());
		
		return course;
	}
		
	@Override
	public Course convertToEntity() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	public CourseDto(Long idCourse) {
		this.id = idCourse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setDateCourse(Date dateCourse) {
		this.dateCourse = dateCourse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
}
