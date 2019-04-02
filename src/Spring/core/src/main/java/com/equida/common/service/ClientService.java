package com.equida.common.service;

import com.equida.common.bdd.entity.Client;
import com.equida.common.exception.NotFoudException;
import com.equida.common.bdd.repository.ClientRepository;
import com.equida.common.exception.ServiceException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAll() {
		return clientRepository.findAll();
	}
	
	public List<Client> getAll(PageRequest pageRequest) {
		return clientRepository.findAll(pageRequest);
	}

	public Client getById(Long idClient) {
		Optional<Client> client = clientRepository.findById(idClient);
	
		if(!client.isPresent()) {
			throw new NotFoudException("L'id du client spécifié n'existe pas.");
		}
		
		return client.get();
	}

	public Client create(String nom, String prenom, String rue, String copos, String ville, String mail) {
		if(nom == null) {
			throw new ServiceException("nom ne doit pas être null");
		}
		
		if(prenom == null) {
			throw new ServiceException("prenom ne doit pas être null");
		}
		
		if(rue == null) {
			throw new ServiceException("rue ne doit pas être null");
		}
		
		if(copos == null) {
			throw new ServiceException("copos ne doit pas être null");
		}
		
		if(ville == null) {
			throw new ServiceException("ville ne doit pas être null");
		}
		
		if(mail == null) {
			throw new ServiceException("mail ne doit pas être null");
		}
		
		Client client = new Client();
		
		client.setId(null);
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setRue(rue);
		client.setCopos(copos);
		client.setVille(ville);
		client.setMail(mail);
		client.setDeleted(false);
		
		return save(client);
	}
	
	public Client update(Long idClient, String nom, String prenom, String rue, String copos, String ville, String mail) {
		if(idClient == null) {
			throw new ServiceException("idClient ne doit pas être null");
		}
		
		Client client = getById(idClient);
		
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setRue(rue);
		client.setCopos(copos);
		client.setVille(ville);
		client.setMail(mail);
		client.setDeleted(false);
		
		return save(client);
	}
	
	public void delete(Long idClient) {
		if(idClient == null) {
			throw new ServiceException("idClient ne doit pas être null");
		}
		
		Client client = getById(idClient);
		
		client.setDeleted(true);
		save(client);
	}
	
	public Client save(Client client) {
		return clientRepository.save(client);
	}
	
}
