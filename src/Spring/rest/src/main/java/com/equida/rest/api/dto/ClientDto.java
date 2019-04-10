package com.equida.rest.api.dto;

import com.equida.common.bdd.entity.Client;

public class ClientDto implements IDto<Client, ClientDto>{
	private Long id;
	private String nom;
	private String prenom;
	private String mail;
	private String ville;
	private String rue;
	private String copos;
	private Long idPays;
	private Boolean deleted;

	public static ClientDto convertToDto(Client entity) {
		ClientDto clientDto = new ClientDto();
		
		clientDto.setId(entity.getId());
		clientDto.setNom(entity.getNom());
		clientDto.setPrenom(entity.getPrenom());
		clientDto.setMail(entity.getMail());
		clientDto.setVille(entity.getVille());
		clientDto.setRue(entity.getRue());
		clientDto.setCopos(entity.getCopos());
		if(entity.getPays() != null)
			clientDto.setIdPays(entity.getPays().getId());
		clientDto.setDeleted(entity.getDeleted());
		
		return clientDto;
	}
	
	@Override
	public Client convertToEntity() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public String getCopos() {
		return copos;
	}

	public void setCopos(String copos) {
		this.copos = copos;
	}

	public Long getIdPays() {
		return idPays;
	}

	public void setIdPays(Long idPays) {
		this.idPays = idPays;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	
}
