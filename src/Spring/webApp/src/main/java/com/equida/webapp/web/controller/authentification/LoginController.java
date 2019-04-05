package com.equida.webapp.web.controller.authentification;

import com.equida.webapp.web.controller.AbstractWebController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController extends AbstractWebController {
	
	@GetMapping(value = "/login")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (error != null) {
			addError("Nom d'utilisateur ou mot de passe invalide", modelAndView);
		}

		if (logout != null) {
			addMessage("Vous êtes maintenant déconnecté", modelAndView);
		}
		
		modelAndView.setViewName("login");

		return modelAndView;
	}
}
