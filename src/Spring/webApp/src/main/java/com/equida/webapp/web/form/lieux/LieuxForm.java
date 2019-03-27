package com.equida.webapp.web.form.lieux;

import com.equida.common.bdd.entity.Lieu;
import com.equida.webapp.web.form.IForm;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public abstract class LieuxForm extends IForm<Lieu> {
	private static final String ERROR_VILLE_NULL = "Le champ ville est obligatoire.";
	private static final String ERROR_VILLE_MAX = "Le champ ville doit faire entre 2 et 50 caractères.";
	
	private static final String ERROR_BOXES_NULL = "Le champ boxes est obligatoire.";
	
	private static final String ERROR_COMMENTAIRE_NULL = "Le champ description est obligatoire.";
	private static final String ERROR_COMMENTAIRE_MAX = "Le champ description doit faire entre 2 et 255 caractères.";
	
	
	@NotNull(message = ERROR_VILLE_NULL)
	@Length(min = 2, max = 50, message = ERROR_VILLE_MAX)
	private String ville;
	
	@NotNull(message = ERROR_BOXES_NULL)
	private Integer nbBoxes;
	
	@NotNull(message = ERROR_COMMENTAIRE_NULL)
	@Length(min = 2, max = 255, message = ERROR_COMMENTAIRE_MAX)
	private String commentaire;

	public LieuxForm(boolean isCreation) {
		super(isCreation);
	}

	@Override
	public void fillFromEntity(Lieu entity) {
		this.ville = entity.getVille();
		this.nbBoxes = entity.getNbBoxes();
		this.commentaire = entity.getCommentaire();
	}
	
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getNbBoxes() {
		return nbBoxes;
	}

	public void setNbBoxes(Integer nbBoxes) {
		this.nbBoxes = nbBoxes;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}