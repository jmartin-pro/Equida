package com.equida.webapp.web.route.encheres;

import com.equida.webapp.web.route.IRoute;

public class EncheresAddRoute implements IRoute {
	
	public static final String PARAM_ID_LOT = "idLot";
	public static final String RAW_URI = "/encheres/{"+PARAM_ID_LOT+"}/add";
	
	private Long idLot;
	
	public EncheresAddRoute(Long idLot) {
		this.idLot = idLot;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_LOT+"}", ""+this.idLot);
	}

	@Override
	public String getView() {
		return "view/encheres/form";
	}

	@Override
	public String getTitle() {
		return "Ajouter une enchere";
	}
}