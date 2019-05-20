package com.equida.rest.api.route.chevaux;

import com.equida.rest.api.route.IRoute;


public class ChevalDetailsCourseApiRoute implements IRoute {

	public static final String PARAM_ID_CHEVAL = "idCheval";
	public static final String RAW_URI = ChevauxApiRoute.RAW_URI+"/{"+PARAM_ID_CHEVAL+"}/courses";
	
	private Long id = 0L;
	
	public ChevalDetailsCourseApiRoute(Long id) {
		this.id = id;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_CHEVAL+"}", ""+id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
