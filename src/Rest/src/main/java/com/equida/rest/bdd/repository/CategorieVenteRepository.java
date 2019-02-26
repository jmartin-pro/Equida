package com.equida.rest.bdd.repository;

import com.equida.rest.bdd.entity.CategVente;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieVenteRepository extends CrudRepository<CategVente, Long> {
	
	@Override
	public List<CategVente> findAll();
	
	@Query(value = "SELECT cv FROM CategVente cv WHERE cv.deleted=0")
	public List<CategVente> findAll(PageRequest pageRequest);

	@Query(value = "SELECT cv FROM CategVente cv WHERE cv.id = ?1 AND cv.deleted=0")
	public Optional<CategVente> findById(Long idLieu);
	
}
