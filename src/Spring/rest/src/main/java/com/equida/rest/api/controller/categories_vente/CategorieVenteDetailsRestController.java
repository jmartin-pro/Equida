package com.equida.rest.api.controller.categories_vente;

import com.equida.rest.api.dto.CategVenteDto;
import com.equida.rest.api.route.categories_vente.CategorieVenteDetailsApiRoute;
import com.equida.common.bdd.entity.CategVente;
import com.equida.common.exception.NotFoundException;
import com.equida.common.service.CategorieVenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorieVenteDetailsRestController {
	
	@Autowired
	private CategorieVenteService categorieVenteService;
	
	@GetMapping(CategorieVenteDetailsApiRoute.RAW_URI)
	public CategVenteDto getCategorieVente(@PathVariable(value = CategorieVenteDetailsApiRoute.PARAM_ID_CATEG_VENTE) Long idCategVente) throws NotFoundException {
		CategVente categVente = categorieVenteService.getById(idCategVente);
		
		return CategVenteDto.convertToDto(categVente);
	}

}
