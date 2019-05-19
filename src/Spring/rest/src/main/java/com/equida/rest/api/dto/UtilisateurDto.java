package com.equida.rest.api.dto;

import com.equida.common.bdd.entity.Utilisateur;

public class UtilisateurDto implements IDto<Utilisateur, UtilisateurDto> {

	private Long id;
	private String nom;
	private String prenom;
	private String rue;
	private String copos;
	private String ville;
	private String mail;
	private Long idPays;
	private Long idCompte;
	private RoleDto role;
	private Boolean deleted;
	
	public static UtilisateurDto convertToDto(Utilisateur entity) {
		UtilisateurDto utilisateurDto = new UtilisateurDto();
		
		utilisateurDto.setId(entity.getId());
		utilisateurDto.setNom(entity.getNom());
		utilisateurDto.setPrenom(entity.getPrenom());
		utilisateurDto.setRue(entity.getRue());
		utilisateurDto.setCopos(entity.getCopos());
		utilisateurDto.setVille(entity.getVille());
		utilisateurDto.setMail(entity.getMail());
		utilisateurDto.setIdPays(entity.getPays().getId());
		utilisateurDto.setIdCompte(entity.getCompte().getId());
		utilisateurDto.setRole(RoleDto.convertToDto(entity.getCompte().getRole()));
		utilisateurDto.setDeleted(entity.getDeleted());
		
		return utilisateurDto;
	}
	
	@Override
	public Utilisateur convertToEntity() {
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getIdPays() {
		return idPays;
	}

	public void setIdPays(Long idPays) {
		this.idPays = idPays;
	}

	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}
	
	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
}
