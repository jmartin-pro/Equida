package com.equida.webapp.web.route.ventes;

import com.equida.webapp.web.route.IRoute;

public class VentesConsulterRoute implements IRoute {
	
	public static final String PARAM_ID_VENTE = "idVente";
	public static final String RAW_URI = "/ventes/{"+PARAM_ID_VENTE+"}";
	
	private Long idVente;

	public VentesConsulterRoute(Long idVente) {
		this.idVente = idVente;
	}

	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_VENTE+"}", ""+idVente);
	}

	@Override
	public String getView() {
		return "view/ventes/consulter";
	}

	@Override
	public String getTitle() {
		return "";
	}
	
	public Long getIdVente() {
		return idVente;
	}

	public void setIdVente(Long idVente) {
		this.idVente = idVente;
	}
}
