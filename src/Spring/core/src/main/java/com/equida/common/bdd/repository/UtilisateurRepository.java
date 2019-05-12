package com.equida.common.bdd.repository;

import com.equida.common.bdd.entity.Utilisateur;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
	
	@Query(value = "SELECT u FROM Utilisateur u WHERE u.deleted=0")
	public List<Utilisateur> findAll();
	
	@Query(value = "SELECT u FROM Utilisateur u WHERE u.deleted=0")
	public List<Utilisateur> findAll(PageRequest pageRequest);
	
	@Query(value = "SELECT u FROM Utilisateur u WHERE u.id = ?1 AND u.deleted=0")
	public Optional<Utilisateur> findById(Long idUtilisateur);
}
