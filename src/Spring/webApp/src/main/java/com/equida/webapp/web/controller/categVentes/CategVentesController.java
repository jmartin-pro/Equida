package com.equida.webapp.web.controller.categVentes;

import com.equida.common.bdd.entity.CategVente;
import com.equida.common.exception.NotFoundException;
import com.equida.common.service.CategorieVenteService;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.form.categVentes.CategVentesAddForm;
import com.equida.webapp.web.form.categVentes.CategVentesUpdateForm;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.categVentes.CategVentesAddRoute;
import com.equida.webapp.web.route.categVentes.CategVentesDeleteRoute;
import com.equida.webapp.web.route.categVentes.CategVentesRoute;
import com.equida.webapp.web.route.categVentes.CategVentesUpdateRoute;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CategVentesController extends AbstractWebController {
	
	@Autowired
	private CategorieVenteService categVenteService;
	
	@GetMapping(CategVentesRoute.RAW_URI)
	public ModelAndView index() {
		IRoute route = new CategVentesRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		List<CategVente> categVente = categVenteService.getAll();
		modelAndView.addObject(InputOutputAttribute.LISTE_CATEG_VENTES, categVente);
		
		return modelAndView;
	}
	
	@GetMapping(CategVentesAddRoute.RAW_URI)
	public ModelAndView addGet(Model model) {
		IRoute route = new CategVentesAddRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		registerForm(modelAndView, model, CategVentesAddForm.class, null);
		
		return modelAndView;
	}
	
	@PostMapping(CategVentesAddRoute.RAW_URI)
	public RedirectView addPost(@Valid CategVentesAddForm categVentesForm, BindingResult bindingResult, RedirectAttributes attributes) {
		if(checkForError(bindingResult, attributes, categVentesForm)) {
			return new RedirectView(CategVentesAddRoute.RAW_URI);
		}

		try {
			categVenteService.create(categVentesForm.getLibelle());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new RedirectView(CategVentesRoute.RAW_URI);
	}
	
	@GetMapping(CategVentesUpdateRoute.RAW_URI)
	public ModelAndView updateGet(Model model, @PathVariable(CategVentesUpdateRoute.PARAM_ID_CATEG_VENTES) Long idCategVentes) throws NotFoundException {
		IRoute route = new CategVentesUpdateRoute(idCategVentes);
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		try {
			registerForm(modelAndView, model, CategVentesUpdateForm.class, categVenteService.getById(idCategVentes));	
		} catch(NotFoundException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	@PostMapping(CategVentesUpdateRoute.RAW_URI)
	public RedirectView updatePost(@PathVariable(CategVentesUpdateRoute.PARAM_ID_CATEG_VENTES) Long idCategVentes, @Valid CategVentesUpdateForm categVentesForm, BindingResult bindingResult, RedirectAttributes attributes) throws NotFoundException {		
		if(checkForError(bindingResult, attributes, categVentesForm)) {
			return new RedirectView(CategVentesUpdateRoute.RAW_URI);
		}

		try {
			categVenteService.updateCategVente(idCategVentes, categVentesForm.getLibelle());
		} catch(NotFoundException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new RedirectView(CategVentesRoute.RAW_URI);
	}
	
	@GetMapping(CategVentesDeleteRoute.RAW_URI)
	public RedirectView delete(@PathVariable(CategVentesDeleteRoute.PARAM_ID_CATEG_VENTES) Long idCategVentes) {
		try {
			categVenteService.deleteCategVente(idCategVentes);
		} catch(Exception e) {
			e.printStackTrace();
		} 
			
		return new RedirectView(CategVentesRoute.RAW_URI);
	}
}
