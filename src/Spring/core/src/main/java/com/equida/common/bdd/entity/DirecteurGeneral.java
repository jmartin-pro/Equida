package com.equida.common.bdd.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = DirecteurGeneral.TABLE)
@PrimaryKeyJoinColumn(name = "ID_UTILISATEUR")
public class DirecteurGeneral extends Utilisateur {
	public static final String TABLE = "DIRECTEUR_GENERAL";	
	
}
