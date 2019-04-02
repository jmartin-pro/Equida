package com.equida.rest.api.controller.clients;

import com.equida.rest.api.dto.filter.BasicFilterDto;
import com.equida.rest.api.route.clients.ClientsApiRoute;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientsRestController {
	
	@GetMapping(ClientsApiRoute.RAW_URI)
	public void getClients(@Valid BasicFilterDto filterDto) {
	}
	
	@PostMapping(ClientsApiRoute.RAW_URI)
	public void addClient() {
	}
	
}
