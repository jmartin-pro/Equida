package com.equida.rest.api.route.categories_vente;

import com.equida.rest.api.route.IRoute;

public class CategoriesVenteApiRoute implements IRoute {

	public static final String RAW_URI = "/api/categoriesVente";
	
	@Override
	public String getUri() {
		return RAW_URI;
	}

}
