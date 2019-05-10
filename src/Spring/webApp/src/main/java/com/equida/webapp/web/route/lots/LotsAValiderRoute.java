package com.equida.webapp.web.route.lots;

import com.equida.webapp.web.route.lots.*;
import com.equida.webapp.web.route.IRoute;

public class LotsAValiderRoute implements IRoute {
	
	public static final String RAW_URI = "/lots/listerAValider";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/lots/listerAValider";
	}

	@Override
	public String getTitle() {
		return "Les lots à valider";
	}
	
}
