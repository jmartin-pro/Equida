package com.equida.common.service;

import com.equida.common.bdd.entity.Role;
import com.equida.common.exception.NotFoundException;
import com.equida.common.exception.ServiceException;
import com.equida.common.bdd.repository.RoleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getAll() {
		return roleRepository.findAll();
	}
	
	public List<Role> getAll(PageRequest pageRequest) {
		return roleRepository.findAll(pageRequest);
	}

	public Role getById(Long idRole) throws NotFoundException {
		Optional<Role> role = roleRepository.findById(idRole);
	
		if(!role.isPresent()) {
			throw new NotFoundException("L'id du role spécifié n'existe pas.");
		}
		
		return role.get();
	}
	
}
