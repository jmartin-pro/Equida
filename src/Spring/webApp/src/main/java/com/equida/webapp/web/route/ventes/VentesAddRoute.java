package com.equida.webapp.web.route.ventes;

import com.equida.webapp.web.route.ventes.*;
import com.equida.webapp.web.route.IRoute;

public class VentesAddRoute implements IRoute {
	
	public static final String RAW_URI = "/ventes/add";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/ventes/form";
	}

	@Override
	public String getTitle() {
		return "Ajouter une vente";
	}
	
}
