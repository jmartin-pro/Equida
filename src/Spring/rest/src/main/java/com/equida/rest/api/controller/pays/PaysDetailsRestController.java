package com.equida.rest.api.controller.pays;

import com.equida.rest.api.dto.PaysDto;
import com.equida.rest.api.route.pays.PaysDetailsApiRoute;
import com.equida.common.bdd.entity.Pays;
import com.equida.common.exception.NotFoundException;
import com.equida.common.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaysDetailsRestController {
	
	@Autowired
	private PaysService paysService;
	
	@GetMapping(PaysDetailsApiRoute.RAW_URI)
	public PaysDto getPays(@PathVariable(value = PaysDetailsApiRoute.PARAM_ID_PAYS) Long idPays) throws NotFoundException {
		Pays pays = paysService.getById(idPays);
		
		return PaysDto.convertToDto(pays);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PatchMapping(PaysDetailsApiRoute.RAW_URI)
	public void updatePays(@PathVariable(value = PaysDetailsApiRoute.PARAM_ID_PAYS) Long idPays, @RequestBody PaysDto paysDto) throws NotFoundException {
		paysService.updatePays(idPays, paysDto.getLibelle());
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(PaysDetailsApiRoute.RAW_URI)
	public void deletePays(@PathVariable(value = PaysDetailsApiRoute.PARAM_ID_PAYS) Long idPays) throws NotFoundException {
		paysService.deletePays(idPays);
	}

}
