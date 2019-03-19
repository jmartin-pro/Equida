package com.equida.rest.api.route.chevaux;

import com.equida.rest.api.route.IRoute;


public class ChevauxApiRoute implements IRoute {

	public static final String RAW_URI = "/api/chevaux";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

}
