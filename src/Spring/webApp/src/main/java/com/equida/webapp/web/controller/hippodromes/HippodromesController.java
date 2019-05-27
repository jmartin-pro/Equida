package com.equida.webapp.web.controller.hippodromes;

import com.equida.common.bdd.entity.Hippodrome;
import com.equida.common.exception.NotFoundException;
import com.equida.common.service.HippodromeService;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.hippodromes.HippodromesConsulterRoute;
import com.equida.webapp.web.route.lieux.LieuxRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HippodromesController extends AbstractWebController {
	
	@Autowired
	private HippodromeService hippodromeService;
	
	@GetMapping(HippodromesConsulterRoute.RAW_URI)
	public ModelAndView index(@PathVariable(HippodromesConsulterRoute.PARAM_ID_HIPPODROME) Long idHippodrome) throws NotFoundException {
		IRoute route = new HippodromesConsulterRoute(idHippodrome);
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		Hippodrome hippodrome = hippodromeService.getById(idHippodrome);
		
		modelAndView.addObject(InputOutputAttribute.HIPPODROME, hippodrome);

		return modelAndView;
	}

}