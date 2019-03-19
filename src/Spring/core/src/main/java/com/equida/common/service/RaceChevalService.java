package com.equida.common.service;

import com.equida.common.exception.NotFoudException;
import com.equida.common.bdd.entity.RaceCheval;
import com.equida.common.bdd.repository.RaceChevalRepository;
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

	public RaceCheval getById(Long idRaceCheval) {
		Optional<RaceCheval> raceCheval = raceChevalRepository.findById(idRaceCheval);
	
		if(!raceCheval.isPresent()) {
			throw new NotFoudException("L'id de la race de cheval n'existe pas.");
		}
		
		return raceCheval.get();
	}
	
}
