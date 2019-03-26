package com.equida.webapp.web.route.races;

import com.equida.webapp.web.route.IRoute;

public class RacesChevalAddRoute implements IRoute {
	
	public static final String RAW_URI = "/races/add";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/races/form";
	}

	@Override
	public String getTitle() {
		return "Ajouter une race";
	}
	
}
