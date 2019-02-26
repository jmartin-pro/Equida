package com.equida.bdd.entity;

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
@Table(name = CategVente.TABLE)
public class CategVente {
	public static final String TABLE = "CATEG_VENTE";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "LIBELLE")
	private String libelle;
	
	@Column(name = "DELETED")
	private Boolean deleted;
	
	@OneToMany(mappedBy = "categVente", cascade = CascadeType.ALL)
	private List<Vente> ventes;
	
	@OneToMany(mappedBy = "categVente", cascade = CascadeType.ALL)
	private List<ClientCategVente> clientCategVentes;

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

	public List<Vente> getVentes() {
		return ventes;
	}

	public void setVentes(List<Vente> ventes) {
		this.ventes = ventes;
	}

	public List<ClientCategVente> getClientCategVentes() {
		return clientCategVentes;
	}

	public void setClientCategVentes(List<ClientCategVente> clientCategVentes) {
		this.clientCategVentes = clientCategVentes;
	}
	
}
