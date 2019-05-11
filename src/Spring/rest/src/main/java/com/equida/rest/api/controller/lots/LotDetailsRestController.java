package com.equida.rest.api.controller.lots;

import com.equida.common.bdd.entity.Lot;
import com.equida.common.exception.NotFoundException;
import com.equida.common.service.LotService;
import com.equida.rest.api.dto.LotDto;
import com.equida.rest.api.route.lots.LotDetailsApiRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LotDetailsRestController {
	
	@Autowired
	private LotService lotService;
	
	@GetMapping(LotDetailsApiRoute.RAW_URI)
	public LotDto getLot(@PathVariable(value = LotDetailsApiRoute.PARAM_ID_LOT) Long idLot) throws NotFoundException {
		Lot lot = lotService.getById(idLot);
		
		return LotDto.convertToDto(lot);
	}

}
