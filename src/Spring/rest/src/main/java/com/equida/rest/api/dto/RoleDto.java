package com.equida.rest.api.dto;

import com.equida.common.bdd.entity.Role;

public class RoleDto implements IDto<Role, RoleDto>{

	private Long id;
	private String libelle;
	private Boolean deleted;
		
	public static RoleDto convertToDto(Role entity) {
		RoleDto roleDto = new RoleDto();
		
		roleDto.setId(entity.getId());
		roleDto.setLibelle(entity.getLibelle());
		roleDto.setDeleted(entity.getDeleted());
		
		return roleDto;
	}
	
	@Override
	public Role convertToEntity() {
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
