package com.equida.rest.api.dto;

import com.equida.common.bdd.entity.Lot;
import java.util.Date;

public class LotDto implements IDto<Lot, LotDto>{
	private Long id;
	private Long idCheval;
	private Long idVente;
	private Float prixDepart;
	private Date validation;
	private Boolean deleted;

	public static LotDto convertToDto(Lot entity) {
		LotDto lotDto = new LotDto();
		
		lotDto.setId(entity.getId());
		lotDto.setIdCheval(entity.getCheval().getId());
		lotDto.setIdVente(entity.getVente().getId());
		lotDto.setPrixDepart(entity.getPrixDepart());
		lotDto.setValidation(entity.getValidation());
		lotDto.setDeleted(entity.getDeleted());
		
		return lotDto;
	}
	
	@Override
	public Lot convertToEntity() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCheval() {
		return idCheval;
	}

	public void setIdCheval(Long idCheval) {
		this.idCheval = idCheval;
	}

	public Long getIdVente() {
		return idVente;
	}

	public void setIdVente(Long idVente) {
		this.idVente = idVente;
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

	
	
}
