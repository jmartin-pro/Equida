package com.equida.webapp.web.route.lieux;

import com.equida.webapp.web.route.IRoute;

public class LieuxRoute implements IRoute {
	
	public static final String RAW_URI = "/lieux";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/lieux/lister";
	}

	@Override
	public String getTitle() {
		return "Les lieux";
	}
	
}
