package com.equida.rest.api.route.pays;

import com.equida.rest.api.route.IRoute;


public class PaysApiRoute implements IRoute {

	public static final String RAW_URI = "/api/pays";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

}
