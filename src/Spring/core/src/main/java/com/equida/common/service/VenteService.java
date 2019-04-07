package com.equida.common.service;

import com.equida.common.exception.NotFoudException;
import com.equida.common.bdd.entity.Vente;
import com.equida.common.bdd.repository.VenteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VenteService {

	@Autowired
	private VenteRepository venteRepository;
	
	public List<Vente> getAll() {
		return venteRepository.findAll();
	}
	
	public List<Vente> getAll(PageRequest pageRequest) {
		return getAll(null, pageRequest);
	}
	
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
