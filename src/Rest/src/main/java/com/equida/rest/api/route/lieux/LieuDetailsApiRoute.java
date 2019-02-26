package com.equida.rest.api.route.lieux;

import com.equida.rest.api.route.IRoute;

public class LieuDetailsApiRoute implements IRoute {

	public static final String PARAM_ID_LIEU = "idVente";
	public static final String RAW_URI = LieuxApiRoute.RAW_URI+"/{"+PARAM_ID_LIEU+"}";
	
	private Long id = 0L;
	
	public LieuDetailsApiRoute(Long id) {
		this.id = id;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_LIEU+"}", ""+id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
