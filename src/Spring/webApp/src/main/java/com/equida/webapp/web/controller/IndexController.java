package com.equida.webapp.web.controller;

import com.equida.common.service.VenteService;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.IndexRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends AbstractWebController {
	
	@Autowired
	private VenteService venteService;
	
	@GetMapping(IndexRoute.RAW_URI)
	public ModelAndView index() {
		IRoute route = new IndexRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		modelAndView.addObject(InputOutputAttribute.LISTE_VENTES, venteService.get5Recents());
		
		return modelAndView;
	}
}
