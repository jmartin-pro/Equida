package com.equida.rest.api.controller.lieux;

import com.equida.rest.api.dto.LieuDto;
import com.equida.rest.api.dto.filter.BasicFilterDto;
import com.equida.rest.api.route.lieux.LieuxApiRoute;
import com.equida.common.bdd.entity.Lieu;
import com.equida.common.service.LieuService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LieuxRestController {
	
	@Autowired
	private LieuService lieuService;
	
	@GetMapping(LieuxApiRoute.RAW_URI)
	public List<LieuDto> getLieux(@Valid BasicFilterDto filterDto) {
		List<Lieu> lieux = lieuService.getAll(filterDto.getPageRequest());
		
		List<LieuDto> lieuxDto = new ArrayList<>();
		
		for(Lieu l : lieux) {			
			lieuxDto.add(LieuDto.convertToDto(l));
		}
		
		return lieuxDto;
	}

}
