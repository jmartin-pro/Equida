package com.equida.common.service;

import com.equida.common.bdd.entity.Client;
import com.equida.common.bdd.entity.Enchere;
import com.equida.common.bdd.entity.Lot;
import com.equida.common.bdd.repository.EnchereRepository;
import com.equida.common.exception.NotFoundException;
import com.equida.common.exception.ServiceException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EnchereService {

	@Autowired
	private EnchereRepository enchereRepository;
	
	public List<Enchere> getAll() {
		return enchereRepository.findAll();
	}
	
	public List<Enchere> getAll(PageRequest pageRequest) {
		return enchereRepository.findAll(pageRequest);
	}
	
	public List<Enchere> getAllByIdLot(Long idLot) {
		return enchereRepository.findAllByIdLot(idLot);
	}
	
	public void delete(Long idEnchere) throws NotFoundException {
		if(idEnchere == null) {
			throw new ServiceException("idEnchere ne doit pas être null.");
		}
		
		Enchere enchere = getById(idEnchere);
		
		enchere.setDeleted(true);
		save(enchere);
	}
	
	public Enchere create(Long idLot, Long idClient, Float montant) {
		if(idLot == null) {
			throw new ServiceException("idLot ne doit pas être null");
		}	
		
		if(idClient == null) {
			throw new ServiceException("idClient ne doit pas être null");
		}
		
		if(montant == null) {
			throw new ServiceException("montant ne doit pas être null");
		}
		
		Enchere enchere = new Enchere();
		
		enchere.setId(null);
		
		Client client = new Client();
		client.setId(idClient);
		enchere.setClient(client);
		
		Lot lot = new Lot();
		lot.setId(idLot);
		enchere.setLot(lot);
		
		enchere.setMontant(montant);
		enchere.setDeleted(false);
		
		return this.save(enchere);
	}
	
	public Enchere getById(Long idEnchere) throws NotFoundException {
		Optional<Enchere> enchere = enchereRepository.findById(idEnchere);
	
		if(!enchere.isPresent()) {
			throw new NotFoundException("L'id de l'enchere spécifié n'existe pas.");
		}
		
		return enchere.get();
	}
	
	public Enchere save(Enchere enchere) {
		return enchereRepository.save(enchere);
	}
}
