package com.equida.bdd.repository;

import com.equida.bdd.entity.Vente;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteRepository extends CrudRepository<Vente, Long> {
	
	@Override
	public List<Vente> findAll();
	
	@Query(value = "SELECT v FROM Vente v WHERE v.deleted=0")
	public List<Vente> findAll(PageRequest pageRequest);

	@Query(value = "SELECT v FROM Vente v WHERE v.categVente.id = ?1 AND v.deleted=0")
	public List<Vente> findAllByIdCategVente(Long idCategVente, PageRequest pageRequest);
	
}
