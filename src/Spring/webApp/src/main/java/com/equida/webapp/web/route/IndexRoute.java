package com.equida.webapp.web.route;

public class IndexRoute implements IRoute{

	public static final String RAW_URI = "/";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/index";
	}

	@Override
	public String getTitle() {
		return null;
	}
}
