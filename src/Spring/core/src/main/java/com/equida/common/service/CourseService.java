package com.equida.common.service;

import com.equida.common.bdd.entity.Course;
import com.equida.common.bdd.repository.CourseRepository;
import com.equida.common.exception.NotFoudException;
import com.equida.common.exception.ServiceException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAll() {
		return courseRepository.findAll();
	}
	
	public List<Course> getAll(PageRequest pageRequest) {
		return courseRepository.findAll(pageRequest);
	}
	
	public Course getById(Long idCourse) {
		if(idCourse == null) {
			throw new ServiceException("L'id ne doit pas être null.");
		}
				
		Optional<Course> course = courseRepository.findById(idCourse);
	
		if(!course.isPresent()) {
			throw new NotFoudException("L'id de la course spécifié n'existe pas.");
		}
		
		return course.get();
	}

	public Course create(String nom, Date dateCourse, String ville) {
		if(nom == null) {
			throw new ServiceException("Nom ne doit pas être null.");
		}
		
		Course course = new Course();
		
		course.setId(null);
		course.setNom(nom);
		course.setDateCourse(dateCourse);
		course.setVille(ville);
		course.setDeleted(false);
		
		return save(course);
	}
	
	public Course updateCourse(Long idCourse, String nom, Date dateCourse, String ville) {
		if(idCourse == null) {
			throw new ServiceException("idCourse ne doit pas être null.");
		}
		
		if(nom == null) {
			throw new ServiceException("nom ne doit pas être null.");
		}
		
		Course course = getById(idCourse);
		
		course.setNom(nom);
		course.setDateCourse(dateCourse);
		course.setVille(ville);
		
		return save(course);
	}
	
	public void deleteCourse(Long idCourse) {
		if(idCourse == null) {
			throw new ServiceException("idCourse ne doit pas être null.");
		}
		
		Course course = getById(idCourse);
		
		course.setDeleted(true);
		save(course);
	}
	
	public Course save(Course course) {
		return courseRepository.save(course);
	}
	
}