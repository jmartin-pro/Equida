package com.equida.common.bdd.repository;

import com.equida.common.bdd.entity.Cheval;
import com.equida.common.bdd.entity.Lot;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotRepository extends CrudRepository<Lot, Long> {
		
	@Query(value = "SELECT l FROM Lot l WHERE l.deleted=0 AND l.validation IS NULL")
	public List<Lot> findAllAValider();
	
	@Query(value = "SELECT l FROM Lot l WHERE l.deleted=0 AND l.validation IS NULL")
	public List<Lot> findAllAValider(PageRequest pageRequest);
	
	@Query(value = "SELECT l FROM Lot l WHERE l.id = ?1 AND l.deleted=0")
	public Optional<Lot> findById(Long idLot);
	
	@Query(value = "SELECT l FROM Lot l WHERE l.deleted=0 AND l.cheval.id = ?1")
	public Optional<Lot> findLotCheval(Long idCheval);
	
	@Query(value = "SELECT l FROM Lot l WHERE l.validation IS NOT NULL AND l.deleted=0 ORDER BY l.prixDepart DESC")
	public List<Lot> findAllEnVente();
	
	@Query(value = "SELECT l FROM Lot l WHERE l.validation IS NOT NULL AND l.deleted=0 ORDER BY l.prixDepart DESC")
	public List<Lot> findAllEnVente(PageRequest pageRequest);
	
	@Query(value = "SELECT l FROM Lot l WHERE l.vente.id = ?1 AND l.validation IS NOT NULL ORDER BY l.prixDepart DESC")
	public List<Lot> findByIdVente(Long idVente);
		
	@Query(value = "SELECT l FROM Lot l WHERE l.vente.id = ?1 AND l.validation IS NOT NULL AND l.deleted=0 ORDER BY l.prixDepart DESC")
	public List<Lot> findByIdVente(Long idVente, PageRequest pageRequest);
	
	@Query(value = "SELECT c FROM Cheval c WHERE c.client.id = ?1 AND c.id NOT IN (SELECT l.cheval.id FROM Lot l WHERE l.deleted=0) AND c.deleted=0")
	public List<Lot> findChevauxDispoVenteClient(Long idClient);
	
	@Query(value = "SELECT c FROM Cheval c WHERE c.client.id = ?1 AND c.id NOT IN (SELECT l.cheval.id FROM Lot l WHERE l.deleted=0) AND c.deleted=0")
	public List<Cheval> findChevauxDispoVente(Long idClient, PageRequest pageRequest);
	
	@Query(value = "SELECT l FROM Lot l WHERE l.validation IS NOT NULL AND l.deleted=0 ORDER BY l.validation DESC")
	public List<Lot> find5Recents(PageRequest pageRequest);	
}
