package com.equida.rest.api.controller.courses;

import com.equida.rest.api.dto.ChevalDto;
import com.equida.rest.api.route.chevaux.ChevalDetailsApiRoute;
import com.equida.common.bdd.entity.Cheval;
import com.equida.common.bdd.entity.Course;
import com.equida.common.exception.NotFoundException;
import com.equida.common.service.CourseService;
import com.equida.rest.api.dto.CourseDto;
import com.equida.rest.api.route.courses.CourseDetailsApiRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseDetailsRestController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping(CourseDetailsApiRoute.RAW_URI)
	public CourseDto get(@PathVariable(value = CourseDetailsApiRoute.PARAM_ID_COURSE) Long idCourse) throws NotFoundException {
		Course course = courseService.getById(idCourse);
		
		return CourseDto.convertToDto(course);
	}
}