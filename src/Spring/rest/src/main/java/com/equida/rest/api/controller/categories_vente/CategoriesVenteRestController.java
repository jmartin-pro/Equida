package com.equida.rest.api.controller.categories_vente;

import com.equida.rest.api.dto.CategVenteDto;
import com.equida.rest.api.dto.filter.BasicFilterDto;
import com.equida.rest.api.route.categories_vente.CategoriesVenteApiRoute;
import com.equida.common.bdd.entity.CategVente;
import com.equida.common.service.CategorieVenteService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriesVenteRestController {
	
	@Autowired
	private CategorieVenteService categorieVenteService;
	
	@GetMapping(CategoriesVenteApiRoute.RAW_URI)
	public List<CategVenteDto> getCategoriesVente(@Valid BasicFilterDto filterDto) {
		List<CategVente> categsVente = categorieVenteService.getAll(filterDto.getPageRequest());
		
		List<CategVenteDto> categsVenteDto = new ArrayList<>();
		
		for(CategVente cv : categsVente) {			
			categsVenteDto.add(CategVenteDto.convertToDto(cv));
		}
		
		return categsVenteDto;
	}

}
