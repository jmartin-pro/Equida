package com.equida.bdd.repository;

import com.equida.bdd.entity.RaceCheval;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceChevalRepository extends CrudRepository<RaceCheval, Long> {
	
	@Query(value = "SELECT rc FROM RaceCheval rc WHERE rc.deleted=0")
	public List<RaceCheval> findAll(PageRequest pageRequest);
	
	@Query(value = "SELECT rc FROM RaceCheval rc WHERE rc.id=?1 AND rc.deleted=0")
	public Optional<RaceCheval> findById(Long idRaceCheval);
	
}
