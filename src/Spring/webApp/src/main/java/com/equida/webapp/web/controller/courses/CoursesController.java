package com.equida.webapp.web.controller.courses;

import com.equida.common.bdd.entity.Course;
import com.equida.common.exception.NotFoudException;
import com.equida.common.service.CourseService;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.controller.AbstractWebController;
import com.equida.webapp.web.form.courses.CoursesAddForm;
import com.equida.webapp.web.form.courses.CoursesUpdateForm;
import com.equida.webapp.web.route.IRoute;
import com.equida.webapp.web.route.courses.CoursesAddRoute;
import com.equida.webapp.web.route.courses.CoursesDeleteRoute;
import com.equida.webapp.web.route.courses.CoursesRoute;
import com.equida.webapp.web.route.courses.CoursesUpdateRoute;
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
public class CoursesController extends AbstractWebController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping(CoursesRoute.RAW_URI)
	public ModelAndView index() {
		IRoute route = new CoursesRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		
		List<Course> course = courseService.getAll();
		modelAndView.addObject(InputOutputAttribute.LISTE_COURSES, course);
		
		return modelAndView;
	}
	
	@GetMapping(CoursesAddRoute.RAW_URI)
	public ModelAndView addGet(Model model) {
		IRoute route = new CoursesAddRoute();
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		registerForm(modelAndView, model, CoursesAddForm.class, null);
		
		return modelAndView;
	}
	
	@PostMapping(CoursesAddRoute.RAW_URI)
	public RedirectView addPost(@Valid CoursesAddForm coursesForm, BindingResult bindingResult, RedirectAttributes attributes) {
		if(checkForError(bindingResult, attributes, coursesForm)) {
			return new RedirectView(CoursesAddRoute.RAW_URI);
		}

		try {
			courseService.create(coursesForm.getNom(), coursesForm.getDateCourse(), coursesForm.getVille());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new RedirectView(CoursesRoute.RAW_URI);
	}
	
	@GetMapping(CoursesUpdateRoute.RAW_URI)
	public ModelAndView updateGet(Model model, @PathVariable(CoursesUpdateRoute.PARAM_ID_COURSE) Long idCourse) {
		IRoute route = new CoursesUpdateRoute(idCourse);
		
		ModelAndView modelAndView = new ModelAndView(route.getView());
		modelAndView.addObject(InputOutputAttribute.TITLE, route.getTitle());
		try {
			registerForm(modelAndView, model, CoursesUpdateForm.class, courseService.getById(idCourse));	
		} catch(Exception e) {
			e.printStackTrace();
			throw new NotFoudException();
		}
		
		return modelAndView;
	}
	
	@PostMapping(CoursesUpdateRoute.RAW_URI)
	public RedirectView updatePost(@PathVariable(CoursesUpdateRoute.PARAM_ID_COURSE) Long idCourse, @Valid CoursesUpdateForm coursesForm, BindingResult bindingResult, RedirectAttributes attributes) {		
		if(checkForError(bindingResult, attributes, coursesForm)) {
			return new RedirectView(CoursesUpdateRoute.RAW_URI);
		}

		try {
			courseService.updateCourse(idCourse, coursesForm.getNom(), coursesForm.getDateCourse(), coursesForm.getVille());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new RedirectView(CoursesRoute.RAW_URI);
	}
	
	@GetMapping(CoursesDeleteRoute.RAW_URI)
	public RedirectView delete(@PathVariable(CoursesDeleteRoute.PARAM_ID_COURSE) Long idCourse) {
		try {
			courseService.deleteCourse(idCourse);
		} catch(Exception e) {
			e.printStackTrace();
		} 
			
		return new RedirectView(CoursesRoute.RAW_URI);
	}
}