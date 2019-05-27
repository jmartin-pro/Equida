package com.equida.common.service;

import com.equida.common.bdd.entity.Hippodrome;
import com.equida.common.bdd.repository.HippodromeRepository;
import com.equida.common.exception.NotFoundException;
import com.equida.common.exception.ServiceException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class HippodromeService {

	@Autowired
	private HippodromeRepository hippodromeRepository;
	
	public List<Hippodrome> getAll() {
		return hippodromeRepository.findAll();
	}
	
	public List<Hippodrome> getAll(PageRequest pageRequest) {
		return hippodromeRepository.findAll(pageRequest);
	}
	
	public Hippodrome getById(Long idHippodrome) throws NotFoundException {
		if(idHippodrome == null) {
			throw new ServiceException("L'id ne doit pas être null.");
		}
				
		Optional<Hippodrome> hippodrome = hippodromeRepository.findById(idHippodrome);
	
		if(!hippodrome.isPresent()) {
			throw new NotFoundException("L'id de l'hippodrome spécifié n'existe pas.");
		}
		
		return hippodrome.get();
	}
	
}