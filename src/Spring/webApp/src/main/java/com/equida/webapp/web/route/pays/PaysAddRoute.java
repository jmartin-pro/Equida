package com.equida.webapp.web.route.pays;

import com.equida.webapp.web.route.IRoute;


public class PaysAddRoute implements IRoute{

	public static final String RAW_URI = "/pays/add";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/pays/form";
	}

	@Override
	public String getTitle() {
		return "Ajouter un pays";
	}
}
