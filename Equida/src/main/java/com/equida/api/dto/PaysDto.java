package com.equida.api.dto;

import com.equida.bdd.entity.Pays;

public class PaysDto implements IDto<Pays, PaysDto>{

	private Long id;
	private String libelle;
	private Boolean deleted;
	
	public static PaysDto convertToDto(Pays entity) {
		PaysDto categVenteDto = new PaysDto();
		
		categVenteDto.setId(entity.getId());
		categVenteDto.setLibelle(entity.getLibelle());
		categVenteDto.setDeleted(entity.getDeleted());
		
		return categVenteDto;
	}
	
	@Override
	public Pays convertToEntity() {
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

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
}
