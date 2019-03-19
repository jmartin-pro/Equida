package com.equida.rest.api.route.ventes;

import com.equida.rest.api.route.IRoute;


public class VenteDetailsApiRoute implements IRoute {

	public static final String PARAM_ID_VENTE = "idVente";
	public static final String RAW_URI = VentesApiRoute.RAW_URI+"/{"+PARAM_ID_VENTE+"}";
	
	private Long id = 0L;
	
	public VenteDetailsApiRoute(Long id) {
		this.id = id;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_VENTE+"}", ""+id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
