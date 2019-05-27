package com.equida.webapp.web.route.hippodromes;

import com.equida.webapp.web.route.IRoute;

public class HippodromesAddRoute implements IRoute {
	
	public static final String RAW_URI = "/hippodromes/add";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/hippodromes/form";
	}

	@Override
	public String getTitle() {
		return "Ajouter un hippodrome";
	}
	
}
