package com.equida.webapp.web.route.races;

import com.equida.webapp.web.route.IRoute;

public class RacesChevalDeleteRoute implements IRoute {
	
	public static final String PARAM_ID_RACE = "idRace";
	public static final String RAW_URI = "/races/{"+PARAM_ID_RACE+"}/delete";

	private Long idRace;
	
	public RacesChevalDeleteRoute(Long idRace) {
		this.idRace = idRace;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_RACE+"}", ""+this.idRace);
	}

	@Override
	public String getView() {
		return null;
	}

	@Override
	public String getTitle() {
		return null;
	}

	public Long getIdRace() {
		return idRace;
	}

	public void setIdRace(Long idRace) {
		this.idRace = idRace;
	}
}
