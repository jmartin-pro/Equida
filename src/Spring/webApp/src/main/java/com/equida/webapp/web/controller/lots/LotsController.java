package com.equida.webapp.web.controller.lots;

import com.equida.webapp.web.controller.lots.*;
import com.equida.common.bdd.entity.Lot;
import com.equida.common.exception.NotFoundException;
import com.equida.common.service.LotService;
import com.equida.common.utils.DateUtils;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.lots.LotsDeleteRoute;
import com.equida.webapp.web.route.lots.LotsRoute;
import com.equida.webapp.web.route.lots.LotsValiderRoute;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LotsController extends AbstractWebController {
	
	@Autowired
	private LotService lotService;
	
	@GetMapping(LotsRoute.RAW_URI)
	public ModelAndView lister() {
		IRoute route = new LotsRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		List<Lot> lots = lotService.getAll();
		modelAndView.addObject(InputOutputAttribute.LISTE_LOTS, lots);
		
		return modelAndView;
	}
	
	@GetMapping(LotsValiderRoute.RAW_URI)
	public RedirectView valider(@PathVariable(LotsValiderRoute.PARAM_ID_LOT) Long idLot) {
		try {
			lotService.validerLot(idLot);
		} catch(Exception e) {
			e.printStackTrace();
		} 
			
		return new RedirectView(LotsRoute.RAW_URI);
	}
	
	@GetMapping(LotsDeleteRoute.RAW_URI)
	public RedirectView delete(@PathVariable(LotsDeleteRoute.PARAM_ID_LOT) Long idLot) {
		try {
			lotService.deleteLot(idLot);
		} catch(Exception e) {
			e.printStackTrace();
		} 
			
		return new RedirectView(LotsRoute.RAW_URI);
	}

}
