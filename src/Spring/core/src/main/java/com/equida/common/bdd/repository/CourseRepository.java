package com.equida.common.bdd.repository;

import com.equida.common.bdd.entity.Course;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
	
	@Query(value = "SELECT c FROM Course c WHERE c.deleted=0")
	public List<Course> findAll();
	
	@Query(value = "SELECT c FROM Course c WHERE c.deleted=0")
	public List<Course> findAll(PageRequest pageRequest);

	@Query(value = "SELECT c FROM Course c WHERE c.id = ?1 AND c.deleted=0")
	public Optional<Course> findById(Long idLieu);
	
}
