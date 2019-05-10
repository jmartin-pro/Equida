package com.equida.webapp.web.route.ventes;

import com.equida.webapp.web.route.ventes.*;
import com.equida.webapp.web.route.IRoute;

public class VentesUpdateRoute implements IRoute {
	public static final String PARAM_ID_VENTE = "idVente";
	public static final String RAW_URI = "/ventes/{"+PARAM_ID_VENTE+"}/update";

	private Long idVente;
	
	public VentesUpdateRoute(Long idVente) {
		this.idVente = idVente;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_VENTE+"}", ""+this.idVente);
	}

	@Override
	public String getView() {
		return "view/ventes/form";
	}

	@Override
	public String getTitle() {
		return "Modifier une vente";
	}

	public Long getIdVente() {
		return idVente;
	}

	public void setIdVente(Long idVente) {
		this.idVente = idVente;
	}
	
}