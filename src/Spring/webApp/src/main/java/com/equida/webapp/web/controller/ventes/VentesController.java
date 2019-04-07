package com.equida.webapp.web.controller.ventes;

import com.equida.common.bdd.entity.Vente;
import com.equida.common.service.VenteService;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.ventes.VentesRoute;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VentesController extends AbstractWebController {
	
	@Autowired
	private VenteService venteService;
	
	@GetMapping(VentesRoute.RAW_URI)
	public ModelAndView lister() {
		IRoute route = new VentesRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		List<Vente> ventes = venteService.getAll();
		modelAndView.addObject(InputOutputAttribute.LISTE_VENTES, ventes);
		
		return modelAndView;
	}

}
