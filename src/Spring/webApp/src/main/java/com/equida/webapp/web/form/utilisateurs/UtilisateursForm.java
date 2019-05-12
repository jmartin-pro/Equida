package com.equida.webapp.web.form.utilisateurs;

import com.equida.webapp.web.form.utilisateurs.*;
import com.equida.common.bdd.entity.Compte;
import com.equida.common.bdd.entity.Utilisateur;
import com.equida.webapp.web.form.IForm;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public abstract class UtilisateursForm extends IForm<Utilisateur> {
	private static final String ERROR_NOM_NULL = "Le champ nom est obligatoire.";
	private static final String ERROR_NOM_MAX = "Le champ nom doit faire entre 2 et 40 caractères.";
	
	private static final String ERROR_PRENOM_NULL = "Le champ prenom est obligatoire.";
	private static final String ERROR_PRENOM_MAX = "Le champ prenom doit faire entre 2 et 40 caractères.";
	
	private static final String ERROR_RUE_NULL = "Le champ rue est obligatoire.";
	private static final String ERROR_RUE_MAX = "Le champ rue doit faire entre 1 et 60 caractères.";
	
	private static final String ERROR_COPOS_NULL = "Le champ code postal est obligatoire.";
	private static final String ERROR_COPOS_MAX = "Le champ code postal doit faire entre 1 et 5 caractères.";
	
	private static final String ERROR_VILLE_NULL = "Le champ ville est obligatoire.";
	private static final String ERROR_VILLE_MAX = "Le champ ville doit faire entre 2 et 40 caractères.";
	
	private static final String ERROR_MAIL_NULL = "Le champ mail est obligatoire.";
	private static final String ERROR_MAIL_MAX = "Le champ mail doit faire entre 2 et 60 caractères.";
	
	private static final String ERROR_PAYS_NULL = "Le pays est obligatoire.";
	
	private static final String ERROR_LOGIN_NULL = "Le champ login est obligatoire.";
	private static final String ERROR_LOGIN_MAX = "Le champ login doit faire entre 2 et 32 caractères.";
	
	private static final String ERROR_MDP_NULL = "Le champ mdp est obligatoire.";
	private static final String ERROR_MDP_MAX = "Le champ mdp doit faire entre 2 et 64 caractères.";
	
	private static final String ERROR_ROLE_NULL = "Le rôle est obligatoire.";
	
	//Gestion Utilisateur
	@NotNull(message = ERROR_NOM_NULL)
	@Length(min = 2, max = 40, message = ERROR_NOM_MAX)
	private String nom;
	
	@NotNull(message = ERROR_PRENOM_NULL)
	@Length(min = 2, max = 40, message = ERROR_PRENOM_MAX)
	private String prenom;

	@NotNull(message = ERROR_RUE_NULL)
	@Length(min = 1, max = 60, message = ERROR_RUE_MAX)
	private String rue;
	
	@NotNull(message = ERROR_COPOS_NULL)
	@Length(min = 1, max = 5, message = ERROR_COPOS_MAX)
	private String copos;
	
	@NotNull(message = ERROR_VILLE_NULL)
	@Length(min = 2, max = 40, message = ERROR_VILLE_MAX)
	private String ville;
	
	@NotNull(message = ERROR_MAIL_NULL)
	@Length(min = 2, max = 60, message = ERROR_MAIL_MAX)
	private String mail;
	
	@NotNull(message = ERROR_PAYS_NULL)
	private Long idPays;
	
	//Gestion Compte
	@NotNull(message = ERROR_LOGIN_NULL)
	@Length(min = 2, max = 32, message = ERROR_LOGIN_MAX)
	private String login;
	
	@NotNull(message = ERROR_MDP_NULL)
	@Length(min = 2, max = 64, message = ERROR_MDP_MAX)
	private String mdp;
		
	@NotNull(message = ERROR_ROLE_NULL)
	private Long idRole;
	
	public UtilisateursForm(boolean isCreation) {
		super(isCreation);
	}

	@Override
	public void fillFromEntity(Utilisateur userEntity) {
		//Gestion Utilisateur
		this.nom = userEntity.getNom();
		this.prenom = userEntity.getPrenom();
		this.rue = userEntity.getRue();
		this.copos = userEntity.getCopos();
		this.ville = userEntity.getVille();
		this.mail = userEntity.getMail();
		if(userEntity.getPays()!= null)
			this.idPays = userEntity.getPays().getId();
		
		//Gestion Compte
		this.login = userEntity.getCompte().getLogin();
		this.mdp = userEntity.getCompte().getMdp();
		if(userEntity.getCompte().getRole()!= null)
			this.idRole = userEntity.getCompte().getRole().getId();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCopos() {
		return copos;
	}

	public void setCopos(String copos) {
		this.copos = copos;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getIdPays() {
		return idPays;
	}

	public void setIdPays(Long idPays) {
		this.idPays = idPays;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
}