package com.equida.rest.api.route.lots;

import com.equida.rest.api.route.IRoute;

public class LotsApiRoute implements IRoute {

	public static final String RAW_URI = "/api/lots";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

}
