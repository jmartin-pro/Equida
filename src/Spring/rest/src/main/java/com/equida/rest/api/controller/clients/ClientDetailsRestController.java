package com.equida.rest.api.controller.clients;

import com.equida.common.bdd.entity.Client;
import com.equida.common.exception.NotFoundException;
import com.equida.common.service.ClientService;
import com.equida.rest.api.dto.ClientDto;
import com.equida.rest.api.route.clients.ClientDetailsApiRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientDetailsRestController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping(ClientDetailsApiRoute.RAW_URI)
	public ClientDto getClient(@PathVariable(value = ClientDetailsApiRoute.PARAM_ID_CLIENT) Long idClient) throws NotFoundException {
		Client client = clientService.getById(idClient);
		
		return ClientDto.convertToDto(client);
	}
	
	@PatchMapping(ClientDetailsApiRoute.RAW_URI)
	public void updateClient(@PathVariable(value = ClientDetailsApiRoute.PARAM_ID_CLIENT) Long idClient, @RequestBody ClientDto clientDto) throws NotFoundException {
		clientService.update(idClient, clientDto.getNom(), clientDto.getPrenom(), clientDto.getRue(), clientDto.getCopos(), clientDto.getVille(), clientDto.getMail());
	}
	
	@DeleteMapping(ClientDetailsApiRoute.RAW_URI)
	public void deleteClient(@PathVariable(value = ClientDetailsApiRoute.PARAM_ID_CLIENT) Long idClient) throws NotFoundException {
		clientService.delete(idClient);
	}

}
