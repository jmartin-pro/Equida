package com.equida.service;

import com.equida.exception.NotFoudException;
import com.equida.bdd.entity.Vente;
import com.equida.bdd.repository.VenteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VenteService {

	@Autowired
	private VenteRepository venteRepository;
	
	public List<Vente> getAll(Long idCategVente, PageRequest pageRequest) {
		if(idCategVente != null) {
			return venteRepository.findAllByIdCategVente(idCategVente, pageRequest);
		}
		
		return venteRepository.findAll(pageRequest);
	}

	public Vente getById(Long idVente) {
		Optional<Vente> vente = venteRepository.findById(idVente);
	
		if(!vente.isPresent()) {
			throw new NotFoudException("L'id de vente spécifié n'existe pas.");
		}
		
		return vente.get();
	}
	
}
