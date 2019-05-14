package com.equida.rest.api.controller.ventes;

import com.equida.rest.api.dto.VenteDto;
import com.equida.rest.api.dto.filter.VentesFilterDto;
import com.equida.rest.api.route.ventes.VentesApiRoute;
import com.equida.common.bdd.entity.Vente;
import com.equida.common.service.VenteService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentesRestController {
	
	@Autowired
	private VenteService venteService;
	
	@GetMapping(VentesApiRoute.RAW_URI)
	public List<VenteDto> getVentes(@Valid VentesFilterDto filterDto) {
		List<Vente> ventes = venteService.getAll(filterDto.getIdCategVente(), filterDto.getPageRequest());
		
		List<VenteDto> ventesDto = new ArrayList<>();
		
		for(Vente v : ventes) {			
			ventesDto.add(VenteDto.convertToDto(v));
		}
		
		return ventesDto;
	}
	
	@PostMapping(VentesApiRoute.RAW_URI)
	public VenteDto addVente(@RequestBody VenteDto venteDto) {
		Vente vente = venteService.create(venteDto.getNom(), venteDto.getIdCategVente(), venteDto.getIdLieu(), venteDto.getDateDebut(), venteDto.getDateFin(), venteDto.getDateVente());
		
		return VenteDto.convertToDto(vente);
	}

}
