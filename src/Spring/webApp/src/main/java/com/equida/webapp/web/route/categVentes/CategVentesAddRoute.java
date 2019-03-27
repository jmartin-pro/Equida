package com.equida.webapp.web.route.categVentes;

import com.equida.webapp.web.route.IRoute;

public class CategVentesAddRoute implements IRoute{

	public static final String RAW_URI = "/categ-ventes/add";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/categVentes/form";
	}

	@Override
	public String getTitle() {
		return "Ajouter une catégorie de vente";
	}
}
