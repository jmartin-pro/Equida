package com.equida.common.service;

import com.equida.common.exception.NotFoudException;
import com.equida.common.bdd.entity.Lieu;
import com.equida.common.bdd.repository.LieuRepository;
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

	public Lieu getById(Long idLieu) {
		Optional<Lieu> lieu = lieuRepository.findById(idLieu);
	
		if(!lieu.isPresent()) {
			throw new NotFoudException("L'id du lieu n'existe pas.");
		}
		
		return lieu.get();
	}
	
}
