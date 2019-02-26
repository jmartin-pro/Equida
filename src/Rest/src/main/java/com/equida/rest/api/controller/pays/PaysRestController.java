package com.equida.rest.api.controller.pays;

import com.equida.rest.api.dto.PaysDto;
import com.equida.rest.api.dto.filter.BasicFilterDto;
import com.equida.rest.api.route.pays.PaysApiRoute;
import com.equida.rest.bdd.entity.Pays;
import com.equida.rest.service.PaysService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaysRestController {
	
	@Autowired
	private PaysService paysService;
	
	@GetMapping(PaysApiRoute.RAW_URI)
	public List<PaysDto> getPays(@Valid BasicFilterDto filterDto) {
		List<Pays> pays = paysService.getAll(filterDto.getPageRequest());
		
		List<PaysDto> paysDto = new ArrayList<>();
		
		for(Pays p : pays) {			
			paysDto.add(PaysDto.convertToDto(p));
		}
		
		return paysDto;
	}
	
	@PostMapping(PaysApiRoute.RAW_URI)
	public PaysDto addPays(@RequestBody PaysDto paysDto) {
		Pays pays = paysService.create(paysDto.getLibelle());
		
		return PaysDto.convertToDto(pays);
	}
	
}
