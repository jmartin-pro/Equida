package com.equida.rest.api.route.ventes;

import com.equida.rest.api.route.IRoute;


public class VentesApiRoute implements IRoute {

	public static final String RAW_URI = "/api/ventes";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

}
