package com.equida.webapp.web.route.lieux;

import com.equida.webapp.web.route.IRoute;

public class LieuxUpdateRoute implements IRoute {
	public static final String PARAM_ID_LIEU = "idLieu";
	public static final String RAW_URI = "/lieux/{"+PARAM_ID_LIEU+"}/update";

	private Long idLieu;
	
	public LieuxUpdateRoute(Long idLieu) {
		this.idLieu = idLieu;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_LIEU+"}", ""+this.idLieu);
	}

	@Override
	public String getView() {
		return "view/lieux/form";
	}

	@Override
	public String getTitle() {
		return "Modifier un lieu";
	}

	public Long getIdLieu() {
		return idLieu;
	}

	public void setIdLieu(Long idLieu) {
		this.idLieu = idLieu;
	}
	
}
