package com.equida.service;

import com.equida.bdd.entity.Vente;
import com.equida.bdd.repository.VenteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VenteService {

	@Autowired
	private VenteRepository venteRepository;
	
	public List<Vente> getAll(PageRequest pageRequest) {
		return venteRepository.findAll(pageRequest);
	}
	
}
