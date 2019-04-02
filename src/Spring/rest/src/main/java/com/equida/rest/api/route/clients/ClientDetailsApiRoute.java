package com.equida.rest.api.route.clients;

import com.equida.rest.api.route.IRoute;


public class ClientDetailsApiRoute implements IRoute {

	public static final String PARAM_ID_CLIENT = "idClient";
	public static final String RAW_URI = ClientsApiRoute.RAW_URI+"/{"+PARAM_ID_CLIENT+"}";
	
	private Long id = 0L;
	
	public ClientDetailsApiRoute(Long id) {
		this.id = id;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_CLIENT+"}", ""+id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
