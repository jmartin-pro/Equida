package com.equida.common.bdd.repository;

import com.equida.common.bdd.entity.Hippodrome;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HippodromeRepository extends CrudRepository<Hippodrome, Long> {
	
	@Query(value = "SELECT h FROM Hippodrome h")
	public List<Hippodrome> findAll();
	
	@Query(value = "SELECT h FROM Hippodrome h")
	public List<Hippodrome> findAll(PageRequest pageRequest);

	@Query(value = "SELECT h FROM Hippodrome h WHERE h.id = ?1")
	public Optional<Hippodrome> findById(Long hippodrome);
	
}
