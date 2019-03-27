package com.equida.webapp.web.route.categVentes;

import com.equida.webapp.web.route.IRoute;

public class CategVentesUpdateRoute implements IRoute{

	public static final String PARAM_ID_CATEG_VENTES = "idCategVentes";
	public static final String RAW_URI = "/categ-ventes/{"+PARAM_ID_CATEG_VENTES+"}/update";

	private Long idCategVentes;
	
	public CategVentesUpdateRoute(Long idCategVentes) {
		this.idCategVentes = idCategVentes;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_CATEG_VENTES+"}", ""+this.idCategVentes);
	}

	@Override
	public String getView() {
		return "view/categVentes/form";
	}

	@Override
	public String getTitle() {
		return "Modifier une catégorie de vente";
	}

	public Long getIdPays() {
		return idCategVentes;
	}

	public void setIdCategVentes(Long idCategVentes) {
		this.idCategVentes = idCategVentes;
	}
	
}