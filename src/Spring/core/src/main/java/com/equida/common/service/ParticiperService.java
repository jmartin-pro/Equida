package com.equida.common.service;

import com.equida.common.bdd.entity.Cheval;
import com.equida.common.bdd.entity.Course;
import com.equida.common.bdd.entity.Participer;
import com.equida.common.exception.NotFoundException;
import com.equida.common.bdd.repository.ParticiperRepository;
import com.equida.common.exception.ServiceException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ParticiperService {

	@Autowired
	private ParticiperRepository participerRepository;
	
	public List<Participer> getAll(PageRequest pageRequest) {
		return participerRepository.findAll(pageRequest);
	}
	
	public List<Participer> getAll() {
		return participerRepository.findAll();
	}

	public Participer getById(Long idParticiper) throws NotFoundException {
		Optional<Participer> participer = participerRepository.findById(idParticiper);
	
		if(!participer.isPresent()) {
			throw new NotFoundException("L'id de la participation n'existe pas.");
		}
		
		return participer.get();
	}
	
	public List<Participer> getAllByChevalId(Long idCheval) {
		return participerRepository.findAllByIdCheval(idCheval);
	}
	
	public Participer create(Long idCheval, Long idCourse, int classement) {
		if(idCheval == null) {
			throw new ServiceException("idCheval ne doit pas être null");
		}
		
		if(idCourse == null) {
			throw new ServiceException("idCourse ne doit pas être null");
		}
		
		Participer participer = new Participer();
		
		participer.setId(null);
		participer.setCheval(new Cheval(idCheval));
		participer.setCourse(new Course(idCourse));
		participer.setClassement(classement);
		
		return save(participer);
	}
	
	public Participer update(Long idParticiper, Long idCheval, Long idCourse, int classement) throws NotFoundException {
		if(idParticiper == null) {
			throw new ServiceException("idParticiper ne doit pas être null");
		}
		
		if(idCheval == null) {
			throw new ServiceException("idCheval ne doit pas être null");
		}
		
		if(idCourse == null) {
			throw new ServiceException("idCourse ne doit pas être null");
		}
		
		Participer participer = getById(idParticiper);
		
		participer.setCheval(new Cheval(idCheval));
		participer.setCourse(new Course(idCourse));
		participer.setClassement(classement);
		
		return save(participer);
	}
	
	public void delete(Long idParticiper) throws NotFoundException {
		if(idParticiper == null) {
			throw new ServiceException("idParticiper ne doit pas être null");
		}
		
		participerRepository.delete(new Participer(idParticiper));
	}
	
	public void deleteEveryParticipationByIdCheval(Long idCheval) {
		participerRepository.deleteEveryParticipationByIdCheval(idCheval);
	}
	
	public Participer save(Participer participer) {
		return participerRepository.save(participer);
	}

}
