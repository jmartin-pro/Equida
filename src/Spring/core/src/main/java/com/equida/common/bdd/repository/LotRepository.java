package com.equida.common.bdd.repository;

import com.equida.common.bdd.entity.Lot;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotRepository extends CrudRepository<Lot, Long> {
	
	@Query(value = "SELECT l FROM Lot l WHERE l.validation IS NOT NULL AND l.deleted=0 ORDER BY l.prixDepart DESC")
	public List<Lot> findAllEnVente();
	
	@Query(value = "SELECT l FROM Lot l WHERE l.vente.id = ?1 AND l.validation IS NOT NULL ORDER BY l.prixDepart DESC")
	public List<Lot> findByIdVente(Long idVente);
	
	@Query(value = "SELECT l FROM Lot l WHERE l.validation IS NOT NULL AND l.deleted=0 ORDER BY l.validation DESC")
	public List<Lot> find5Recents(PageRequest pageRequest);
	
}
