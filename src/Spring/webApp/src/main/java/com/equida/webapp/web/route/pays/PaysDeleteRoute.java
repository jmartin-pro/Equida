package com.equida.webapp.web.route.pays;

import com.equida.webapp.web.route.IRoute;

public class PaysDeleteRoute implements IRoute{

	public static final String PARAM_ID_PAYS = "idPays";
	public static final String RAW_URI = "/pays/{"+PARAM_ID_PAYS+"}/delete";

	private Long idPays;
	
	public PaysDeleteRoute(Long idPays) {
		this.idPays = idPays;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_PAYS+"}", ""+this.idPays);
	}

	@Override
	public String getView() {
		return null;
	}

	@Override
	public String getTitle() {
		return null;
	}
}
