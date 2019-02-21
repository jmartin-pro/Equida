package com.equida.bdd.repository;

import com.equida.bdd.entity.Cheval;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChevalRepository extends CrudRepository<Cheval, Long> {
	
	@Override
	public List<Cheval> findAll();
	
	@Query(value = "SELECT c FROM Cheval c WHERE c.deleted=0")
	public List<Cheval> findAll(PageRequest pageRequest);
	
}
