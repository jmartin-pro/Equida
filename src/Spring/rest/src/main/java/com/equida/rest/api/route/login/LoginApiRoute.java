package com.equida.rest.api.route.login;

import com.equida.rest.api.route.IRoute;

public class LoginApiRoute implements IRoute {

	public static final String RAW_URI = "/api/login";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

}
