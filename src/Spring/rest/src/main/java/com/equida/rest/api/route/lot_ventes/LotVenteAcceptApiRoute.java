package com.equida.rest.api.route.lot_ventes;

import com.equida.rest.api.route.IRoute;

public class LotVenteAcceptApiRoute implements IRoute {

	public static final String PARAM_ID_LOT = "idLot";
	public static final String RAW_URI = LotVenteAValiderApiRoute.RAW_URI+"/{"+PARAM_ID_LOT+"}"+"/accept";
	
	private Long id = 0L;
	
	public LotVenteAcceptApiRoute(Long id) {
		this.id = id;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_LOT+"}", ""+id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
