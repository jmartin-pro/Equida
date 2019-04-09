package com.equida.webapp.web.route.chevaux;

import com.equida.webapp.web.route.IRoute;

public class ChevauxDeleteRoute implements IRoute {
	
	public static final String PARAM_ID_CHEVAL = "idCheval";
	public static final String RAW_URI = "/chevaux/{"+PARAM_ID_CHEVAL+"}/delete";

	private Long idCheval;
	
	public ChevauxDeleteRoute(Long idCheval) {
		this.idCheval = idCheval;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_CHEVAL+"}", ""+this.idCheval);
	}

	@Override
	public String getView() {
		return null;
	}

	@Override
	public String getTitle() {
		return null;
	}

	public Long getIdCheval() {
		return idCheval;
	}

	public void setIdCheval(Long idCheval) {
		this.idCheval = idCheval;
	}

}
