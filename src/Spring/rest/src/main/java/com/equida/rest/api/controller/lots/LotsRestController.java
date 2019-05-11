package com.equida.rest.api.controller.lots;

import com.equida.common.bdd.entity.Lot;
import com.equida.rest.api.dto.filter.BasicFilterDto;
import com.equida.common.service.LotService;
import com.equida.rest.api.dto.LotDto;
import com.equida.rest.api.route.lots.LotsApiRoute;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
