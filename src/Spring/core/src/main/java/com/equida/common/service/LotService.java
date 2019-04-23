package com.equida.common.service;

import com.equida.common.exception.NotFoundException;
import com.equida.common.bdd.entity.Lot;
import com.equida.common.bdd.repository.LotRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LotService {

	@Autowired
	private LotRepository lotRepository;
	
	public List<Lot> getAll() {
		return lotRepository.findAll();
	}
	
	public List<Lot> getAll(PageRequest pageRequest) {
		return lotRepository.findAll(pageRequest);
	}

	public Lot getById(Long idLot) throws NotFoundException {
		Optional<Lot> lot = lotRepository.findById(idLot);
	
		if(!lot.isPresent()) {
			throw new NotFoundException("L'id de lot spécifié n'existe pas.");
		}
		
		return lot.get();
	}
	
	public Lot getLotByIdCheval(Long idCheval) throws NotFoundException {
		Optional<Lot> lot = lotRepository.findLotCheval(idCheval);
	
		if(!lot.isPresent()) {
			throw new NotFoundException("L'id de lot spécifié n'existe pas.");
		}
		
		return lot.get();
	}
}