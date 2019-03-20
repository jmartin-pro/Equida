package com.equida.webapp.web.controller.pays;

import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.pays.PaysRoute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaysController extends AbstractWebController {
	
	@GetMapping(PaysRoute.RAW_URI)
	public ModelAndView index() {
		IRoute route = new PaysRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		return modelAndView;
	}
}
