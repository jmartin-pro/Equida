package com.equida.rest.api.route.lots;

import com.equida.rest.api.route.IRoute;

public class LotsDispoVenteApiRoute implements IRoute {

	public static final String RAW_URI = LotsApiRoute.RAW_URI+"/dispoVente";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}
}
