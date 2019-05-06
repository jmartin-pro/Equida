package com.equida.common.bdd.repository;

import com.equida.common.bdd.entity.Lot;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotRepository extends CrudRepository<Lot, Long> {
	
	@Query(value = "SELECT l FROM Lot l WHERE l.validation IS NOT NULL ORDER BY l.prixDepart DESC")
	public List<Lot> findAllValide();
	
	@Query(value = "SELECT l FROM Lot l WHERE l.vente.id = ?1 AND l.validation IS NOT NULL ORDER BY l.prixDepart DESC")
	public List<Lot> findByIdVente(Long idVente);
	
}
