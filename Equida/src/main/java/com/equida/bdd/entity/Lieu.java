package com.equida.bdd.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Lieu.TABLE)
class Lieu {

	public static final String TABLE = "LIEU";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "VILLE")
	private String ville;

	@Column(name = "NB_BOXES")
	private Integer nbBoxes;
	
	@Column(name = "COMMENTAIRE")
	private String commentaire;
	
	@Column(name = "DELETED")
	private Boolean deleted;

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
