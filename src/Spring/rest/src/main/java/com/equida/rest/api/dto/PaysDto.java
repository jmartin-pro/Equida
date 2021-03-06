package com.equida.rest.api.dto;

import com.equida.common.bdd.entity.Pays;

public class PaysDto implements IDto<Pays, PaysDto>{

	private Long id;
	private String libelle;
	private Boolean deleted;
	
	public static PaysDto convertToDto(Pays entity) {
		PaysDto paysDto = new PaysDto();
		
		paysDto.setId(entity.getId());
		paysDto.setLibelle(entity.getLibelle());
		paysDto.setDeleted(entity.getDeleted());
		
		return paysDto;
	}
	
	@Override
	public Pays convertToEntity() {
		Pays pays = new Pays();
		
		pays.setId(this.id);
		pays.setLibelle(this.libelle);
		pays.setDeleted(this.deleted);
		
		return pays;
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
