package com.equida.webapp.web.route.chevaux;

import com.equida.webapp.web.route.IRoute;

public class ChevauxUpdateRoute implements IRoute {
	public static final String PARAM_ID_CHEVAL = "idCheval";
	public static final String RAW_URI = "/chevaux/{"+PARAM_ID_CHEVAL+"}/update";

	private Long idCheval;
	
	public ChevauxUpdateRoute(Long idCheval) {
		this.idCheval = idCheval;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_CHEVAL+"}", ""+this.idCheval);
	}

	@Override
	public String getView() {
		return "view/chevaux/form";
	}

	@Override
	public String getTitle() {
		return "Modifier un cheval";
	}

	public Long getIdCheval() {
		return idCheval;
	}

	public void setIdCheval(Long idCheval) {
		this.idCheval = idCheval;
	}
	
}