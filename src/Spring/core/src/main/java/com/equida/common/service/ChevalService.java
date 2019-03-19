package com.equida.common.service;

import com.equida.common.bdd.entity.Cheval;
import com.equida.common.bdd.repository.ChevalRepository;
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
