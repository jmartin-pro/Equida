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
@Table(name = Vente.TABLE)
public class Vente {

	public static final String TABLE = "VENTE";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOM")
	private String nom;
	
	@Column(name = "DATE_DEBUT")
	private Date dateDebut;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CATEG_VENTE")
	private CategVente categVente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_LIEU")
	private Lieu lieu;
	
	@Column(name = "DATE_FIN")
	private Date dateFin;
	
	@Column(name = "DATE_VENTE")
	private Date dateVente;
	
	@Column(name = "DELETED")
	private Boolean deleted;
	
	@OneToMany(mappedBy = "vente", cascade = CascadeType.ALL)
	private List<Lot> lots;
	
	@OneToMany(mappedBy = "vente", cascade = CascadeType.ALL)
	private List<Courriel> courriels;

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

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public CategVente getCategVente() {
		return categVente;
	}

	public void setCategVente(CategVente categVente) {
		this.categVente = categVente;
	}

	public Lieu getLieu() {
		return lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Date getDateVente() {
		return dateVente;
	}

	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public List<Lot> getLots() {
		return lots;
	}

	public void setLots(List<Lot> lots) {
		this.lots = lots;
	}

	public List<Courriel> getCourriels() {
		return courriels;
	}

	public void setCourriels(List<Courriel> courriels) {
		this.courriels = courriels;
	}
	
}
