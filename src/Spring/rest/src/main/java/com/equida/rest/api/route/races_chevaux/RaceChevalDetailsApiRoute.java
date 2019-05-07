package com.equida.rest.api.route.races_chevaux;

import com.equida.rest.api.route.IRoute;


public class RaceChevalDetailsApiRoute implements IRoute {

	public static final String PARAM_ID_RACE_CHEVAL = "idRaceCheval";
	public static final String RAW_URI = RacesChevauxApiRoute.RAW_URI+"/{"+PARAM_ID_RACE_CHEVAL+"}";
	
	private Long id = 0L;
	
	public RaceChevalDetailsApiRoute(Long id) {
		this.id = id;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_RACE_CHEVAL+"}", ""+id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
