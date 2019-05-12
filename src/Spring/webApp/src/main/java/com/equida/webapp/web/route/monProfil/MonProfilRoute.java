package com.equida.webapp.web.route.monProfil;

import com.equida.webapp.web.route.IRoute;

public class MonProfilRoute implements IRoute {
	
	public static final String RAW_URI = "/monProfil";
	
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
		return "Mon profil";
	}
	
}
