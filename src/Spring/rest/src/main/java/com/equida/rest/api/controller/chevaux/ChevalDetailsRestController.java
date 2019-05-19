package com.equida.rest.api.controller.chevaux;

import com.equida.common.authentification.AuthentificatedUser;
import com.equida.rest.api.dto.ChevalDto;
import com.equida.rest.api.route.chevaux.ChevalDetailsApiRoute;
import com.equida.common.bdd.entity.Cheval;
import com.equida.common.exception.NotFoundException;
import com.equida.common.exception.WebException;
import com.equida.common.service.ChevalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChevalDetailsRestController {
	@Autowired
	private ChevalService chevalService;
	
	@GetMapping(ChevalDetailsApiRoute.RAW_URI)
	public ChevalDto getCheval(@PathVariable(value = ChevalDetailsApiRoute.PARAM_ID_CHEVAL) Long idCheval) throws NotFoundException {
		Cheval cheval = chevalService.getById(idCheval);
		
		return ChevalDto.convertToDto(cheval);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PatchMapping(ChevalDetailsApiRoute.RAW_URI)
	public void updateCheval(@PathVariable(value = ChevalDetailsApiRoute.PARAM_ID_CHEVAL) Long idCheval, @RequestBody ChevalDto chevalDto) throws NotFoundException, WebException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();			
		AuthentificatedUser user = (AuthentificatedUser) authentication.getPrincipal();
		
		Long idPere = null;
		Long idMere = null;
		try {
			if(chevalDto.getSireMere() != null && !chevalDto.getSireMere().trim().isEmpty())
				idMere = chevalService.getBySire(chevalDto.getSireMere()).getId();
		} catch(NotFoundException e) {
			throw new WebException("Le SIRE du père n'existe pas dans notre base de donnée");
		}
		
		try {
			if(chevalDto.getSirePere() != null && !chevalDto.getSirePere().trim().isEmpty())
				idPere = chevalService.getBySire(chevalDto.getSirePere()).getId();
		} catch(NotFoundException e) {
			throw new WebException("Le SIRE du père n'existe pas dans notre base de donnée");
		}
		
		chevalService.update(user.getCompte().getUtilisateur().getId(), idCheval, chevalDto.getNom(), chevalDto.getSexe(), chevalDto.getSire(), chevalDto.getIdRaceCheval(), idMere, idPere, null, null);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@DeleteMapping(ChevalDetailsApiRoute.RAW_URI)
	public void deleteCheval(@PathVariable(value = ChevalDetailsApiRoute.PARAM_ID_CHEVAL) Long idCheval) throws NotFoundException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();			
		AuthentificatedUser user = (AuthentificatedUser) authentication.getPrincipal();
		
		chevalService.delete(user.getCompte().getUtilisateur().getId(), idCheval);
	}

}