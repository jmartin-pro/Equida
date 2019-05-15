package com.equida.rest.api.route.lot_ventes;

import com.equida.rest.api.route.IRoute;

public class LotVenteAValiderApiRoute implements IRoute {

	public static final String RAW_URI = "api/lotsAValider";
	
	public LotVenteAValiderApiRoute() {
	}
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

}
