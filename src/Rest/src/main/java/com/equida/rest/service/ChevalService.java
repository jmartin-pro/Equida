package com.equida.rest.service;

import com.equida.rest.bdd.entity.Cheval;
import com.equida.rest.bdd.repository.ChevalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ChevalService {

	@Autowired
	private ChevalRepository chevalRepository;
	
	public List<Cheval> getAll(PageRequest pageRequest) {
		return chevalRepository.findAll(pageRequest);
	}
	
}
