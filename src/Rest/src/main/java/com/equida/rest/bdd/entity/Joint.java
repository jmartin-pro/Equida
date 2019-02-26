package com.equida.rest.bdd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = Joint.TABLE)
public class Joint {
	public static final String TABLE = "JOINT";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COURRIEL")
	private Courriel courriel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PIECE_JOINTE")
	private PieceJointe pieceJointe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Courriel getCourriel() {
		return courriel;
	}

	public void setCourriel(Courriel courriel) {
		this.courriel = courriel;
	}

	public PieceJointe getPieceJointe() {
		return pieceJointe;
	}

	public void setPieceJointe(PieceJointe pieceJointe) {
		this.pieceJointe = pieceJointe;
	}

}