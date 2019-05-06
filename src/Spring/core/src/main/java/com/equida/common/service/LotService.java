package com.equida.common.service;

import com.equida.common.bdd.entity.Lot;
import com.equida.common.bdd.repository.LotRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LotService {

	@Autowired
	private LotRepository lotRepository;
	
	public List<Lot> getAllValide() {
		return lotRepository.findAllEnVente();
	}
	
	public List<Lot> getLotsByIdVente(long idVente) {
		return lotRepository.findByIdVente(idVente);
	}
	
	public List<Lot> get5Recents() {
		return lotRepository.find5Recents(PageRequest.of(0, 5));
	}
	
}
