package com.equida.webapp.web.controller.chevaux;

import com.equida.common.authentification.AuthentificatedUser;
import com.equida.common.bdd.entity.Cheval;
import com.equida.common.bdd.entity.Lot;
import com.equida.common.bdd.entity.Participer;
import com.equida.common.exception.NotFoundException;
import com.equida.common.exception.WebException;
import com.equida.common.service.ChevalService;
import com.equida.common.service.CourseService;
import com.equida.common.service.LotService;
import com.equida.common.service.ParticiperService;
import com.equida.common.service.RaceChevalService;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.form.chevaux.ChevauxAddForm;
import com.equida.webapp.web.form.chevaux.ChevauxUpdateForm;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.chevaux.ChevauxAddRoute;
import com.equida.webapp.web.route.chevaux.ChevauxConsulterRoute;
import com.equida.webapp.web.route.chevaux.ChevauxDeleteRoute;
import com.equida.webapp.web.route.chevaux.ChevauxRoute;
import com.equida.webapp.web.route.chevaux.ChevauxUpdateRoute;
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
public class ChevauxController extends AbstractWebController {
	
	@Autowired
	private ChevalService chevalService;
	
	@Autowired
	private LotService lotService;
	
	@Autowired
	private RaceChevalService raceChevalService;
	
	@Autowired
	private ParticiperService participerService;
	
