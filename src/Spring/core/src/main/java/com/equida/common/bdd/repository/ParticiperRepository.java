package com.equida.common.bdd.repository;

import com.equida.common.bdd.entity.Participer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticiperRepository extends CrudRepository<Participer, Long> {
	
	@Query(value = "SELECT p FROM Participer p")
	public List<Participer> findAll(PageRequest pageRequest);
	
	@Query(value = "SELECT p FROM Participer p")
	public List<Participer> findAll();
	
	@Query(value = "SELECT p FROM Participer p WHERE p.id=?1")
	public Optional<Participer> findById(Long idRaceCheval);

	@Query(value = "SELECT p FROM Participer p WHERE p.cheval.id=?1")
	public List<Participer> findAllByIdCheval(Long idCheval);
	
}
