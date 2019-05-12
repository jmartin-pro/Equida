package com.equida.webapp.web.route.utilisateurs;

import com.equida.webapp.web.route.IRoute;

public class UtilisateursConsulterRoute implements IRoute {
	
	public static final String PARAM_ID_UTILISATEUR = "idUtilisateur";
	public static final String RAW_URI = "/utilisateurs/{"+PARAM_ID_UTILISATEUR+"}";
	
	private Long idUtilisateur;

	public UtilisateursConsulterRoute(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_UTILISATEUR+"}", ""+idUtilisateur);
	}

	@Override
	public String getView() {
		return "view/utilisateurs/consulter";
	}

	@Override
	public String getTitle() {
		return "";
	}
	
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
}
