package com.equida.webapp.web.route.footer;

import com.equida.webapp.web.route.IRoute;


public class MentionsLegalesRoute implements IRoute{

	public static final String RAW_URI = "/mentions-legales";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/footer/mentions-legales";
	}

	@Override
	public String getTitle() {
		return "Mentions légales";
	}
}
