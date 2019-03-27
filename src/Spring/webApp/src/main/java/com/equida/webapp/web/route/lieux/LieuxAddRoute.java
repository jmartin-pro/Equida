package com.equida.webapp.web.route.lieux;

import com.equida.webapp.web.route.IRoute;

public class LieuxAddRoute implements IRoute {
	
	public static final String RAW_URI = "/lieux/add";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/lieux/form";
	}

	@Override
	public String getTitle() {
		return "Ajouter un lieu";
	}
	
}