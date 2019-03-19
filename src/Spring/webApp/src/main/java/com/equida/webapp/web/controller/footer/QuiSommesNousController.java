package com.equida.webapp.web.controller.footer;

import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.footer.QuiSommesNousRoute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuiSommesNousController extends AbstractWebController {
	
	@GetMapping(QuiSommesNousRoute.RAW_URI)
	public ModelAndView index() {
		IRoute route = new QuiSommesNousRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		
		return modelAndView;
	}

}
