package com.equida.common.bdd.entity;

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
@Table(name = Role.TABLE)
public class Role {

	public static final String TABLE = "ROLE";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "LIBELLE")
	private String libelle;
	
	@Column(name = "DELETED")
	private Boolean deleted;
		
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private List<Compte> compte;

	public Role(Long i) {
		this.id = i;
	}
	
	public Role() {
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

	public List<Compte> getCompte() {
		return compte;
	}

	public void setCompte(List<Compte> compte) {
		this.compte = compte;
	}

}
