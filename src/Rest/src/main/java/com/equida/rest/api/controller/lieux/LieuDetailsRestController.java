package com.equida.rest.api.controller.lieux;

import com.equida.rest.api.dto.LieuDto;
import com.equida.rest.api.route.lieux.LieuDetailsApiRoute;
import com.equida.rest.bdd.entity.Lieu;
import com.equida.rest.service.LieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LieuDetailsRestController {
	
	@Autowired
	private LieuService lieuService;
	
	@GetMapping(LieuDetailsApiRoute.RAW_URI)
	public LieuDto getLieu(@PathVariable(value = LieuDetailsApiRoute.PARAM_ID_LIEU) Long idLieu) {
		Lieu lieu = lieuService.getById(idLieu);
		
		return LieuDto.convertToDto(lieu);
	}

}
