package com.equida.common.service;

import com.equida.common.bdd.entity.CategVente;
import com.equida.common.bdd.entity.Lieu;
import com.equida.common.bdd.entity.RaceCheval;
import com.equida.common.exception.NotFoundException;
import com.equida.common.bdd.entity.Vente;
import com.equida.common.bdd.repository.VenteRepository;
import com.equida.common.exception.ServiceException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VenteService {

	@Autowired
	private VenteRepository venteRepository;
	
	public List<Vente> getAll() {
		return venteRepository.findAll();
	}
	
	public List<Vente> getAll(PageRequest pageRequest) {
		return getAll(null, pageRequest);
	}
	
	public List<Vente> getAll(Long idCategVente, PageRequest pageRequest) {
		if(idCategVente != null) {
			return venteRepository.findAllByIdCategVente(idCategVente, pageRequest);
		}
		
		return venteRepository.findAll(pageRequest);
	}
	
	public List<Vente> getAllByIdCategVente(Long idCategVente) {
		return venteRepository.findAllByIdCategVente(idCategVente);
	}

	public Vente getById(Long idVente) throws NotFoundException {
		Optional<Vente> vente = venteRepository.findById(idVente);
	
		if(!vente.isPresent()) {
			throw new NotFoundException("L'id de vente spécifié n'existe pas.");
		}
		
		return vente.get();
	}

	public List<Vente> get5Recents() {
		return venteRepository.find5Recents(PageRequest.of(0, 5));
	}
	
	public void delete(Long idVente) throws NotFoundException {
		if(idVente == null) {
			throw new ServiceException("idVente ne doit pas être null.");
		}
		
		Vente vente = getById(idVente);
		
		vente.setDeleted(true);
		save(vente);
	}
	
	public Vente create(String nom, Long idCategVente, Long idLieu, Date dateDebut, Date dateFin, Date dateVente) {
		
		if(nom == null) {
			throw new ServiceException("Nom ne doit pas être null.");
		}
		
		if(idCategVente == null) {
			throw new ServiceException("idCategVente ne doit pas être null");
		}
		
		if(idLieu == null) {
			throw new ServiceException("idLieu ne doit pas être null");
		}	
		
		if(dateDebut == null) {
			throw new ServiceException("dateDebut ne doit pas être null");
		}
		
		if(dateFin == null) {
			throw new ServiceException("dateFin ne doit pas être null");
		}
		
		if(dateVente == null) {
			throw new ServiceException("dateVente ne doit pas être null");
		}
		
		Vente vente = new Vente();
		
		vente.setId(null);
		vente.setNom(nom);
		
		CategVente categVente = new CategVente();
		categVente.setId(idCategVente);
		vente.setCategVente(categVente);
		
		Lieu lieu = new Lieu();
		lieu.setId(idLieu);
		vente.setLieu(lieu);
		
		vente.setDateDebut(dateDebut);
		vente.setDateFin(dateFin);
		vente.setDateVente(dateVente);
		vente.setDeleted(false);
		
		return save(vente);
	}
	
	public Vente update(Long idVente, String nom, Long idCategVente, Long idLieu, Date dateDebut, Date dateFin, Date dateVente) throws NotFoundException {
		if(idVente == null) {
			throw new ServiceException("idVente ne doit pas être null.");
		}
		
		if(nom == null) {
			throw new ServiceException("Nom ne doit pas être null.");
		}
		
		if(idCategVente == null) {
			throw new ServiceException("idCategVente ne doit pas être null.");
		}
		
		if(idLieu == null) {
			throw new ServiceException("idLieu ne doit pas être null.");
		}
		
		if(dateDebut == null) {
			throw new ServiceException("dateDebut ne doit pas être null.");
		}
		
		if(dateFin == null) {
			throw new ServiceException("dateFin ne doit pas être null.");
		}
		
		if(dateVente == null) {
			throw new ServiceException("dateVente ne doit pas être null.");
		}
		
		Vente vente = getById(idVente);
		
		vente.setNom(nom);
		
		CategVente categVente = new CategVente();
		categVente.setId(idCategVente);
		vente.setCategVente(categVente);
		
		Lieu lieu = new Lieu();
		lieu.setId(idLieu);
		vente.setLieu(lieu);
		
		vente.setDateDebut(dateDebut);
		vente.setDateFin(dateFin);
		vente.setDateVente(dateVente);
		vente.setDeleted(false);
		
		return save(vente);
	}
	
	public Vente save(Vente vente) {
		return venteRepository.save(vente);
	}
	
}
