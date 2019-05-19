package com.equida.common.service;

import com.equida.common.exception.NotFoundException;
import com.equida.common.bdd.entity.Lieu;
import com.equida.common.bdd.repository.LieuRepository;
import com.equida.common.exception.ServiceException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LieuService {

	@Autowired
	private LieuRepository lieuRepository;
	
	public List<Lieu> getAll(PageRequest pageRequest) {
		return lieuRepository.findAll(pageRequest);
	}
	
	public List<Lieu> getAll() {
		return lieuRepository.findAll();
	}

	public Lieu getById(Long idLieu) throws NotFoundException {
		Optional<Lieu> lieu = lieuRepository.findById(idLieu);
	
		if(!lieu.isPresent()) {
			throw new NotFoundException("L'id du lieu n'existe pas.");
		}
		
		return lieu.get();
	}
	
	public Lieu create(String ville, Integer nbBoxes, String commentaire) {
		if(ville == null) {
			throw new ServiceException("ville ne doit pas être null");
		}
		
		if(nbBoxes == null) {
			throw new ServiceException("nbBoxes ne doit pas être null");
		}
		
		if(commentaire == null) {
			throw new ServiceException("commentaire ne doit pas être null");
		}
		
		Lieu lieu = new Lieu();
		
		lieu.setId(null);
		lieu.setVille(ville);
		lieu.setNbBoxes(nbBoxes);
		lieu.setCommentaire(commentaire);
		lieu.setDeleted(false);
		
		return save(lieu);
	}
	
	public Lieu updateLieu(Long idLieu, String ville, Integer nbBoxes, String commentaire) throws NotFoundException {
		if(idLieu == null) {
			throw new ServiceException("idLieu ne doit pas être null");
		}
		
		if(ville == null) {
			throw new ServiceException("ville ne doit pas être null");
		}
		
		if(nbBoxes == null) {
			throw new ServiceException("nbBoxes ne doit pas être null");
		}
		
		if(commentaire == null) {
			throw new ServiceException("commentaire ne doit pas être null");
		}
		
		
		Lieu lieu = getById(idLieu);
		
		lieu.setVille(ville);
		lieu.setNbBoxes(nbBoxes);
		lieu.setCommentaire(commentaire);
		return save(lieu);
	}
	
	public void deleteLieu(Long idLieu) throws NotFoundException {
		if(idLieu == null) {
			throw new ServiceException("idLieu ne doit pas être null");
		}
		
		Lieu lieu = getById(idLieu);
		
		lieu.setDeleted(true);
		save(lieu);
	}
	
	public Lieu save(Lieu lieu) {
		return lieuRepository.save(lieu);
	}
	
}
