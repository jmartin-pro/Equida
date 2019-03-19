package com.equida.webapp.web.route.footer;

import com.equida.webapp.web.route.IRoute;


public class ContactRoute implements IRoute{

	public static final String RAW_URI = "/contact";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/footer/contact";
	}

	@Override
	public String getTitle() {
		return "Nous contacter";
	}
}
