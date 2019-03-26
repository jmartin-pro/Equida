package com.equida.webapp.web.route.races;

import com.equida.webapp.web.route.IRoute;

public class RacesChevalRoute implements IRoute {
	
	public static final String RAW_URI = "/races";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/races/lister";
	}

	@Override
	public String getTitle() {
		return "Les races";
	}
	
}
