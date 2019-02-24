package com.equida.api.controller.pays;

import com.equida.api.dto.PaysDto;
import com.equida.api.route.pays.PaysDetailsApiRoute;
import com.equida.bdd.entity.Pays;
import com.equida.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaysDetailsRestController {
	
	@Autowired
	private PaysService paysService;
	
	@GetMapping(PaysDetailsApiRoute.RAW_URI)
	public PaysDto getPays(@PathVariable(value = PaysDetailsApiRoute.PARAM_ID_PAYS) Long idPays) {
		Pays pays = paysService.getById(idPays);
		
		return PaysDto.convertToDto(pays);
	}
	
	@PutMapping(PaysDetailsApiRoute.RAW_URI)
	public void updatePays(@PathVariable(value = PaysDetailsApiRoute.PARAM_ID_PAYS) Long idPays, @RequestBody PaysDto paysDto) {
		paysService.updatePays(idPays, paysDto.getLibelle());
	}
	
	@DeleteMapping(PaysDetailsApiRoute.RAW_URI)
	public void deletePays(@PathVariable(value = PaysDetailsApiRoute.PARAM_ID_PAYS) Long idPays) {
		paysService.deletePays(idPays);
	}

}
