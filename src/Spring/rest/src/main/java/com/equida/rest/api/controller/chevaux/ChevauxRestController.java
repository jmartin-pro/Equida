package com.equida.rest.api.controller.chevaux;

import com.equida.common.authentification.AuthentificatedUser;
import com.equida.rest.api.dto.ChevalDto;
import com.equida.rest.api.dto.filter.BasicFilterDto;
import com.equida.rest.api.route.chevaux.ChevauxApiRoute;
import com.equida.common.bdd.entity.Cheval;
import com.equida.common.exception.NotFoundException;
import com.equida.common.exception.WebException;
import com.equida.common.service.ChevalService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChevauxRestController {
	
	@Autowired
	private ChevalService chevalService;
	
	@GetMapping(ChevauxApiRoute.RAW_URI)
	public List<ChevalDto> getChevaux(@Valid BasicFilterDto filterDto) throws NotFoundException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();			
		AuthentificatedUser user = (AuthentificatedUser) authentication.getPrincipal();
		
		List<Cheval> chevaux = chevalService.getChevauxByClientId(user.getCompte().getUtilisateur().getId(), filterDto.getPageRequest());
		
		List<ChevalDto> chevauxDto = new ArrayList<>();
		
		for(Cheval c : chevaux) {			
			chevauxDto.add(ChevalDto.convertToDto(c));
		}
		
		return chevauxDto;
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping(ChevauxApiRoute.RAW_URI)
	public ChevalDto add(@RequestBody ChevalDto chevalDto) throws WebException {	
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();			
		AuthentificatedUser user = (AuthentificatedUser) authentication.getPrincipal();
		
		Long idPere = null;
		Long idMere = null;
		try {
			if(chevalDto.getSireMere() != null && !chevalDto.getSireMere().trim().isEmpty())
				idMere = chevalService.getBySire(chevalDto.getSireMere()).getId();
		} catch(NotFoundException e) {
			throw new WebException("Le SIRE de la mère n'existe pas dans notre base de donnée");
		}
		
		try {
			if(chevalDto.getSirePere() != null && !chevalDto.getSirePere().trim().isEmpty())
				idPere = chevalService.getBySire(chevalDto.getSirePere()).getId();
		} catch(NotFoundException e) {
			throw new WebException("Le SIRE du père n'existe pas dans notre base de donnée");
		}

		Cheval cheval = chevalService.create(chevalDto.getNom(), chevalDto.getSexe(), chevalDto.getSire(), chevalDto.getIdRaceCheval(), idMere, idPere, user.getCompte().getUtilisateur().getId(), null, null);
		
		return chevalDto.convertToDto(cheval);
	}

}
