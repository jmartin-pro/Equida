package com.equida.webapp.web.route.pays;

import com.equida.webapp.web.route.IRoute;


public class PaysUpdateRoute implements IRoute{

	public static final String PARAM_ID_PAYS = "idPays";
	public static final String RAW_URI = "/pays/{"+PARAM_ID_PAYS+"}/update";

	private Long idPays;
	
	public PaysUpdateRoute(Long idPays) {
		this.idPays = idPays;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_PAYS+"}", ""+this.idPays);
	}

	@Override
	public String getView() {
		return "view/pays/form";
	}

	@Override
	public String getTitle() {
		return "Modifier un pays";
	}

	public Long getIdPays() {
		return idPays;
	}

	public void setIdPays(Long idPays) {
		this.idPays = idPays;
	}
	
}
