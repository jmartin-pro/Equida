package com.equida.webapp.web.route.chevaux;

import com.equida.webapp.web.route.IRoute;

public class ChevauxRoute implements IRoute {
	
	public static final String RAW_URI = "/chevaux";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/chevaux/lister";
	}

	@Override
	public String getTitle() {
		return "Mes chevaux";
	}
	
}
