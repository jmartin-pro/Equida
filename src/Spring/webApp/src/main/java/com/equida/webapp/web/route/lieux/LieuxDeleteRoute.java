package com.equida.webapp.web.route.lieux;

import com.equida.webapp.web.route.IRoute;

public class LieuxDeleteRoute implements IRoute {
	
	public static final String PARAM_ID_LIEU = "idLieu";
	public static final String RAW_URI = "/lieux/{"+PARAM_ID_LIEU+"}/delete";

	private Long idLieu;
	
	public LieuxDeleteRoute(Long idLieu) {
		this.idLieu = idLieu;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_LIEU+"}", ""+this.idLieu);
	}

	@Override
	public String getView() {
		return null;
	}

	@Override
	public String getTitle() {
		return null;
	}

	public Long getIdLieu() {
		return idLieu;
	}

	public void setIdLieu(Long idLieu) {
		this.idLieu = idLieu;
	}
}
