package com.equida.bdd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@JoinColumn(name = "ID_RACE_CHEVAL")
    @ManyToOne(fetch = FetchType.LAZY)
    private RaceCheval raceCheval;
	

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
	
	

}