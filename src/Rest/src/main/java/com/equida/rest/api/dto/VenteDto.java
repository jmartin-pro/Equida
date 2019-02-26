package com.equida.rest.api.dto;

import com.equida.rest.bdd.entity.Vente;
import java.util.Date;

public class VenteDto implements IDto<Vente, VenteDto> {

	private Long id;
	private String nom;
	private Date dateDebut;
	private String categVente;
	private LieuDto lieu;
	private Date dateFin;
	private Date dateVente;
	private Boolean deleted;
	
	public static VenteDto convertToDto(Vente entity) {
		VenteDto venteDto = new VenteDto();
		
		venteDto.setId(entity.getId());
		venteDto.setNom(entity.getNom());
		venteDto.setDateDebut(entity.getDateDebut());
		venteDto.setDateFin(entity.getDateFin());
		venteDto.setDateVente(entity.getDateVente());
		venteDto.setDeleted(entity.getDeleted());
		venteDto.setCategVente(entity.getCategVente().getLibelle());
		
		venteDto.setLieu(LieuDto.convertToDto(entity.getLieu()));
		
		return venteDto;
	} 
	
	@Override
	public Vente convertToEntity() {
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

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getCategVente() {
		return categVente;
	}

	public void setCategVente(String categVente) {
		this.categVente = categVente;
	}

	public LieuDto getLieu() {
		return lieu;
	}

	public void setLieu(LieuDto lieu) {
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
	
}
