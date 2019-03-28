package com.equida.webapp.web.route.courses;

import com.equida.webapp.web.route.IRoute;

public class CoursesRoute implements IRoute{

	public static final String RAW_URI = "/courses";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

	@Override
	public String getView() {
		return "view/courses/lister";
	}

	@Override
	public String getTitle() {
		return "Les courses";
	}
}
