package com.equida.rest.bdd.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = RaceCheval.TABLE)
public class RaceCheval {

	public static final String TABLE = "RACE_CHEVAL";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "LIBELLE")
	private String libelle;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "DELETED")
	private Boolean deleted;
	
	@OneToMany(mappedBy = "raceCheval", cascade = CascadeType.ALL)
	private List<Cheval> chevaux;

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

	public List<Cheval> getChevaux() {
		return chevaux;
	}

	public void setChevaux(List<Cheval> chevaux) {
		this.chevaux = chevaux;
	}
	
}