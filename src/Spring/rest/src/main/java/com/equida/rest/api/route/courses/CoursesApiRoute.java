package com.equida.rest.api.route.courses;

import com.equida.rest.api.route.IRoute;

public class CoursesApiRoute implements IRoute {

	public static final String RAW_URI = "/api/courses";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

}
