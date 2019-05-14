package com.equida.rest.api.controller.ventes;

import com.equida.rest.api.dto.VenteDto;
import com.equida.rest.api.route.ventes.VenteDetailsApiRoute;
import com.equida.common.bdd.entity.Vente;
import com.equida.common.exception.NotFoundException;
import com.equida.common.service.VenteService;
import com.equida.rest.api.dto.ClientDto;
import com.equida.rest.api.route.clients.ClientDetailsApiRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VenteDetailsRestController {
	
	@Autowired
	private VenteService venteService;
	
	@GetMapping(VenteDetailsApiRoute.RAW_URI)
	public VenteDto getVente(@PathVariable(value = VenteDetailsApiRoute.PARAM_ID_VENTE) Long idVente) throws NotFoundException {
		Vente vente = venteService.getById(idVente);
		
		return VenteDto.convertToDto(vente);
	}
	
	@PatchMapping(VenteDetailsApiRoute.RAW_URI)
	public void updateVente(@PathVariable(value = VenteDetailsApiRoute.PARAM_ID_VENTE) Long idVente, @RequestBody VenteDto venteDto) throws NotFoundException {
		venteService.update(idVente, venteDto.getNom(), venteDto.getIdCategVente(), venteDto.getIdLieu(), venteDto.getDateDebut(), venteDto.getDateFin(), venteDto.getDateVente());
	}
	
	@DeleteMapping(VenteDetailsApiRoute.RAW_URI)
	public void deleteVente(@PathVariable(value = VenteDetailsApiRoute.PARAM_ID_VENTE) Long idVente) throws NotFoundException {
		venteService.delete(idVente);
	}

}
