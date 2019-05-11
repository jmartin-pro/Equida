package com.equida.webapp.web.controller.encheres;

import com.equida.common.authentification.AuthentificatedUser;
import com.equida.common.bdd.entity.Cheval;
import com.equida.common.bdd.entity.Enchere;
import com.equida.webapp.web.route.lots.LotsDeleteRoute;
import com.equida.webapp.web.route.lots.LotsValiderRoute;
import org.springframework.web.bind.annotation.PathVariable;
import com.equida.common.bdd.entity.Lot;
import com.equida.common.service.ChevalService;
import com.equida.common.service.ClientService;
import com.equida.common.service.EnchereService;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.form.chevaux.ChevauxAddForm;
import com.equida.webapp.web.form.encheres.EncheresAddForm;
import com.equida.webapp.web.form.lot.LotsAddForm;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.chevaux.ChevauxAddRoute;
import com.equida.webapp.web.route.chevaux.ChevauxConsulterRoute;
import com.equida.webapp.web.route.encheres.EncheresAddRoute;
import com.equida.webapp.web.route.encheres.EncheresDeleteRoute;
import com.equida.webapp.web.route.encheres.EncheresRoute;
import com.equida.webapp.web.route.lots.LotsAddRoute;
import com.equida.webapp.web.route.lots.LotsAValiderRoute;
import com.equida.webapp.web.route.lots.LotsRoute;
import com.equida.webapp.web.route.ventes.VentesConsulterRoute;
import com.equida.webapp.web.route.ventes.VentesRoute;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class EncheresController extends AbstractWebController {
	
	@Autowired
	private EnchereService enchereService;
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping(EncheresRoute.RAW_URI)
	public ModelAndView index(@RequestAttribute(name = "user", required = false) AuthentificatedUser user, @PathVariable(EncheresRoute.PARAM_ID_LOT) Long idLot) {
		IRoute route = new EncheresRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());

		List<Enchere> encheres = enchereService.getAllByIdLot(idLot);
		modelAndView.addObject(InputOutputAttribute.LISTE_ENCHERES, encheres);
		modelAndView.addObject(InputOutputAttribute.LISTE_CLIENTS, clientService.getAll());
		
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(EncheresDeleteRoute.RAW_URI)
	public RedirectView delete(@PathVariable(EncheresDeleteRoute.PARAM_ID_LOT) Long idLot, @PathVariable(EncheresDeleteRoute.PARAM_ID_ENCHERE) Long idEnchere) {
		IRoute route = new EncheresAddRoute(idLot);
		
		try {
			enchereService.delete(idEnchere);
		} catch(Exception e) {
			e.printStackTrace();
		} 
			
		return new RedirectView(route.getUri());
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(EncheresAddRoute.RAW_URI)
	public ModelAndView addGet(Model model, @PathVariable(EncheresAddRoute.PARAM_ID_LOT) Long idLot) {
		IRoute route = new EncheresAddRoute(idLot);
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		modelAndView.addObject(InputOutputAttribute.LISTE_CLIENTS, clientService.getAll());
		modelAndView.addObject(InputOutputAttribute.LISTE_ENCHERES, enchereService.getAllByIdLot(idLot));
		registerForm(modelAndView, model, EncheresAddForm.class, null);
		
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(EncheresAddRoute.RAW_URI)
	public RedirectView addPost(@Valid EncheresAddForm enchereForm, @PathVariable(EncheresAddRoute.PARAM_ID_LOT) Long idLot, BindingResult bindingResult, RedirectAttributes attributes) {
		IRoute route = new EncheresAddRoute(idLot);
		
		if(checkForError(bindingResult, attributes, enchereForm)) {
			return new RedirectView(route.getUri());
		}

		try {
			enchereService.create(idLot, enchereForm.getIdClient(), enchereForm.getMontant());
			addMessage("L'enchère a bien été ajoutée", attributes);
		} catch(Exception e) {
			e.printStackTrace();
			addError("Une erreur est survenue...", attributes);
		}
		
		return new RedirectView(route.getUri());
	}
}
