package com.equida.webapp.web.controller.pays;

import com.equida.common.bdd.entity.Pays;
import com.equida.common.exception.NotFoundException;
import com.equida.common.service.PaysService;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.form.pays.PaysAddForm;
import com.equida.webapp.web.form.pays.PaysUpdateForm;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.pays.PaysAddRoute;
import com.equida.webapp.web.route.pays.PaysDeleteRoute;
import com.equida.webapp.web.route.pays.PaysRoute;
import com.equida.webapp.web.route.pays.PaysUpdateRoute;
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
public class PaysController extends AbstractWebController {
	
	@Autowired
	private PaysService paysService;
	
	@GetMapping(PaysRoute.RAW_URI)
	public ModelAndView index() {
		IRoute route = new PaysRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		List<Pays> pays = paysService.getAll();
		modelAndView.addObject(InputOutputAttribute.LISTE_PAYS, pays);
		
		return modelAndView;
	}
	
	@GetMapping(PaysAddRoute.RAW_URI)
	public ModelAndView addGet(Model model) {
		IRoute route = new PaysAddRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		registerForm(modelAndView, model, PaysAddForm.class, null);
		
		return modelAndView;
	}
	
	@PostMapping(PaysAddRoute.RAW_URI)
	public RedirectView addPost(@Valid PaysAddForm paysForm, BindingResult bindingResult, RedirectAttributes attributes) {
		if(checkForError(bindingResult, attributes, paysForm)) {
			return new RedirectView(PaysAddRoute.RAW_URI);
		}

		try {
			paysService.create(paysForm.getLibelle());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new RedirectView(PaysRoute.RAW_URI);
	}
	
	@GetMapping(PaysUpdateRoute.RAW_URI)
	public ModelAndView updateGet(Model model, @PathVariable(PaysUpdateRoute.PARAM_ID_PAYS) Long idPays) throws NotFoundException {
		IRoute route = new PaysUpdateRoute(idPays);
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		try {
			registerForm(modelAndView, model, PaysUpdateForm.class, paysService.getById(idPays));	
		} catch(NotFoundException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	@PostMapping(PaysUpdateRoute.RAW_URI)
	public RedirectView updatePost(@PathVariable(PaysUpdateRoute.PARAM_ID_PAYS) Long idPays, @Valid PaysUpdateForm paysForm, BindingResult bindingResult, RedirectAttributes attributes) throws NotFoundException {		
		if(checkForError(bindingResult, attributes, paysForm)) {
			return new RedirectView(PaysUpdateRoute.RAW_URI);
		}

		try {
			paysService.updatePays(idPays, paysForm.getLibelle());
		} catch(NotFoundException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new RedirectView(PaysRoute.RAW_URI);
	}
	
	@GetMapping(PaysDeleteRoute.RAW_URI)
	public RedirectView delete(@PathVariable(PaysDeleteRoute.PARAM_ID_PAYS) Long idPays) {
		try {
			paysService.deletePays(idPays);
		} catch(Exception e) {
			e.printStackTrace();
		} 
			
		return new RedirectView(PaysRoute.RAW_URI);
	}
}
