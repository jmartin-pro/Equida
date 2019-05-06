package com.equida.common.service;

import com.equida.common.bdd.entity.Lot;
import com.equida.common.bdd.repository.LotRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotService {

	@Autowired
	private LotRepository lotRepository;
	
	public List<Lot> getAllValide() {
		return lotRepository.findAllValide();
	}
	
	public List<Lot> getLotsByIdVente(long idVente) {
		return lotRepository.findByIdVente(idVente);
	}
	
}
