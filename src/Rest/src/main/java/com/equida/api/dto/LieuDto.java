package com.equida.api.dto;

import com.equida.bdd.entity.Lieu;

public class LieuDto implements IDto<Lieu, LieuDto>{
	private Long id;
	private String ville;
	private Integer nbBoxes;
	private String commentaire;
	private Boolean deleted;

	public static LieuDto convertToDto(Lieu entity) {
		LieuDto lieuDto = new LieuDto();
		
		lieuDto.setId(entity.getId());
		lieuDto.setVille(entity.getVille());
		lieuDto.setNbBoxes(entity.getNbBoxes());
		lieuDto.setCommentaire(entity.getCommentaire());
		lieuDto.setDeleted(entity.getDeleted());
		
		return lieuDto;
	}
	
	@Override
	public Lieu convertToEntity() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getNbBoxes() {
		return nbBoxes;
	}

	public void setNbBoxes(Integer nbBoxes) {
		this.nbBoxes = nbBoxes;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
}
