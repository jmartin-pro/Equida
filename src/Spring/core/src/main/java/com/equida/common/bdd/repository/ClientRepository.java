package com.equida.common.bdd.repository;

import com.equida.common.bdd.entity.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	
	@Query(value = "SELECT c FROM Client c WHERE c.deleted=0 ORDER BY c.nom")
	public List<Client> findAll();
	
	@Query(value = "SELECT c FROM Client c WHERE c.deleted=0 ORDER BY c.nom")
	public List<Client> findAll(PageRequest pageRequest);
	
	@Query(value = "SELECT c FROM Client c WHERE c.id = ?1 AND c.deleted=0")
	public Optional<Client> findById(Long idClient);
	
}
