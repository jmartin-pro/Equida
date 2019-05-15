package com.equida.rest.api.controller.lot_ventes;

import com.equida.common.bdd.entity.Lot;
import com.equida.common.exception.NotFoundException;
import com.equida.common.service.LotService;
import com.equida.rest.api.dto.LotDto;
import com.equida.rest.api.dto.filter.BasicFilterDto;
import com.equida.rest.api.route.lot_ventes.LotVenteAValiderApiRoute;
import com.equida.rest.api.route.lot_ventes.LotVenteAcceptApiRoute;
import com.equida.rest.api.route.lot_ventes.LotVenteDenyApiRoute;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LotsVenteRestController {
	
	@Autowired
	private LotService lotService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(LotVenteAValiderApiRoute.RAW_URI)
	public List<LotDto> getLotsAValider(@Valid BasicFilterDto filterDto) {
		List<Lot> lots = lotService.getAllAValider(filterDto.getPageRequest());
		
		List<LotDto> lieuxDto = new ArrayList<>();
		
		for(Lot l : lots) {			
			lieuxDto.add(LotDto.convertToDto(l));
		}
		
		return lieuxDto;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(LotVenteAcceptApiRoute.RAW_URI)
	public LotDto accept(@PathVariable(value = LotVenteAcceptApiRoute.PARAM_ID_LOT) Long idLot) throws NotFoundException {
		return LotDto.convertToDto(lotService.validerLot(idLot));
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(LotVenteDenyApiRoute.RAW_URI)
	public LotDto deny(@PathVariable(value = LotVenteAcceptApiRoute.PARAM_ID_LOT) Long idLot) throws NotFoundException {
		return LotDto.convertToDto(lotService.deleteLot(idLot));
	}

}
