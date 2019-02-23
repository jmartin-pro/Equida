package com.equida.api.controller.pays;

import com.equida.api.dto.PaysDto;
import com.equida.api.dto.filter.BasicFilterDto;
import com.equida.api.route.pays.PaysApiRoute;
import com.equida.bdd.entity.Pays;
import com.equida.service.PaysService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
