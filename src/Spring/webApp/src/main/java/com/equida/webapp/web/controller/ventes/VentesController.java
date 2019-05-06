package com.equida.webapp.web.controller.ventes;

import com.equida.common.bdd.entity.CategVente;
import com.equida.common.bdd.entity.Lot;
import com.equida.common.bdd.entity.Vente;
import com.equida.common.exception.NotFoundException;
import com.equida.common.service.CategorieVenteService;
import com.equida.common.service.LotService;
import com.equida.common.service.VenteService;
import com.equida.common.utils.DateUtils;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.ventes.VentesConsulterRoute;
import com.equida.webapp.web.route.ventes.VentesRoute;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VentesController extends AbstractWebController {
	
	@Autowired
	private LotService lotService;
	
	@Autowired
	private CategorieVenteService categorieVenteService;
	
	@Autowired
	private VenteService venteService;
	
	@GetMapping(VentesRoute.RAW_URI)
	public ModelAndView lister(@RequestParam(required = false, name = VentesRoute.PARAM_ID_CATEG_VENTE)Long idCategVente) {
		IRoute route = new VentesRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		List<CategVente> categVentes = categorieVenteService.getAll();
		List<Vente> ventes = (idCategVente == null) ? venteService.getAll() : venteService.getAllByIdCategVente(idCategVente);
		
		modelAndView.addObject(InputOutputAttribute.LISTE_VENTES, ventes);
		modelAndView.addObject(InputOutputAttribute.LISTE_CATEG_VENTES, categVentes);
		modelAndView.addObject(InputOutputAttribute.CATEG_VENTE, idCategVente);
		
		return modelAndView;
	}
	
	@GetMapping(VentesConsulterRoute.RAW_URI)
	public ModelAndView consulter(@PathVariable(VentesConsulterRoute.PARAM_ID_VENTE) Long idVente) throws NotFoundException {
		IRoute route = new VentesConsulterRoute(idVente);
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		Vente vente = venteService.getById(idVente);
		List<Lot> lots = lotService.getLotsByIdVente(idVente);
		
		modelAndView.addObject(InputOutputAttribute.VENTE, vente);
		modelAndView.addObject(InputOutputAttribute.IS_INSCRIPTION_OUVERTE, DateUtils.isBetween(vente.getDateDebut(), vente.getDateFin()));
		modelAndView.addObject(InputOutputAttribute.LISTE_LOTS, lots);
		
		return modelAndView;
	}

}
