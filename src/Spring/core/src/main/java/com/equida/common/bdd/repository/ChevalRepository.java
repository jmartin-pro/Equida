package com.equida.common.bdd.repository;

import com.equida.common.bdd.entity.Cheval;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChevalRepository extends CrudRepository<Cheval, Long> {
	
	@Query(value = "SELECT c FROM Cheval c WHERE c.deleted=0")
	public List<Cheval> findAll();
	
	@Query(value = "SELECT c FROM Cheval c WHERE c.deleted=0")
	public List<Cheval> findAll(PageRequest pageRequest);
	
	@Query(value = "SELECT c FROM Cheval c WHERE c.client.id = ?1 AND c.deleted=0")
	public List<Cheval> findAll(Long idClient);

	@Query(value = "SELECT c FROM Cheval c WHERE c.sire = ?1 AND c.deleted=0")
	public Optional<Cheval> findBySire(String sireCheval);
	
}
