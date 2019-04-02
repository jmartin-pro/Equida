package com.equida.rest.api.route.clients;

import com.equida.rest.api.route.IRoute;


public class ClientsApiRoute implements IRoute {

	public static final String RAW_URI = "/api/clients";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

}
