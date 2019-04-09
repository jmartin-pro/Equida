package com.equida.webapp.web.route.chevaux;

import com.equida.webapp.web.route.IRoute;

public class ChevauxAddRoute implements IRoute {
	
	public static final String RAW_URI = "/chevaux/add";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/chevaux/form";
	}

	@Override
	public String getTitle() {
		return "Ajouter un cheval";
	}
	
}
