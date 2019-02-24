package com.equida.api.route.lieux;

import com.equida.api.route.IRoute;

public class LieuxApiRoute implements IRoute {

	public static final String RAW_URI = "/api/lieux";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

}
