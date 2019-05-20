package com.equida.rest.api.controller.lots;

import com.equida.common.authentification.AuthentificatedUser;
import com.equida.common.bdd.entity.Cheval;
import com.equida.common.bdd.entity.Lot;
import com.equida.common.exception.NotFoundException;
import com.equida.rest.api.dto.filter.BasicFilterDto;
import com.equida.common.service.LotService;
import com.equida.rest.api.dto.ChevalDto;
import com.equida.rest.api.dto.LotDto;
import com.equida.rest.api.dto.UtilisateurDto;
import com.equida.rest.api.route.lots.LotsApiRoute;
import com.equida.rest.api.route.lots.LotsDispoVenteApiRoute;
import com.equida.rest.api.route.ventes.VenteDetailsApiRoute;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LotsRestController {
	
	@Autowired
	private LotService lotService;
	
	@GetMapping(LotsApiRoute.RAW_URI)
	public List<LotDto> get(@Valid BasicFilterDto filterDto) {
		List<Lot> lots = lotService.getAllEnVente(filterDto.getPageRequest());
		
		List<LotDto> lotsDto = new ArrayList<>();
		
		for(Lot l : lots) {			
			lotsDto.add(LotDto.convertToDto(l));
		}
		
		return lotsDto;
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping(LotsDispoVenteApiRoute.RAW_URI)
	public List<ChevalDto> getLotsDispoVente(@Valid BasicFilterDto filterDto) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		AuthentificatedUser user = (AuthentificatedUser) authentication.getPrincipal();
		long idClient = user.getCompte().getUtilisateur().getId();
		
		List<Cheval> chevaux = lotService.getChevauxDispoVente(idClient, filterDto.getPageRequest());
		
		List<ChevalDto> chevauxDto = new ArrayList<>();
		
		for(Cheval c : chevaux) {			
			chevauxDto.add(ChevalDto.convertToDto(c));
		}
		
		return chevauxDto;
	}
	
	@PostMapping(LotsApiRoute.RAW_URI)
	public LotDto addLotClient(@RequestBody LotDto lotDto) {
		Lot lot = lotService.create(lotDto.getIdVente(), lotDto.getIdCheval(), lotDto.getPrixDepart());
		
		return LotDto.convertToDto(lot);
	}
	
	@GetMapping("/api/nouveauxLots")
	public List<LotDto> getNouveauxLots() {
		List<Lot> lots = lotService.get5Recents();
		
		List<LotDto> lotsDto = new ArrayList<>();
		
		for(Lot l : lots) {			
			lotsDto.add(LotDto.convertToDto(l));
		}
		
		return lotsDto;
	}

}
