package com.equida.webapp.web.controller.lieux;

import com.equida.common.bdd.entity.Lieu;
import com.equida.common.exception.NotFoudException;
import com.equida.common.service.LieuService;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.form.lieux.LieuxAddForm;
import com.equida.webapp.web.form.lieux.LieuxUpdateForm;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.lieux.LieuxAddRoute;
import com.equida.webapp.web.route.lieux.LieuxDeleteRoute;
import com.equida.webapp.web.route.lieux.LieuxRoute;
import com.equida.webapp.web.route.lieux.LieuxUpdateRoute;
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
public class LieuxController extends AbstractWebController {
	
	@Autowired
	private LieuService lieuService;
	
	@GetMapping(LieuxRoute.RAW_URI)
	public ModelAndView index() {
		IRoute route = new LieuxRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		List<Lieu> lieu = lieuService.getAll();
		modelAndView.addObject(InputOutputAttribute.LISTE_LIEUX, lieu);
		
		return modelAndView;
	}
	
	@GetMapping(LieuxAddRoute.RAW_URI)
	public ModelAndView addGet(Model model) {
		IRoute route = new LieuxAddRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		registerForm(modelAndView, model, LieuxAddForm.class, null);
		
		return modelAndView;
	}
	
	@PostMapping(LieuxAddRoute.RAW_URI)
	public RedirectView addPost(@Valid LieuxAddForm lieuxForm, BindingResult bindingResult, RedirectAttributes attributes) {
		if(checkForError(bindingResult, attributes, lieuxForm)) {
			return new RedirectView(LieuxAddRoute.RAW_URI);
		}

		try {
			lieuService.create(lieuxForm.getVille(), lieuxForm.getNbBoxes(), lieuxForm.getCommentaire());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new RedirectView(LieuxRoute.RAW_URI);
	}
	
	@GetMapping(LieuxUpdateRoute.RAW_URI)
	public ModelAndView updateGet(Model model, @PathVariable(LieuxUpdateRoute.PARAM_ID_LIEU) Long idLieu) {
		IRoute route = new LieuxUpdateRoute(idLieu);
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		try {
			registerForm(modelAndView, model, LieuxUpdateForm.class, lieuService.getById(idLieu));	
		} catch(Exception e) {
			e.printStackTrace();
			throw new NotFoudException();
		}
		
		return modelAndView;
	}
	
	@PostMapping(LieuxUpdateRoute.RAW_URI)
	public RedirectView updatePost(@PathVariable(LieuxUpdateRoute.PARAM_ID_LIEU) Long idLieu, @Valid LieuxUpdateForm lieuxForm, BindingResult bindingResult, RedirectAttributes attributes) {		
		if(checkForError(bindingResult, attributes, lieuxForm)) {
			return new RedirectView(LieuxUpdateRoute.RAW_URI);
		}

		try {
			lieuService.updateLieu(idLieu, lieuxForm.getVille(), lieuxForm.getNbBoxes(), lieuxForm.getCommentaire());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new RedirectView(LieuxRoute.RAW_URI);
	}
	
	@GetMapping(LieuxDeleteRoute.RAW_URI)
	public RedirectView delete(@PathVariable(LieuxDeleteRoute.PARAM_ID_LIEU) Long idLieu) {
		try {
			lieuService.deleteLieu(idLieu);
		} catch(Exception e) {
			e.printStackTrace();
		} 
			
		return new RedirectView(LieuxRoute.RAW_URI);
	}
}