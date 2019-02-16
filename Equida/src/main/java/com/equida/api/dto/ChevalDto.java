package com.equida.api.dto;

import com.equida.bdd.entity.RaceCheval;

public class ChevalDto {
	
	private Long id;
    private String nom;
    private Character sexe;
    private String sire;
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
