package com.equida.api.route.pays;

import com.equida.api.route.IRoute;


public class PaysDetailsApiRoute implements IRoute {

	public static final String PARAM_ID_PAYS = "idPays";
	public static final String RAW_URI = PaysApiRoute.RAW_URI+"/{"+PARAM_ID_PAYS+"}";
	
	private Long id = 0L;
	
	public PaysDetailsApiRoute(Long id) {
		this.id = id;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_PAYS+"}", ""+id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
