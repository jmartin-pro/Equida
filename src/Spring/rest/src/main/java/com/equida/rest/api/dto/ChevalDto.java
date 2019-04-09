package com.equida.rest.api.dto;

import com.equida.common.bdd.entity.Cheval;
import com.equida.common.bdd.entity.RaceCheval;

public class ChevalDto implements IDto<Cheval, ChevalDto>{
	
	private Long id;
    private String nom;
    private Character sexe;
    private String sire;
    private Long idRaceCheval;
	private Boolean deleted;

	public static ChevalDto convertToDto(Cheval entity) {
		ChevalDto chevalDto = new ChevalDto();
		
		chevalDto.setId(entity.getId());
		chevalDto.setNom(entity.getNom());
		chevalDto.setSexe(entity.getSexe());
		chevalDto.setSire(entity.getSire());
		chevalDto.setDeleted(entity.getDeleted());
		chevalDto.setIdRaceCheval(entity.getRaceCheval().getId());
		
		return chevalDto;
	}

	@Override
	public Cheval convertToEntity() {
		Cheval cheval = new Cheval();
		
		cheval.setId(this.id);
		cheval.setNom(this.nom);
		cheval.setSexe(this.sexe);
		cheval.setSire(this.sire);
		
		RaceCheval raceCheval = new RaceCheval();
		raceCheval.setId(idRaceCheval);
		cheval.setRaceCheval(raceCheval);
		
		cheval.setDeleted(this.deleted);
		
		return cheval;
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

	public Long getIdRaceCheval() {
		return idRaceCheval;
	}

	public void setIdRaceCheval(Long idRaceCheval) {
		this.idRaceCheval = idRaceCheval;
	}
	
	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
}
