package com.equida.webapp.web.route.lots;

import com.equida.webapp.web.route.IRoute;

public class LotsRoute implements IRoute {
	
	public static final String RAW_URI = "/lots";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/lots/lister";
	}

	@Override
	public String getTitle() {
		return "Les lots";
	}
	
}
