package com.equida.rest.api.dto;

import com.equida.rest.bdd.entity.RaceCheval;


public class RaceChevalDto implements IDto<RaceCheval, RaceChevalDto>{
	private Long id;
	private String libelle;
	private String description;
	private Boolean deleted;
	
	public static RaceChevalDto convertToDto(RaceCheval entity) {
		RaceChevalDto raceCheval = new RaceChevalDto();
		
		raceCheval.setId(entity.getId());
		raceCheval.setLibelle(entity.getLibelle());
		raceCheval.setDescription(entity.getDescription());
		raceCheval.setDeleted(entity.getDeleted());
		
		return raceCheval;
	}

	@Override
	public RaceCheval convertToEntity() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
}
