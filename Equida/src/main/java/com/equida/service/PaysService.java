package com.equida.service;

import com.equida.exception.NotFoudException;
import com.equida.bdd.entity.Pays;
import com.equida.bdd.repository.PaysRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PaysService {

	@Autowired
	private PaysRepository paysRepository;
	
	public List<Pays> getAll(PageRequest pageRequest) {
		return paysRepository.findAll(pageRequest);
	}

	public Pays getById(Long idVente) {
		Optional<Pays> pays = paysRepository.findById(idVente);
	
		if(!pays.isPresent()) {
			throw new NotFoudException("L'id du pays spécifié n'existe pas.");
		}
		
		return pays.get();
	}
	
}
