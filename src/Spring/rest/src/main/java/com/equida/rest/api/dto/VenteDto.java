package com.equida.rest.api.dto;

import com.equida.common.bdd.entity.Vente;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class VenteDto implements IDto<Vente, VenteDto> {

	private Long id;
	private String nom;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateDebut;
	private Long idCategVente;
	private Long idLieu;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateFin;
	@JsonFormat(pattern = "dd/MM/yyyy")
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
		if(entity.getCategVente() != null){
			venteDto.setIdCategVente(entity.getCategVente().getId());
		}
		if(entity.getLieu() != null){
			venteDto.setIdLieu(entity.getLieu().getId());
		}
		venteDto.setDeleted(entity.getDeleted());
		
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

	public Long getIdCategVente() {
		return idCategVente;
	}

	public void setIdCategVente(Long idCategVente) {
		this.idCategVente = idCategVente;
	}

	public Long getIdLieu() {
		return idLieu;
	}

	public void setIdLieu(Long idLieu) {
		this.idLieu = idLieu;
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
