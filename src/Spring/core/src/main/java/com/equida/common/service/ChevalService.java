package com.equida.common.service;

import com.equida.common.exception.NotFoudException;
import com.equida.common.exception.ServiceException;
import com.equida.common.bdd.entity.Cheval;
import com.equida.common.bdd.repository.ChevalRepository;
import java.util.List;
import java.util.Optional;
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
	
	public Cheval getById(Long idCheval) {
		if(idCheval == null) {
			throw new ServiceException("L'id ne doit pas être null.");
		}
				
		Optional<Cheval> cheval = chevalRepository.findById(idCheval);
	
		if(!cheval.isPresent()) {
			throw new NotFoudException("L'id du cheval spécifié n'existe pas.");
		}
		
		return cheval.get();
	}

	public Cheval create(String nom, Character sexe, String sire/*, Long idRace*/) {
		if(nom == null) {
			throw new ServiceException("Nom ne doit pas être null.");
		}
		
		Cheval cheval = new Cheval();
		
		cheval.setId(null);
		cheval.setNom(nom);
		cheval.setSexe(sexe);
		cheval.setSire(sire);
		/*RaceCheval raceCheval = new RaceCheval();
		raceCheval.setId(idRace);
		cheval.setRaceCheval(raceCheval);*/
		cheval.setDeleted(false);
		
		return save(cheval);
	}
	
	public Cheval updateCheval(Long idCheval, String nom, Character sexe, String sire/*, Long idRace*/) {
		if(idCheval == null) {
			throw new ServiceException("idCheval ne doit pas être null.");
		}
		
		if(nom == null) {
			throw new ServiceException("nom ne doit pas être null.");
		}
		
		Cheval cheval = getById(idCheval);
		
		cheval.setNom(nom);
		cheval.setSexe(sexe);
		cheval.setSire(sire);
		/*RaceCheval raceCheval = new RaceCheval();
		raceCheval.setId(idRace);
		cheval.setRaceCheval(raceCheval);*/
		return save(cheval);
	}
	
	public void deleteCheval(Long idCheval) {
		if(idCheval == null) {
			throw new ServiceException("idCheval ne doit pas être null.");
		}
		
		Cheval cheval = getById(idCheval);
		
		cheval.setDeleted(true);
		save(cheval);
	}
	
	public Cheval save(Cheval cheval) {
		return chevalRepository.save(cheval);
	}
	
}