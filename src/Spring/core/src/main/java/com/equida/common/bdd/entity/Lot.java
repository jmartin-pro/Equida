package com.equida.common.bdd.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = Lot.TABLE)
public class Lot {

	public static final String TABLE = "LOT";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CHEVAL")
	private Cheval cheval;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_VENTE")
	private Vente vente;
	
	@Column(name = "PRIX_DEPART")
	private Float prixDepart;
	
	@Column(name = "VALIDATION")
	private Date validation;
	
	@Column(name = "DELETED")
	private Boolean deleted;
	
	@OneToMany(mappedBy = "lot", cascade = CascadeType.ALL)
	private List<Enchere> encheres;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cheval getCheval() {
		return cheval;
	}

	public void setCheval(Cheval cheval) {
		this.cheval = cheval;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	public Float getPrixDepart() {
		return prixDepart;
	}

	public void setPrixDepart(Float prixDepart) {
		this.prixDepart = prixDepart;
	}

	public Date getValidation() {
		return validation;
	}

	public void setValidation(Date validation) {
		this.validation = validation;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public List<Enchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}

}
