package com.equida.webapp.web.route.races;

import com.equida.webapp.web.route.IRoute;

public class RacesChevalUpdateRoute implements IRoute {
	public static final String PARAM_ID_RACE = "idRaceCheval";
	public static final String RAW_URI = "/races/{"+PARAM_ID_RACE+"}/update";

	private Long idRaceCheval;
	
	public RacesChevalUpdateRoute(Long idRaceCheval) {
		this.idRaceCheval = idRaceCheval;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_RACE+"}", ""+this.idRaceCheval);
	}

	@Override
	public String getView() {
		return "view/races/form";
	}

	@Override
	public String getTitle() {
		return "Modifier une race";
	}

	public Long getIdRaceCheval() {
		return idRaceCheval;
	}

	public void setIdRace(Long idRaceCheval) {
		this.idRaceCheval = idRaceCheval;
	}
	
}