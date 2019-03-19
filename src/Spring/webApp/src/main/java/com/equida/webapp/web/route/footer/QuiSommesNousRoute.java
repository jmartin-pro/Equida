package com.equida.webapp.web.route.footer;

import com.equida.webapp.web.route.IRoute;


public class QuiSommesNousRoute implements IRoute{

	public static final String RAW_URI = "/qui-sommes-nous";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/footer/qui-sommes-nous";
	}

	@Override
	public String getTitle() {
		return "Qui sommes nous?";
	}
}
