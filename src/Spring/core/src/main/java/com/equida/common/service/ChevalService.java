package com.equida.common.service;

import com.equida.common.exception.NotFoundException;
import com.equida.common.exception.ServiceException;
import com.equida.common.bdd.entity.Cheval;
import com.equida.common.bdd.entity.Client;
import com.equida.common.bdd.entity.RaceCheval;
import com.equida.common.bdd.repository.ChevalRepository;
import com.equida.common.bdd.repository.ClientRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ChevalService {

	@Autowired
	private ParticiperService participerService;
	
	@Autowired
	private ChevalRepository chevalRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Cheval> getChevauxByClientId(Long idClient) throws NotFoundException {
		if(idClient == null) {
			throw new ServiceException("L'id ne doit pas être null.");
		}
		
		Optional<Client> client = clientRepository.findById(idClient);
	
		if(!client.isPresent()) {
			throw new NotFoundException("L'id du client spécifié n'existe pas.");
		}
		
		return chevalRepository.findAll(idClient);
	}
	
	public List<Cheval> getAll(PageRequest pageRequest) {
		return chevalRepository.findAll(pageRequest);
	}
	
	public Cheval getById(Long idCheval) throws NotFoundException {
		if(idCheval == null) {
			throw new ServiceException("L'id ne doit pas être null.");
		}
				
		Optional<Cheval> cheval = chevalRepository.findById(idCheval);
	
		if(!cheval.isPresent()) {
			throw new NotFoundException("L'id du cheval spécifié n'existe pas.");
		}
		
		return cheval.get();
	}
	
	public Cheval getBySire(String sireCheval) throws NotFoundException {
		if(sireCheval == null) {
			throw new ServiceException("Le sire ne doit pas être null.");
		}
				
		Optional<Cheval> cheval = chevalRepository.findBySire(sireCheval);
	
		if(!cheval.isPresent()) {
			throw new NotFoundException("Le sire du cheval spécifié n'existe pas.");
		}
		
		return cheval.get();
	}

	public Cheval create(String nom, Character sexe, String sire, Long idRace, Long idMere, Long idPere, Long idClient, List<Long> idCourse, List<Integer> classement) {
		if(nom == null) {
			throw new ServiceException("Nom ne doit pas être null.");
		}
		
		if(sexe == null) {
			throw new ServiceException("Sexe ne doit pas être null.");
		}
		
		if(sire == null) {
			throw new ServiceException("Sire ne doit pas être null.");
		}
		
		if(idRace == null) {
			throw new ServiceException("idRace ne doit pas être null.");
		}
		
		if(idClient == null) {
			throw new ServiceException("idClient ne doit pas être null.");
		}
		
		Cheval cheval = new Cheval();
		
		cheval.setId(null);
		cheval.setNom(nom);
		cheval.setSexe(sexe);
		cheval.setSire(sire);
		
		RaceCheval raceCheval = new RaceCheval();
		raceCheval.setId(idRace);
		cheval.setRaceCheval(raceCheval);
		
		if(idMere != null) {
			Cheval mere = new Cheval();
			mere.setId(idMere);
			cheval.setMere(mere);
		}
		
		if(idPere != null) { 
			Cheval pere = new Cheval();
			pere.setId(idPere);
			cheval.setPere(pere);
		} 
		
		Client client = new Client();
		client.setId(idClient);
		cheval.setClient(client);
		
		cheval.setParticiper(new ArrayList<>());
		
		cheval.setDeleted(false);
		
		Cheval chevalBdd = save(cheval);
		
		if(classement != null) {
			for(int i = 0 ; i < classement.size() ; i++) {
				participerService.create(chevalBdd.getId(), idCourse.get(i), classement.get(i));
			}
		}
		
		return chevalBdd;
	}
	
	public Cheval update(Long idCheval, String nom, Character sexe, String sire, Long idRace, Long idMere, Long idPere, List<Long> idCourse, List<Integer> classement) throws NotFoundException {
		if(idCheval == null) {
			throw new ServiceException("idCheval ne doit pas être null.");
		}
		
		if(nom == null) {
			throw new ServiceException("Nom ne doit pas être null.");
		}
		
		if(sexe == null) {
			throw new ServiceException("Sexe ne doit pas être null.");
		}
		
		if(sire == null) {
			throw new ServiceException("Sire ne doit pas être null.");
		}
		
		if(idRace == null) {
			throw new ServiceException("idRace ne doit pas être null.");
		}
		
		Cheval cheval = getById(idCheval);
		
		cheval.setNom(nom);
		cheval.setSexe(sexe);
		cheval.setSire(sire);
		
		RaceCheval raceCheval = new RaceCheval();
		raceCheval.setId(idRace);
		cheval.setRaceCheval(raceCheval);
				
		if(idMere != null) {
			Cheval mere = new Cheval();
			mere.setId(idMere);
			cheval.setMere(mere);
		} else {
			cheval.setMere(null);
		}
		
		if(idPere != null) { 
			Cheval pere = new Cheval();
			pere.setId(idPere);
			cheval.setPere(pere);
		} else {
			cheval.setPere(null);
		}
		
		cheval.setDeleted(false);
		
		Cheval chevalBdd = save(cheval);
		
		if(classement != null) {
			for(int i = 0 ; i < classement.size() ; i++) {
				participerService.create(idCheval, idCourse.get(i), classement.get(i));
			}
		}
		
		return chevalBdd;
	}
	
	public void delete(Long idCheval) throws NotFoundException {
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