package com.equida.webapp.web.controller.monProfil;

import com.equida.common.authentification.AuthentificatedUser;
import com.equida.common.bdd.entity.Utilisateur;
import com.equida.common.exception.FieldException;
import com.equida.common.exception.NotFoundException;
import com.equida.common.service.PaysService;
import com.equida.common.service.RoleService;
import com.equida.common.service.UtilisateurService;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.form.utilisateurs.UtilisateursAddForm;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.utilisateurs.UtilisateursAddRoute;
import com.equida.webapp.web.route.utilisateurs.UtilisateursConsulterRoute;
import com.equida.webapp.web.route.utilisateurs.UtilisateursDeleteRoute;
import com.equida.webapp.web.route.utilisateurs.UtilisateursRoute;
import com.equida.webapp.web.form.utilisateurs.UtilisateursUpdateForm;
import com.equida.webapp.web.route.monProfil.MonProfilRoute;
import com.equida.webapp.web.route.utilisateurs.UtilisateursUpdateRoute;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MonProfilController extends AbstractWebController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private PaysService paysService;
	
	@Autowired
	private RoleService roleService;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping(MonProfilRoute.RAW_URI)
	public ModelAndView updateGet(@RequestAttribute(name = InputOutputAttribute.USER, required = false) AuthentificatedUser user, Model model) throws NotFoundException {
		Long idUtilisateur = user.getCompte().getUtilisateur().getId();
		
		IRoute route = new MonProfilRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		modelAndView.addObject(InputOutputAttribute.LISTE_PAYS, paysService.getAll());
		modelAndView.addObject(InputOutputAttribute.LISTE_ROLES, roleService.getAll());

		try {
			registerForm(modelAndView, model, UtilisateursUpdateForm.class, utilisateurService.getById(idUtilisateur));	
		} catch(NotFoundException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping(MonProfilRoute.RAW_URI)
	public RedirectView updatePost(@RequestAttribute(name = InputOutputAttribute.USER, required = false) AuthentificatedUser user, @Valid UtilisateursUpdateForm utilisateursForm, BindingResult bindingResult, RedirectAttributes attributes) throws NotFoundException {		
		Long idUtilisateur = user.getCompte().getUtilisateur().getId();
		
		if(checkForError(bindingResult, attributes, utilisateursForm)) {
			return new RedirectView(MonProfilRoute.RAW_URI);
		}

		try {
			utilisateurService.update(idUtilisateur, utilisateursForm.getNom(), utilisateursForm.getPrenom(), utilisateursForm.getRue(), utilisateursForm.getCopos(), utilisateursForm.getVille(), utilisateursForm.getIdPays(), utilisateursForm.getMail(), utilisateursForm.getLogin(), utilisateursForm.getMdp());
		} catch(FieldException e) {
			addError(e.getMessage(), attributes);
			attributes.addFlashAttribute(InputOutputAttribute.FORM, utilisateursForm);
			return new RedirectView(MonProfilRoute.RAW_URI);
		} catch(NotFoundException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		IRoute route = new MonProfilRoute();
		addMessage("Votre profil a bien été enregistré, vous pouvez changer de page.", attributes);
		return new RedirectView(route.getUri());
	}
	
}
