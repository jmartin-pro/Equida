package com.equida.rest.api.controller.ventes;

import com.equida.rest.api.dto.VenteDto;
import com.equida.rest.api.route.ventes.VenteDetailsApiRoute;
import com.equida.common.bdd.entity.Vente;
import com.equida.common.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VenteDetailsRestController {
	
	@Autowired
	private VenteService venteService;
	
	@GetMapping(VenteDetailsApiRoute.RAW_URI)
	public VenteDto getVente(@PathVariable(value = VenteDetailsApiRoute.PARAM_ID_VENTE) Long idVente) {
		Vente vente = venteService.getById(idVente);
		
		return VenteDto.convertToDto(vente);
	}

}
