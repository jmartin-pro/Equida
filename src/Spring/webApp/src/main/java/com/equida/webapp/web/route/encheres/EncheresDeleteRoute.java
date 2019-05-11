package com.equida.webapp.web.route.encheres;

import com.equida.webapp.web.route.IRoute;

public class EncheresDeleteRoute implements IRoute {
	
	public static final String PARAM_ID_ENCHERE = "idEnchere";
	public static final String PARAM_ID_LOT = "idLot";
	public static final String RAW_URI = "/encheres/{"+PARAM_ID_LOT+"}/{"+PARAM_ID_ENCHERE+"}/delete";

	private Long idEnchere;
	private Long idLot;
	
	public EncheresDeleteRoute(Long idLot, Long idEnchere) {
		this.idLot = idLot;
		this.idEnchere = idEnchere;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_LOT+"}", ""+this.idLot).replace("{"+PARAM_ID_ENCHERE+"}", ""+this.idEnchere);
	}

	@Override
	public String getView() {
		return null;
	}

	@Override
	public String getTitle() {
		return null;
	}

	public Long getIdEnchere() {
		return idEnchere;
	}

	public void setIdEnchere(Long idEnchere) {
		this.idEnchere = idEnchere;
	}

}