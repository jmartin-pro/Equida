package com.equida.api.controller.chevaux;

import com.equida.api.dto.ChevalDto;
import com.equida.api.dto.filter.BasicFilterDto;
import com.equida.api.route.chevaux.ChevauxApiRoute;
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
	public List<ChevalDto> getChevaux(@Valid BasicFilterDto filterDto) {
		List<Cheval> chevaux = chevalService.getAll(PageRequest.of(filterDto.getOffset(), filterDto.getLimit()));
		
		List<ChevalDto> chevauxDto = new ArrayList<>();
		
		for(Cheval c : chevaux) {			
			chevauxDto.add(ChevalDto.convertToDto(c));
		}
		
		return chevauxDto;
	}

}
