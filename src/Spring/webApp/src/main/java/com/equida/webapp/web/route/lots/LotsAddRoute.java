package com.equida.webapp.web.route.lots;

import com.equida.webapp.web.route.IRoute;

public class LotsAddRoute implements IRoute {
	
	public static final String RAW_URI = "/lots/add";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/lots/form";
	}

	@Override
	public String getTitle() {
		return "Ajouter un lot";
	}
	
}
