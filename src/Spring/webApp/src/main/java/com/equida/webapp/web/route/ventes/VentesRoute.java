package com.equida.webapp.web.route.ventes;

import com.equida.webapp.web.route.IRoute;

public class VentesRoute implements IRoute {
	
	public static final String RAW_URI = "/ventes";
	public static final String PARAM_ID_CATEG_VENTE = "idCategVente";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/ventes/lister";
	}

	@Override
	public String getTitle() {
		return "Les ventes";
	}
	
}
