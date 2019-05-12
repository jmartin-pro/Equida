package com.equida.webapp.web.route.utilisateurs;

import com.equida.webapp.web.route.ventes.*;
import com.equida.webapp.web.route.IRoute;

public class UtilisateursRoute implements IRoute {
	
	public static final String RAW_URI = "/utilisateurs";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/utilisateurs/lister";
	}

	@Override
	public String getTitle() {
		return "Les ventes";
	}
	
}
