package com.equida.common.service;

import com.equida.common.bdd.entity.Cheval;
import com.equida.common.bdd.entity.Lot;
import com.equida.common.bdd.entity.Vente;
import com.equida.common.bdd.repository.LotRepository;
import com.equida.common.exception.NotFoundException;
import com.equida.common.exception.ServiceException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LotService {

	@Autowired
	private LotRepository lotRepository;
	
	public List<Lot> getAllAValider() {
		return lotRepository.findAllAValider();
	}
	
	public List<Lot> getAllAValider(PageRequest pageRequest) {
		return lotRepository.findAllAValider(pageRequest);
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
	
	public Lot deleteLot(Long idLot) throws NotFoundException {
		if(idLot == null) {
			throw new ServiceException("idLot ne doit pas être null.");
		}
		
		Lot lot = getById(idLot);
		
		lot.setDeleted(true);
		return save(lot);
	}
	
	public Lot validerLot(Long idLot) throws NotFoundException {
		if(idLot == null) {
			throw new ServiceException("idLot ne doit pas être null.");
		}
		
		Lot lot = getById(idLot);
		
		lot.setValidation(new Date());
		return save(lot);
	}

	public List<Lot> getAllEnVente() {
		return lotRepository.findAllEnVente();
	}
	
	public List<Lot> getAllEnVente(PageRequest pageRequest) {
		return lotRepository.findAllEnVente(pageRequest);
	}
	
	public List<Lot> getLotsByIdVente(long idVente) {
		return lotRepository.findByIdVente(idVente);
	}
	
	public List<Lot> getChevauxDispoVenteClient(long idClient) {
		return lotRepository.findChevauxDispoVenteClient(idClient);
	}
	
	public List<Lot> get5Recents() {
		return lotRepository.find5Recents(PageRequest.of(0, 5));
	}
	
	public Lot create(Long idVente, Long idCheval, Float prix) {
		if(idVente == null) {
			throw new ServiceException("idVente ne doit pas être null");
		}	
		
		if(idCheval == null) {
			throw new ServiceException("idCheval ne doit pas être null");
		}
		
		if(prix == null) {
			throw new ServiceException("prix ne doit pas être null");
		}
		
		Lot lot = new Lot();
		
		lot.setId(null);
		lot.setCheval(new Cheval(idCheval));
		lot.setVente(new Vente(idVente));
		lot.setPrixDepart(prix);
		lot.setValidation(null);
		lot.setDeleted(false);
		
		return this.save(lot);
	}
	
	public Lot save(Lot lot) {
		return lotRepository.save(lot);
	}
}
