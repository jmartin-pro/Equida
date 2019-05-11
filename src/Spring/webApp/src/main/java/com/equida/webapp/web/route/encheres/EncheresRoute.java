package com.equida.webapp.web.route.encheres;

import com.equida.webapp.web.route.IRoute;

public class EncheresRoute implements IRoute {
	
	public static final String PARAM_ID_LOT = "idLot";
	public static final String RAW_URI = "/encheres/{"+PARAM_ID_LOT+"}";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/encheres/lister";
	}

	@Override
	public String getTitle() {
		return "Les encheres";
	}
	
}
