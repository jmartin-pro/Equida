package com.equida.webapp.web.route.pays;

import com.equida.webapp.web.route.IRoute;


public class PaysRoute implements IRoute{

	public static final String RAW_URI = "/pays";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/pays/index";
	}

	@Override
	public String getTitle() {
		return "Les pays";
	}
}
