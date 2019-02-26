package com.equida.rest.api.dto;

import com.equida.rest.bdd.entity.Pays;

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
