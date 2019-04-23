package com.equida.webapp.web.route.chevaux;

import com.equida.webapp.web.route.chevaux.*;
import com.equida.webapp.web.route.IRoute;

public class ChevauxConsulterRoute implements IRoute {
	
	public static final String PARAM_ID_CHEVAL = "idCheval";
	public static final String RAW_URI = "/chevaux/{"+PARAM_ID_CHEVAL+"}";
	
	private Long idCheval;

	public ChevauxConsulterRoute(Long idCheval) {
		this.idCheval = idCheval;
	}

	@Override
	public String getUri() {
		return RAW_URI.replace(PARAM_ID_CHEVAL, ""+idCheval);
	}

	@Override
	public String getView() {
		return "view/chevaux/consulter";
	}

	@Override
	public String getTitle() {
		return "";
	}
	
	public Long getIdCheval() {
		return idCheval;
	}

	public void setIdCheval(Long idCheval) {
		this.idCheval = idCheval;
	}
}
