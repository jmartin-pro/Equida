package com.equida.common.bdd.repository;

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
	public List<Lot> findAll();
	
	@Query(value = "SELECT l FROM Lot l WHERE l.deleted=0 AND l.validation IS NULL")
	public List<Lot> findAll(PageRequest pageRequest);
	
	@Query(value = "SELECT l FROM Lot l WHERE l.id = ?1 AND l.deleted=0")
	public Optional<Lot> findById(Long idLot);
	
	@Query(value = "SELECT l FROM Lot l WHERE l.deleted=0 AND l.cheval.id = ?1")
	public Optional<Lot> findLotCheval(Long idCheval);
	
}
