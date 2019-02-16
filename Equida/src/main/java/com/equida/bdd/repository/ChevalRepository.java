package com.equida.bdd.repository;

import com.equida.bdd.entity.Cheval;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChevalRepository extends CrudRepository<Cheval, Long> {
	
	@Override
	public List<Cheval> findAll();
	
}
