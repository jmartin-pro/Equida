package com.equida.rest.api.dto;

import com.equida.common.bdd.entity.Cheval;

public class ChevalDto implements IDto<Cheval, ChevalDto>{
	
	private Long id;
    private String nom;
    private Character sexe;
    private String sire;
    private RaceChevalDto raceCheval;

	public static ChevalDto convertToDto(Cheval entity) {
		ChevalDto chevalDto = new ChevalDto();
		
		chevalDto.setId(entity.getId());
		chevalDto.setNom(entity.getNom());
		chevalDto.setSexe(entity.getSexe());
		chevalDto.setSire(entity.getSire());
			
		chevalDto.setRaceCheval(RaceChevalDto.convertToDto(entity.getRaceCheval()));
		
		return chevalDto;
	}

	@Override
	public Cheval convertToEntity() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
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

	public RaceChevalDto getRaceCheval() {
		return raceCheval;
	}

	public void setRaceCheval(RaceChevalDto raceCheval) {
		this.raceCheval = raceCheval;
	}
	
}
