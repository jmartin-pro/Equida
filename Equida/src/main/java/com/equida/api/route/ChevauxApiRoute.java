package com.equida.api.route;


public class ChevauxApiRoute implements IRoute {

	public static final String RAW_URI = "/api/chevaux";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

}
