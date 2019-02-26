package com.equida.rest.bdd.repository;

import com.equida.rest.bdd.entity.Compte;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends CrudRepository<Compte, Long> {

	@Query(value = "SELECT c FROM Compte c WHERE c.login = ?1 AND c.deleted=0")
	public Optional<Compte> findByLogin(String login);
	
}
