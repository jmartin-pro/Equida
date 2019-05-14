package com.equida.rest.api.controller.chevaux;

import com.equida.rest.api.dto.ChevalDto;
import com.equida.rest.api.dto.filter.BasicFilterDto;
import com.equida.rest.api.route.chevaux.ChevauxApiRoute;
import com.equida.common.bdd.entity.Cheval;
import com.equida.common.service.ChevalService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChevauxRestController {
	
	@Autowired
	private ChevalService chevalService;
	
	@GetMapping(ChevauxApiRoute.RAW_URI)
	public List<ChevalDto> getChevaux(@Valid BasicFilterDto filterDto) {
		List<Cheval> chevaux = chevalService.getAll(PageRequest.of(filterDto.getOffset(), filterDto.getLimit()));
		
		List<ChevalDto> chevauxDto = new ArrayList<>();
		
		for(Cheval c : chevaux) {			
			chevauxDto.add(ChevalDto.convertToDto(c));
		}
		
		return chevauxDto;
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping(ChevauxApiRoute.RAW_URI)
	public ChevalDto add(@RequestBody ChevalDto chevalDto) {
		Cheval cheval = chevalService.create(chevalDto.getNom(), chevalDto.getSexe(), chevalDto.getSire(), chevalDto.getIdRaceCheval(), null, null, 1L, null, null);
		
		return chevalDto.convertToDto(cheval);
	}

}