	@Autowired
	private CourseService courseService;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping(ChevauxRoute.RAW_URI)
	public ModelAndView index(@RequestAttribute(InputOutputAttribute.USER) AuthentificatedUser user) throws WebException {
		IRoute route = new ChevauxRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		List<Cheval> chevaux;
		try {
			chevaux = chevalService.getChevauxByClientId(user.getCompte().getId());
		} catch (NotFoundException ex) {
			throw new WebException(ex);
		}
		modelAndView.addObject(InputOutputAttribute.LISTE_CHEVAUX, chevaux);
		
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping(ChevauxAddRoute.RAW_URI)
	public ModelAndView addGet(Model model) {
		IRoute route = new ChevauxAddRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		modelAndView.addObject(InputOutputAttribute.LISTE_RACES, raceChevalService.getAll());
		modelAndView.addObject(InputOutputAttribute.LISTE_COURSES, courseService.getAll());
		registerForm(modelAndView, model, ChevauxAddForm.class, null);
		
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping(ChevauxAddRoute.RAW_URI)
	public RedirectView addPost(@RequestAttribute(InputOutputAttribute.USER) AuthentificatedUser user, @Valid ChevauxAddForm chevauxForm, BindingResult bindingResult, RedirectAttributes attributes) {
		if(checkForError(bindingResult, attributes, chevauxForm)) {
			return new RedirectView(ChevauxAddRoute.RAW_URI);
		}
		
		Long idPere = null;
		Long idMere = null;
		try {
			if(chevauxForm.getSireMere() != null && !chevauxForm.getSireMere().trim().isEmpty())
				idMere = chevalService.getBySire(chevauxForm.getSireMere()).getId();
		} catch(NotFoundException e) {
			addError("Le SIRE de la mère n'existe pas dans notre base de donnée.", attributes);
			attributes.addFlashAttribute(InputOutputAttribute.FORM, chevauxForm);
			return new RedirectView(ChevauxAddRoute.RAW_URI);
		}
		
		try {
			if(chevauxForm.getSirePere()!= null && !chevauxForm.getSirePere().trim().isEmpty())
				idPere = chevalService.getBySire(chevauxForm.getSirePere()).getId();
		} catch(NotFoundException e) {
			addError("Le SIRE du père n'existe pas dans notre base de donnée", attributes);
			attributes.addFlashAttribute(InputOutputAttribute.FORM, chevauxForm);
			return new RedirectView(ChevauxAddRoute.RAW_URI);
		}
		
		try {
			chevalService.create(chevauxForm.getNom(), chevauxForm.getSexe(), chevauxForm.getSire(), chevauxForm.getIdRaceCheval(), idMere, idPere, user.getCompte().getId());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new RedirectView(ChevauxRoute.RAW_URI);
	}
	
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	@GetMapping(ChevauxUpdateRoute.RAW_URI)
	public ModelAndView updateGet(Model model, @PathVariable(ChevauxUpdateRoute.PARAM_ID_CHEVAL) Long idCheval) throws NotFoundException {
		IRoute route = new ChevauxUpdateRoute(idCheval);
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		modelAndView.addObject(InputOutputAttribute.LISTE_RACES, raceChevalService.getAll());
		modelAndView.addObject(InputOutputAttribute.LISTE_COURSES, courseService.getAll());

		try {
			registerForm(modelAndView, model, ChevauxUpdateForm.class, chevalService.getById(idCheval));	
		} catch(NotFoundException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	@PostMapping(ChevauxUpdateRoute.RAW_URI)
	public RedirectView updatePost(@RequestAttribute(name = "user", required = false) AuthentificatedUser user, @PathVariable(ChevauxUpdateRoute.PARAM_ID_CHEVAL) Long idCheval, @Valid ChevauxUpdateForm chevauxForm, BindingResult bindingResult, RedirectAttributes attributes) throws NotFoundException {		
		if(checkForError(bindingResult, attributes, chevauxForm)) {
			return new RedirectView(ChevauxUpdateRoute.RAW_URI);
		}

		Long idPere = null;
		Long idMere = null;
		try {
			if(chevauxForm.getSireMere() != null && !chevauxForm.getSireMere().trim().isEmpty())
				idMere = chevalService.getBySire(chevauxForm.getSireMere()).getId();
		} catch(NotFoundException e) {
			addError("Le SIRE de la mère n'existe pas dans notre base de donnée.", attributes);
			attributes.addFlashAttribute(InputOutputAttribute.FORM, chevauxForm);
			return new RedirectView(ChevauxUpdateRoute.RAW_URI);
		}
		
		try {
			if(chevauxForm.getSirePere() != null && !chevauxForm.getSirePere().trim().isEmpty())
				idPere = chevalService.getBySire(chevauxForm.getSirePere()).getId();
		} catch(NotFoundException e) {
			addError("Le SIRE du père n'existe pas dans notre base de donnée.", attributes);
			attributes.addFlashAttribute(InputOutputAttribute.FORM, chevauxForm);
			return new RedirectView(ChevauxUpdateRoute.RAW_URI);
		}
		
		try {
			chevalService.update(idCheval, chevauxForm.getNom(), chevauxForm.getSexe(), chevauxForm.getSire(), chevauxForm.getIdRaceCheval(), idMere, idPere);
		} catch(NotFoundException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(user != null && user.hasRole("USER") ) {
			return new RedirectView(ChevauxRoute.RAW_URI);		
		}
		else {
			return new RedirectView(ChevauxConsulterRoute.RAW_URI);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping(ChevauxDeleteRoute.RAW_URI)
	public RedirectView delete(@PathVariable(ChevauxDeleteRoute.PARAM_ID_CHEVAL) Long idCheval) {
		try {
			chevalService.delete(idCheval);
		} catch(Exception e) {
			e.printStackTrace();
		} 
			
		return new RedirectView(ChevauxRoute.RAW_URI);
	}
	
	@GetMapping(ChevauxConsulterRoute.RAW_URI)
	public ModelAndView consulter(@PathVariable(ChevauxConsulterRoute.PARAM_ID_CHEVAL) Long idCheval) throws NotFoundException {
		IRoute route = new ChevauxConsulterRoute(idCheval);
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		Cheval cheval = chevalService.getById(idCheval);
		modelAndView.addObject(InputOutputAttribute.CHEVAL, cheval);
		
		List<Participer> participations = participerService.getAllByChevalId(idCheval);
		modelAndView.addObject(InputOutputAttribute.LISTE_PARTICIPER, participations);
		
		try {
			Lot lot = lotService.getLotByIdCheval(idCheval);
			modelAndView.addObject(InputOutputAttribute.LOT, lot);
		} catch(NotFoundException ex) {
			
		}
		
		return modelAndView;
	}
}
