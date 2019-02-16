package com.equida.bdd.repository;

import com.equida.bdd.entity.RaceCheval;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceChevalRepository extends CrudRepository<RaceCheval, Long> {
	
	@Override
	public List<RaceCheval> findAll();
	
}
