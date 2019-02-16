package com.equida.api.controller;

import com.equida.api.dto.ChevalDto;
import com.equida.bdd.entity.Cheval;
import com.equida.bdd.entity.RaceCheval;
import com.equida.bdd.repository.ChevalRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChevalRestController {
	
	@Autowired
	private ChevalRepository chevalRepository;
	
	@GetMapping("/api/cheval")
	public List<ChevalDto> chevaux() {
		List<Cheval> che = chevalRepository.findAll();
		
		List<ChevalDto> chevaux = new ArrayList<>();
		
		for(Cheval c : che) {
			ChevalDto chevalDto = new ChevalDto();
			chevalDto.setId(c.getId());
			chevalDto.setNom(c.getNom());
			chevalDto.setSexe(c.getSexe());
			chevalDto.setSire(c.getSire());
			
			RaceCheval raceCheval = new RaceCheval();
			raceCheval.setId(c.getRaceCheval().getId());
			raceCheval.setLibelle(c.getRaceCheval().getLibelle());
			raceCheval.setDescription(c.getRaceCheval().getDescription());
			raceCheval.setDeleted(c.getRaceCheval().getDeleted());
			chevalDto.setRaceCheval(raceCheval);
			
			chevaux.add(chevalDto);
		}
		
		return chevaux;
	}

}
