package com.equida.service;

import com.equida.bdd.entity.CategVente;
import com.equida.exception.NotFoudException;
import com.equida.bdd.repository.CategorieVenteRepository;
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
