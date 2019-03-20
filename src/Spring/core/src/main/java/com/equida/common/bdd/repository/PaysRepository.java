package com.equida.common.bdd.repository;

import com.equida.common.bdd.entity.Pays;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysRepository extends CrudRepository<Pays, Long> {
	
	@Query(value = "SELECT p FROM Pays p WHERE p.deleted=0 ORDER BY p.libelle")
	public List<Pays> findAll();
	
	@Query(value = "SELECT p FROM Pays p WHERE p.deleted=0 ORDER BY p.libelle")
	public List<Pays> findAll(PageRequest pageRequest);
	
	@Query(value = "SELECT p FROM Pays p WHERE p.id = ?1 AND p.deleted=0")
	public Optional<Pays> findById(Long idPays);
	
}
