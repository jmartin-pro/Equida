package com.equida.webapp.web.route.categVentes;

import com.equida.webapp.web.route.IRoute;

public class CategVentesRoute implements IRoute{

	public static final String RAW_URI = "/categ-ventes";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/categVentes/lister";
	}

	@Override
	public String getTitle() {
		return "Les catégories de vente";
	}
}
