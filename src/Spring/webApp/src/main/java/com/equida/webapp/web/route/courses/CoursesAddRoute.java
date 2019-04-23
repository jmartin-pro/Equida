package com.equida.webapp.web.route.courses;

import com.equida.webapp.web.route.IRoute;

public class CoursesAddRoute implements IRoute{

	public static final String RAW_URI = "/courses/add";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/courses/form";
	}

	@Override
	public String getTitle() {
		return "Ajouter une course";
	}
}
