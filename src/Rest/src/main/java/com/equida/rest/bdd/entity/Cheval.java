package com.equida.rest.bdd.entity;

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
@Table(name = Cheval.TABLE)
public class Cheval {

	public final static String TABLE = "CHEVAL";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "SEXE")
	private Character sexe;

	@Column(name = "SIRE")
	private String sire;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RACE_CHEVAL")
	private RaceCheval raceCheval;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MERE")
	private Cheval mere;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PERE")
	private Cheval pere;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENT")
	private Client client;

	@Column(name = "DELETED")
	private Boolean deleted;
	
	@OneToMany(mappedBy = "cheval", cascade = CascadeType.ALL)
	private List<Participer> participer;
	
	@OneToMany(mappedBy = "pere", cascade = CascadeType.ALL)
	private List<Cheval> pereDe;
	
	@OneToMany(mappedBy = "mere", cascade = CascadeType.ALL)
	private List<Cheval> mereDe;
	
	@OneToMany(mappedBy = "cheval", cascade = CascadeType.ALL)
	private List<Lot> lots;
	
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

	public Character getSexe() {
		return sexe;
	}

	public void setSexe(Character sexe) {
		this.sexe = sexe;
	}

	public String getSire() {
		return sire;
	}

	public void setSire(String sire) {
		this.sire = sire;
	}

	public RaceCheval getRaceCheval() {
		return raceCheval;
	}

	public void setRaceCheval(RaceCheval raceCheval) {
		this.raceCheval = raceCheval;
	}

	public Cheval getMere() {
		return mere;
	}

	public void setMere(Cheval mere) {
		this.mere = mere;
	}

	public Cheval getPere() {
		return pere;
	}

	public void setPere(Cheval pere) {
		this.pere = pere;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public List<Participer> getParticiper() {
		return participer;
	}

	public void setParticiper(List<Participer> participer) {
		this.participer = participer;
	}

	public List<Cheval> getPereDe() {
		return pereDe;
	}

	public void setPereDe(List<Cheval> pereDe) {
		this.pereDe = pereDe;
	}

	public List<Cheval> getMereDe() {
		return mereDe;
	}

	public void setMereDe(List<Cheval> mereDe) {
		this.mereDe = mereDe;
	}

	public List<Lot> getLots() {
		return lots;
	}

	public void setLots(List<Lot> lots) {
		this.lots = lots;
	}

}
