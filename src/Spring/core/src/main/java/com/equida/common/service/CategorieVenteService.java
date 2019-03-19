package com.equida.common.service;

import com.equida.common.bdd.entity.CategVente;
import com.equida.common.exception.NotFoudException;
import com.equida.common.bdd.repository.CategorieVenteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CategorieVenteService {

	@Autowired
	private CategorieVenteRepository categorieVenteRepository;
	
	public List<CategVente> getAll(PageRequest pageRequest) {
		return categorieVenteRepository.findAll(pageRequest);
	}

	public CategVente getById(Long idCategVente) {
		Optional<CategVente> categVente = categorieVenteRepository.findById(idCategVente);
	
		if(!categVente.isPresent()) {
			throw new NotFoudException("L'id de la catégorie de vente n'existe pas.");
		}
		
		return categVente.get();
	}
	
}
