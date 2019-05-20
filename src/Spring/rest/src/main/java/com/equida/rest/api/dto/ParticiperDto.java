package com.equida.rest.api.dto;

import com.equida.common.bdd.entity.Participer;

public class ParticiperDto implements IDto<Participer, ParticiperDto>{
	
	private Long id;
	private Long idCheval;
	private Long idCourse;
	private Integer classement;

	public ParticiperDto() {
	}
	
	public static ParticiperDto convertToDto(Participer entity) {
		ParticiperDto participerDto = new ParticiperDto();
		
		participerDto.setId(entity.getId());
		participerDto.setIdCheval(entity.getCheval().getId());
		participerDto.setIdCourse(entity.getCourse().getId());
		participerDto.setClassement(entity.getClassement());
		
		return participerDto;
	}
	
	@Override
	public Participer convertToEntity() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	public ParticiperDto(Long idParticiper) {
		this.id = idParticiper;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCheval() {
		return idCheval;
	}

	public void setIdCheval(Long idCheval) {
		this.idCheval = idCheval;
	}

	public Long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}

	public Integer getClassement() {
		return classement;
	}

	public void setClassement(Integer classement) {
		this.classement = classement;
	}

	
}
