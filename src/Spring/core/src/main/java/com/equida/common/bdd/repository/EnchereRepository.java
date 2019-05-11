package com.equida.common.bdd.repository;

import com.equida.common.bdd.entity.Enchere;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnchereRepository extends CrudRepository<Enchere, Long> {
	
	@Query(value = "SELECT e FROM Enchere e WHERE e.deleted=0 ORDER BY e.montant DESC")
	public List<Enchere> findAll(PageRequest pageRequest);
	
	@Query(value = "SELECT e FROM Enchere e WHERE e.deleted=0 ORDER BY e.montant DESC")
	public List<Enchere> findAll();

	@Query(value = "SELECT e FROM Enchere e WHERE e.lot.id = ?1 AND e.deleted=0 ORDER BY e.montant DESC")
	public List<Enchere> findAllByIdLot(Long idLot);
	
}
