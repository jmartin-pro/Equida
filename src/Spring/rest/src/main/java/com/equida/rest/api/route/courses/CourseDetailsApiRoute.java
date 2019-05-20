package com.equida.rest.api.route.courses;

import com.equida.rest.api.route.IRoute;

public class CourseDetailsApiRoute implements IRoute {

	public static final String PARAM_ID_COURSE = "idCourse";
	public static final String RAW_URI = CoursesApiRoute.RAW_URI+"/{"+PARAM_ID_COURSE+"}";
	
	private Long id = 0L;
	
	public CourseDetailsApiRoute(Long id) {
		this.id = id;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_COURSE+"}", ""+id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
