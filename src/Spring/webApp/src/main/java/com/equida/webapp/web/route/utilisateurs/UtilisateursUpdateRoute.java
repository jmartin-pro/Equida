package com.equida.webapp.web.route.utilisateurs;

import com.equida.webapp.web.route.IRoute;

public class UtilisateursUpdateRoute implements IRoute {
	public static final String PARAM_ID_UTILISATEUR = "idUtilisateur";
	public static final String RAW_URI = "/utilisateurs/{"+PARAM_ID_UTILISATEUR+"}/update";

	private Long idUtilisateur;
	
	public UtilisateursUpdateRoute(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_UTILISATEUR+"}", ""+this.idUtilisateur);
	}

	@Override
	public String getView() {
		return "view/utilisateurs/form";
	}

	@Override
	public String getTitle() {
		return "Modifier un utilisateur";
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
}