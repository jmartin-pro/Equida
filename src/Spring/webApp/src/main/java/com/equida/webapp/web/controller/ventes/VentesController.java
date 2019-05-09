package com.equida.webapp.web.controller.ventes;

import com.equida.common.authentification.AuthentificatedUser;
import com.equida.common.bdd.entity.CategVente;
import com.equida.common.bdd.entity.Lot;
import com.equida.common.bdd.entity.Vente;
import com.equida.common.exception.NotFoundException;
import com.equida.common.service.CategorieVenteService;
import com.equida.common.service.LieuService;
import com.equida.common.service.LotService;
import com.equida.common.service.VenteService;
import com.equida.common.utils.DateUtils;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.form.ventes.*;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.ventes.*;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class VentesController extends AbstractWebController {
	
	@Autowired
	private LotService lotService;
	
	@Autowired
	private CategorieVenteService categorieVenteService;
	
	@Autowired
	private LieuService lieuService;
	
	@Autowired
	private VenteService venteService;
	
	@GetMapping(VentesRoute.RAW_URI)
	public ModelAndView lister(@RequestParam(required = false, name = VentesRoute.PARAM_ID_CATEG_VENTE)Long idCategVente) {
		IRoute route = new VentesRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		List<CategVente> categVentes = categorieVenteService.getAll();
		List<Vente> ventes = (idCategVente == null) ? venteService.getAll() : venteService.getAllByIdCategVente(idCategVente);
		
		modelAndView.addObject(InputOutputAttribute.LISTE_VENTES, ventes);
		modelAndView.addObject(InputOutputAttribute.LISTE_CATEG_VENTES, categVentes);
		modelAndView.addObject(InputOutputAttribute.CATEG_VENTE, idCategVente);
		
		return modelAndView;
	}
	
	@GetMapping(VentesConsulterRoute.RAW_URI)
	public ModelAndView consulter(Model model, @RequestAttribute(name = "user", required = false) AuthentificatedUser user, @PathVariable(VentesConsulterRoute.PARAM_ID_VENTE) Long idVente) throws NotFoundException {
		IRoute route = new VentesConsulterRoute(idVente);
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		Vente vente = venteService.getById(idVente);
		List<Lot> lots = lotService.getLotsByIdVente(idVente);
		if(user != null) {
			List<Lot> chevauxDispoVente = lotService.getChevauxDispoVenteClient(user.getCompte().getUtilisateur().getId());	
			modelAndView.addObject(InputOutputAttribute.LISTE_CHEVAUX, chevauxDispoVente);
		}
		
		modelAndView.addObject(InputOutputAttribute.VENTE, vente);
		modelAndView.addObject(InputOutputAttribute.IS_INSCRIPTION_OUVERTE, DateUtils.isBetween(vente.getDateDebut(), vente.getDateFin()));
		modelAndView.addObject(InputOutputAttribute.LISTE_LOTS, lots);		
		registerForm(modelAndView, model, VentesAddForm.class, null);

		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(VentesAddRoute.RAW_URI)
	public ModelAndView addGet(Model model) {
		IRoute route = new VentesAddRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		modelAndView.addObject(InputOutputAttribute.LISTE_CATEG_VENTES, categorieVenteService.getAll());
		modelAndView.addObject(InputOutputAttribute.LISTE_LIEUX, lieuService.getAll());
		registerForm(modelAndView, model, VentesAddForm.class, null);
		
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(VentesAddRoute.RAW_URI)
	public RedirectView addPost(@Valid VentesAddForm ventesForm, BindingResult bindingResult, RedirectAttributes attributes) {
		if(checkForError(bindingResult, attributes, ventesForm)) {
			return new RedirectView(VentesAddRoute.RAW_URI);
		}
				
		try {
			venteService.create(ventesForm.getNom(), ventesForm.getIdCategVente(), ventesForm.getIdLieu(), ventesForm.getDateDebut(), ventesForm.getDateFin(), ventesForm.getDateVente());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new RedirectView(VentesRoute.RAW_URI);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(VentesUpdateRoute.RAW_URI)
	public ModelAndView updateGet(Model model, @PathVariable(VentesUpdateRoute.PARAM_ID_VENTE) Long idVente) throws NotFoundException {
		IRoute route = new VentesUpdateRoute(idVente);
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		modelAndView.addObject(InputOutputAttribute.LISTE_CATEG_VENTES, categorieVenteService.getAll());
		modelAndView.addObject(InputOutputAttribute.LISTE_LIEUX, lieuService.getAll());

		try {
			registerForm(modelAndView, model, VentesUpdateForm.class, venteService.getById(idVente));	
		} catch(NotFoundException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(VentesUpdateRoute.RAW_URI)
	public RedirectView updatePost(@PathVariable(VentesUpdateRoute.PARAM_ID_VENTE) Long idVente, @Valid VentesUpdateForm ventesForm, BindingResult bindingResult, RedirectAttributes attributes) throws NotFoundException {		
		if(checkForError(bindingResult, attributes, ventesForm)) {
			return new RedirectView(VentesUpdateRoute.RAW_URI);
		}
	
		try {
			venteService.update(idVente, ventesForm.getNom(), ventesForm.getIdCategVente(), ventesForm.getIdLieu(), ventesForm.getDateDebut(), ventesForm.getDateFin(), ventesForm.getDateVente());
		} catch(NotFoundException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new RedirectView(VentesConsulterRoute.RAW_URI);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(VentesDeleteRoute.RAW_URI)
	public RedirectView delete(@PathVariable(VentesDeleteRoute.PARAM_ID_VENTE) Long idVente) {
		try {
			venteService.delete(idVente);
		} catch(Exception e) {
			e.printStackTrace();
		} 
			
		return new RedirectView(VentesRoute.RAW_URI);
	}

}
