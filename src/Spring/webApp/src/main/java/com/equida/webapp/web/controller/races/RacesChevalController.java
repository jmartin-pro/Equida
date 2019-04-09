package com.equida.webapp.web.controller.races;

import com.equida.common.bdd.entity.RaceCheval;
import com.equida.common.exception.NotFoundException;
import com.equida.common.service.RaceChevalService;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.form.races.RacesChevalAddForm;
import com.equida.webapp.web.form.races.RacesChevalUpdateForm;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.races.RacesChevalAddRoute;
import com.equida.webapp.web.route.races.RacesChevalDeleteRoute;
import com.equida.webapp.web.route.races.RacesChevalRoute;
import com.equida.webapp.web.route.races.RacesChevalUpdateRoute;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RacesChevalController extends AbstractWebController {
	
	@Autowired
	private RaceChevalService raceChevalService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(RacesChevalRoute.RAW_URI)
	public ModelAndView index() {
		IRoute route = new RacesChevalRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		List<RaceCheval> raceCheval = raceChevalService.getAll();
		modelAndView.addObject(InputOutputAttribute.LISTE_RACES, raceCheval);
		
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(RacesChevalAddRoute.RAW_URI)
	public ModelAndView addGet(Model model) {
		IRoute route = new RacesChevalAddRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		registerForm(modelAndView, model, RacesChevalAddForm.class, null);
		
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(RacesChevalAddRoute.RAW_URI)
	public RedirectView addPost(@Valid RacesChevalAddForm raceChevalForm, BindingResult bindingResult, RedirectAttributes attributes) {
		if(checkForError(bindingResult, attributes, raceChevalForm)) {
			return new RedirectView(RacesChevalAddRoute.RAW_URI);
		}

		try {
			raceChevalService.create(raceChevalForm.getLibelle(), raceChevalForm.getDescription());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new RedirectView(RacesChevalRoute.RAW_URI);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(RacesChevalUpdateRoute.RAW_URI)
	public ModelAndView updateGet(Model model, @PathVariable(RacesChevalUpdateRoute.PARAM_ID_RACE) Long idRaceCheval) throws NotFoundException {
		IRoute route = new RacesChevalUpdateRoute(idRaceCheval);
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		try {
			registerForm(modelAndView, model, RacesChevalUpdateForm.class, raceChevalService.getById(idRaceCheval));	
		} catch(NotFoundException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(RacesChevalUpdateRoute.RAW_URI)
	public RedirectView updatePost(@PathVariable(RacesChevalUpdateRoute.PARAM_ID_RACE) Long idRaceCheval, @Valid RacesChevalUpdateForm raceChevalForm, BindingResult bindingResult, RedirectAttributes attributes) throws NotFoundException {		
		if(checkForError(bindingResult, attributes, raceChevalForm)) {
			return new RedirectView(RacesChevalUpdateRoute.RAW_URI);
		}

		try {
			raceChevalService.updateRaceCheval(idRaceCheval, raceChevalForm.getLibelle(), raceChevalForm.getDescription());
		} catch(NotFoundException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new RedirectView(RacesChevalRoute.RAW_URI);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(RacesChevalDeleteRoute.RAW_URI)
	public RedirectView delete(@PathVariable(RacesChevalDeleteRoute.PARAM_ID_RACE) Long idRaceCheval) {
		try {
			raceChevalService.deleteRaceCheval(idRaceCheval);
		} catch(Exception e) {
			e.printStackTrace();
		} 
			
		return new RedirectView(RacesChevalRoute.RAW_URI);
	}
}
