package com.equida.webapp.web.route.utilisateurs;

import com.equida.webapp.web.route.IRoute;

public class UtilisateursAddRoute implements IRoute {
	
	public static final String RAW_URI = "/utilisateurs/add";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/utilisateurs/form";
	}

	@Override
	public String getTitle() {
		return "Ajouter un utilisateur";
	}
	
}
