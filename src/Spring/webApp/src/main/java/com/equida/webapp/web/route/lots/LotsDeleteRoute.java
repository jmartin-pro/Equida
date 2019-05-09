package com.equida.webapp.web.route.lots;

import com.equida.webapp.web.route.IRoute;

public class LotsDeleteRoute implements IRoute {
	
	public static final String PARAM_ID_LOT = "idLot";
	public static final String RAW_URI = "/lots/{"+PARAM_ID_LOT+"}/delete";

	private Long idLot;
	
	public LotsDeleteRoute(Long idLot) {
		this.idLot = idLot;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_LOT+"}", ""+this.idLot);
	}

	@Override
	public String getView() {
		return null;
	}

	@Override
	public String getTitle() {
		return null;
	}

	public Long getIdLot() {
		return idLot;
	}

	public void setIdLot(Long idLot) {
		this.idLot = idLot;
	}

}