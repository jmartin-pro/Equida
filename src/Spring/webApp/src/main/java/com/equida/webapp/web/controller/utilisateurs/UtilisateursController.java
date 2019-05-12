package com.equida.webapp.web.controller.utilisateurs;

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
public class UtilisateursController extends AbstractWebController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private PaysService paysService;
	
	@Autowired
	private RoleService roleService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(UtilisateursRoute.RAW_URI)
	public ModelAndView lister() {
		IRoute route = new UtilisateursRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		List<Utilisateur> utilisateurs = utilisateurService.getAll();
		
		modelAndView.addObject(InputOutputAttribute.LISTE_UTILISATEURS, utilisateurs);
		
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(UtilisateursConsulterRoute.RAW_URI)
	public ModelAndView consulter(@PathVariable(UtilisateursConsulterRoute.PARAM_ID_UTILISATEUR) Long idUtilisateur) throws NotFoundException {
		IRoute route = new UtilisateursConsulterRoute(idUtilisateur);
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		Utilisateur utilisateur = utilisateurService.getById(idUtilisateur);
		modelAndView.addObject(InputOutputAttribute.UTILISATEUR, utilisateur);

		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(UtilisateursAddRoute.RAW_URI)
	public ModelAndView addGet(Model model) {
		IRoute route = new UtilisateursAddRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		modelAndView.addObject(InputOutputAttribute.LISTE_PAYS, paysService.getAll());
		modelAndView.addObject(InputOutputAttribute.LISTE_ROLES, roleService.getAll());
		registerForm(modelAndView, model, UtilisateursAddForm.class, null);
		
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(UtilisateursAddRoute.RAW_URI)
	public RedirectView addPost(@Valid UtilisateursAddForm utilisateursForm, BindingResult bindingResult, RedirectAttributes attributes) {
		if(checkForError(bindingResult, attributes, utilisateursForm)) {
			return new RedirectView(UtilisateursAddRoute.RAW_URI);
		}
		
		try {
			utilisateurService.create(utilisateursForm.getNom(), utilisateursForm.getPrenom(), utilisateursForm.getRue(), utilisateursForm.getCopos(), utilisateursForm.getVille(), utilisateursForm.getIdPays(), utilisateursForm.getMail(), utilisateursForm.getLogin(), utilisateursForm.getMdp(), utilisateursForm.getIdRole());
		} catch(FieldException e) {
			addError(e.getMessage(), attributes);
			attributes.addFlashAttribute(InputOutputAttribute.FORM, utilisateursForm);
			return new RedirectView(UtilisateursAddRoute.RAW_URI);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new RedirectView(UtilisateursRoute.RAW_URI);
	}
	
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	@GetMapping(UtilisateursUpdateRoute.RAW_URI)
	public ModelAndView updateGet(@RequestAttribute(name = InputOutputAttribute.USER, required = false) AuthentificatedUser user, Model model, @PathVariable(UtilisateursUpdateRoute.PARAM_ID_UTILISATEUR) Long idUtilisateur) throws NotFoundException {
		
		IRoute route = new UtilisateursUpdateRoute(idUtilisateur);
		
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
	
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	@PostMapping(UtilisateursUpdateRoute.RAW_URI)
	public RedirectView updatePost(@RequestAttribute(name = InputOutputAttribute.USER, required = false) AuthentificatedUser user, @PathVariable(UtilisateursUpdateRoute.PARAM_ID_UTILISATEUR) Long idUtilisateur, @Valid UtilisateursUpdateForm utilisateursForm, BindingResult bindingResult, RedirectAttributes attributes) throws NotFoundException {		
		if(checkForError(bindingResult, attributes, utilisateursForm)) {
			return new RedirectView(UtilisateursUpdateRoute.RAW_URI);
		}

		try {
			utilisateurService.update(idUtilisateur, utilisateursForm.getNom(), utilisateursForm.getPrenom(), utilisateursForm.getRue(), utilisateursForm.getCopos(), utilisateursForm.getVille(), utilisateursForm.getIdPays(), utilisateursForm.getMail(), utilisateursForm.getLogin(), utilisateursForm.getMdp());
		} catch(FieldException e) {
			addError(e.getMessage(), attributes);
			attributes.addFlashAttribute(InputOutputAttribute.FORM, utilisateursForm);
			return new RedirectView(UtilisateursAddRoute.RAW_URI);
		} catch(NotFoundException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		IRoute route = new UtilisateursConsulterRoute(idUtilisateur);
		return new RedirectView(route.getUri());
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(UtilisateursDeleteRoute.RAW_URI)
	public RedirectView delete(@PathVariable(UtilisateursDeleteRoute.PARAM_ID_UTILISATEUR) Long idUtilisateur) {
		try {
			utilisateurService.delete(idUtilisateur);
		} catch(Exception e) {
			e.printStackTrace();
		} 
			
		return new RedirectView(UtilisateursRoute.RAW_URI);
	}

}
