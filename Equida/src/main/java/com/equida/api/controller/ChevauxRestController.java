package com.equida.api.controller;

import com.equida.api.dto.ChevalDto;
import com.equida.api.params.ChevalApiParams;
import com.equida.api.route.ChevauxApiRoute;
import com.equida.bdd.entity.Cheval;
import com.equida.service.ChevalService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChevauxRestController {
	
	@Autowired
	private ChevalService chevalService;
	
	@GetMapping(ChevauxApiRoute.RAW_URI)
	public List<ChevalDto> chevaux(@Valid ChevalApiParams apiParams) {
		List<Cheval> chevaux = chevalService.getAll(PageRequest.of(apiParams.getOffset(), apiParams.getLimit()));
		
		List<ChevalDto> chevauxDto = new ArrayList<>();
		
		for(Cheval c : chevaux) {			
			chevauxDto.add(ChevalDto.convertToDto(c));
		}
		
		return chevauxDto;
	}

}
