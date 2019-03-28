package com.equida.webapp.web.route.courses;

import com.equida.webapp.web.route.IRoute;

public class CoursesDeleteRoute implements IRoute{

	public static final String PARAM_ID_COURSE = "idCourse";
	public static final String RAW_URI = "/courses/{"+PARAM_ID_COURSE+"}/delete";

	private Long idCourse;
	
	public CoursesDeleteRoute(Long idCourse) {
		this.idCourse = idCourse;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_COURSE+"}", ""+this.idCourse);
	}

	@Override
	public String getView() {
		return null;
	}

	@Override
	public String getTitle() {
		return null;
	}

	public Long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}
	
}
