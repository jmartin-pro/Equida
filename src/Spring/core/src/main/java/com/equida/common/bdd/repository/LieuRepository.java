package com.equida.common.bdd.repository;

import com.equida.common.bdd.entity.Lieu;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuRepository extends CrudRepository<Lieu, Long> {
	
	@Override
	public List<Lieu> findAll();
	
	@Query(value = "SELECT l FROM Lieu l WHERE l.deleted=0")
	public List<Lieu> findAll(PageRequest pageRequest);

	@Query(value = "SELECT l FROM Lieu l WHERE l.id = ?1 AND l.deleted=0")
	public Optional<Lieu> findById(Long idLieu);
	
}
