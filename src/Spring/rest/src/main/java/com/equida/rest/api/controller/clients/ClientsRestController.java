package com.equida.rest.api.controller.clients;

import com.equida.common.bdd.entity.Client;
import com.equida.common.service.ClientService;
import com.equida.rest.api.dto.ClientDto;
import com.equida.rest.api.dto.filter.BasicFilterDto;
import com.equida.rest.api.route.clients.ClientsApiRoute;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientsRestController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping(ClientsApiRoute.RAW_URI)
	public List<ClientDto> getClients(@Valid BasicFilterDto filterDto) {
		List<Client> clients = clientService.getAll(filterDto.getPageRequest());
		
		List<ClientDto> clientsDto = new ArrayList<>();
		
		for(Client c : clients) {			
			clientsDto.add(ClientDto.convertToDto(c));
		}
		
		return clientsDto;
	}
	
	@PostMapping(ClientsApiRoute.RAW_URI)
	public ClientDto addClient(@RequestBody ClientDto clientDto) {
		Client client = clientService.create(clientDto.getNom(), clientDto.getPrenom(), clientDto.getRue(), clientDto.getCopos(), clientDto.getVille(), clientDto.getMail());
		
		return ClientDto.convertToDto(client);
	}
	
}
