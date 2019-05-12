package com.equida.common.bdd.repository;

import com.equida.common.bdd.entity.Pays;
import com.equida.common.bdd.entity.Role;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	
	@Query(value = "SELECT r FROM Role r WHERE r.deleted=0")
	public List<Role> findAll();
	
	@Query(value = "SELECT r FROM Role r WHERE r.deleted=0")
	public List<Role> findAll(PageRequest pageRequest);
	
	@Query(value = "SELECT r FROM Role r WHERE r.id = ?1 AND r.deleted=0")
	public Optional<Role> findById(Long idRole);
	
}
