package com.equida.rest.api.route.races_chevaux;

import com.equida.rest.api.route.IRoute;


public class RacesChevauxApiRoute implements IRoute {

	public static final String RAW_URI = "/api/racesChevaux";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

}
