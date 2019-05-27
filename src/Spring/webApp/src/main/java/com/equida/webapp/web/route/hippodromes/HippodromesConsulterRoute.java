package com.equida.webapp.web.route.hippodromes;

import com.equida.webapp.web.route.IRoute;

public class HippodromesConsulterRoute implements IRoute {
	
	public static final String PARAM_ID_HIPPODROME= "idHippodrome";
	public static final String RAW_URI = "/hippodromes/{"+PARAM_ID_HIPPODROME+"}";
	
	private Long idHippodrome;

	public HippodromesConsulterRoute(Long idHippodrome) {
		this.idHippodrome = idHippodrome;
	}
			
			
	@Override
	public String getUri() {
		return RAW_URI.replaceAll("{"+PARAM_ID_HIPPODROME+"}", ""+idHippodrome);
	}

	@Override
	public String getView() {
		return "view/hippodromes/consulter";
	}

	@Override
	public String getTitle() {
		return "Consultation hippodrome";
	}
	
}
