package com.equida.webapp.web.route.categVentes;

import com.equida.webapp.web.route.IRoute;

public class CategVentesDeleteRoute implements IRoute{

	public static final String PARAM_ID_CATEG_VENTES = "idCategVentes";
	public static final String RAW_URI = "/categ-ventes/{"+PARAM_ID_CATEG_VENTES+"}/delete";

	private Long idCategVentes;
	
	public CategVentesDeleteRoute(Long idCategVentes) {
		this.idCategVentes = idCategVentes;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_CATEG_VENTES+"}", ""+this.idCategVentes);
	}

	@Override
	public String getView() {
		return null;
	}

	@Override
	public String getTitle() {
		return null;
	}

	public Long getIdCategVentes() {
		return idCategVentes;
	}

	public void setIdCategVentes(Long idCategVentes) {
		this.idCategVentes = idCategVentes;
	}
	
}
