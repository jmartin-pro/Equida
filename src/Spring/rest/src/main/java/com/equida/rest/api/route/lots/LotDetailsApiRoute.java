package com.equida.rest.api.route.lots;

import com.equida.rest.api.route.IRoute;

public class LotDetailsApiRoute implements IRoute {

	public static final String PARAM_ID_LOT = "idLot";
	public static final String RAW_URI = LotsApiRoute.RAW_URI+"/{"+PARAM_ID_LOT+"}";
	
	private Long id = 0L;
	
	public LotDetailsApiRoute(Long id) {
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
