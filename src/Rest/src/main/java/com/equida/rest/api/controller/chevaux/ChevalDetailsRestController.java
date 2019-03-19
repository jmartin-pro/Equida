package com.equida.rest.api.controller.chevaux;

import com.equida.rest.api.dto.ChevalDto;
import com.equida.rest.api.route.chevaux.ChevalDetailsApiRoute;
import com.equida.rest.bdd.entity.Cheval;
import com.equida.rest.service.ChevalService;
import org.springframework.beans.factory.annotation.Autowired;
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
	public ChevalDto getCheval(@PathVariable(value = ChevalDetailsApiRoute.PARAM_ID_CHEVAL) Long idCheval) {
		Cheval cheval = chevalService.getById(idCheval);
		
		return ChevalDto.convertToDto(cheval);
	}
	
	@PatchMapping(ChevalDetailsApiRoute.RAW_URI)
	public void updateCheval(@PathVariable(value = ChevalDetailsApiRoute.PARAM_ID_CHEVAL) Long idCheval, @RequestBody ChevalDto chevalDto) {
		chevalService.updateCheval(idCheval, chevalDto.getNom(), chevalDto.getSexe(), chevalDto.getSire()/*, chevalDto.getRaceCheval().getId()*/);
	}
	
	@DeleteMapping(ChevalDetailsApiRoute.RAW_URI)
	public void deleteCheval(@PathVariable(value = ChevalDetailsApiRoute.PARAM_ID_CHEVAL) Long idCheval) {
		chevalService.deleteCheval(idCheval);
	}

}