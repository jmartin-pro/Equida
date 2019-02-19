package com.equida.bdd.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = DirecteurGeneral.TABLE)
public class DirecteurGeneral extends Utilisateur {
	public static final String TABLE = "DIRECTEUR_GENERAL";	
	
}
