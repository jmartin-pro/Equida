package com.equida.common.service;

import com.equida.common.exception.NotFoudException;
import com.equida.common.bdd.entity.RaceCheval;
import com.equida.common.bdd.repository.RaceChevalRepository;
import com.equida.common.exception.ServiceException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RaceChevalService {

	@Autowired
	private RaceChevalRepository raceChevalRepository;
	
	public List<RaceCheval> getAll(PageRequest pageRequest) {
		return raceChevalRepository.findAll(pageRequest);
	}
	
	public List<RaceCheval> getAll() {
		return raceChevalRepository.findAll();
	}

	public RaceCheval getById(Long idRaceCheval) {
		Optional<RaceCheval> raceCheval = raceChevalRepository.findById(idRaceCheval);
	
		if(!raceCheval.isPresent()) {
			throw new NotFoudException("L'id de la race de cheval n'existe pas.");
		}
		
		return raceCheval.get();
	}
	
	public RaceCheval create(String libelle, String description) {
		if(libelle == null) {
			throw new ServiceException("libelle ne doit pas être null");
		}
		
		if(description == null) {
			throw new ServiceException("description ne doit pas être null");
		}
		
		RaceCheval raceCheval = new RaceCheval();
		
		raceCheval.setId(null);
		raceCheval.setLibelle(libelle);
		raceCheval.setDescription(description);
		raceCheval.setDeleted(false);
		
		return save(raceCheval);
	}
	
	public RaceCheval updateRaceCheval(Long idRaceCheval, String libelle, String description) {
		if(idRaceCheval == null) {
			throw new ServiceException("idRaceCheval ne doit pas être null");
		}
		
		if(libelle == null) {
			throw new ServiceException("libelle ne doit pas être null");
		}
		
		if(description == null) {
			throw new ServiceException("description ne doit pas être null");
		}
		
		RaceCheval raceCheval = getById(idRaceCheval);
		
		raceCheval.setLibelle(libelle);
		raceCheval.setDescription(description);
		return save(raceCheval);
	}
	
	public void deleteRaceCheval(Long idRaceCheval) {
		if(idRaceCheval == null) {
			throw new ServiceException("idRaceCheval ne doit pas être null");
		}
		
		RaceCheval raceCheval = getById(idRaceCheval);
		
		raceCheval.setDeleted(true);
		save(raceCheval);
	}
	
	public RaceCheval save(RaceCheval raceCheval) {
		return raceChevalRepository.save(raceCheval);
	}
}
