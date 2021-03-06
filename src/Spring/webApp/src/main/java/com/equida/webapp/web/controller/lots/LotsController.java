package com.equida.webapp.web.controller.lots;

import com.equida.common.authentification.AuthentificatedUser;
import com.equida.webapp.web.route.lots.LotsDeleteRoute;
import com.equida.webapp.web.route.lots.LotsValiderRoute;
import org.springframework.web.bind.annotation.PathVariable;
import com.equida.common.bdd.entity.Lot;
import com.equida.common.service.LotService;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.form.lot.LotsAddForm;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.lots.LotsAddRoute;
import com.equida.webapp.web.route.lots.LotsAValiderRoute;
import com.equida.webapp.web.route.lots.LotsRoute;
import com.equida.webapp.web.route.ventes.VentesConsulterRoute;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LotsController extends AbstractWebController {
	
	@Autowired
	private LotService lotService;
	
	@GetMapping(LotsRoute.RAW_URI)
	public ModelAndView index(@RequestAttribute(name = "user", required = false) AuthentificatedUser user) {
		IRoute route = new LotsRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());

		List<Lot> lots = lotService.getAllEnVente();
		modelAndView.addObject(InputOutputAttribute.LISTE_LOTS, lots);
		
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(LotsAValiderRoute.RAW_URI)
	public ModelAndView listerLotsAValider(@RequestAttribute(name = "user", required = false) AuthentificatedUser user) {
		IRoute route = new LotsAValiderRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());

		List<Lot> lots = lotService.getAllAValider();
		modelAndView.addObject(InputOutputAttribute.LISTE_LOTS, lots);
		
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(LotsValiderRoute.RAW_URI)
	public RedirectView valider(@PathVariable(LotsValiderRoute.PARAM_ID_LOT) Long idLot) {
		try {
			lotService.validerLot(idLot);
		} catch(Exception e) {
			e.printStackTrace();
		} 
			
		return new RedirectView(LotsAValiderRoute.RAW_URI);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(LotsDeleteRoute.RAW_URI)
	public RedirectView delete(@PathVariable(LotsDeleteRoute.PARAM_ID_LOT) Long idLot) {
		try {
			lotService.deleteLot(idLot);
		} catch(Exception e) {
			e.printStackTrace();
		} 
			
		return new RedirectView(LotsAValiderRoute.RAW_URI);
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping(LotsAddRoute.RAW_URI)
	public RedirectView addPost(@Valid LotsAddForm lotForm, BindingResult bindingResult, RedirectAttributes attributes) {
		IRoute route = new LotsRoute();
		
		if(checkForError(bindingResult, attributes, lotForm)) {
			return new RedirectView(route.getUri());
		}

		try {
			lotService.create(lotForm.getIdVente(), lotForm.getIdCheval(), lotForm.getPrix());
			addMessage("Le cheval a bien été ajouté à la vente", attributes);
		} catch(Exception e) {
			e.printStackTrace();
			addError("Une erreur est survenue...", attributes);
		}
		
		return new RedirectView(route.getUri());
	}
}
