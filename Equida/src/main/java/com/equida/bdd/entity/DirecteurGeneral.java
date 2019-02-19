package com.equida.bdd.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = DirecteurGeneral.TABLE)
public class DirecteurGeneral {
	public static final String TABLE = "DIRECTEUR_GENERAL";
	
	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_UTILISATEUR")
	private Utilisateur utilisateur;

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
