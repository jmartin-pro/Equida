package com.equida.webapp.web.controller.lots;

import com.equida.common.bdd.entity.Lot;
import com.equida.common.service.LotService;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.lots.LotsRoute;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LotsController extends AbstractWebController {
	
	@Autowired
	private LotService lotService;
	
	@GetMapping(LotsRoute.RAW_URI)
	public ModelAndView index() {
		IRoute route = new LotsRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		List<Lot> lots = lotService.getAllValide();
		modelAndView.addObject(InputOutputAttribute.LISTE_LOTS, lots);
		
		return modelAndView;
	}
}