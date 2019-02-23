package com.equida.api.route;


public class VentesApiRoute implements IRoute {

	public static final String RAW_URI = "/api/ventes";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

}
