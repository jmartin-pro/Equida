package com.equida.api.route.categories_vente;

import com.equida.api.route.IRoute;

public class CategorieVenteDetailsApiRoute implements IRoute {

	public static final String PARAM_ID_CATEG_VENTE = "idCategVente";
	public static final String RAW_URI = CategoriesVenteApiRoute.RAW_URI+"/{"+PARAM_ID_CATEG_VENTE+"}";
	
	private Long id = 0L;
	
	public CategorieVenteDetailsApiRoute(Long id) {
		this.id = id;
	}
	
	@Override
	public String getUri() {
		return RAW_URI.replace("{"+PARAM_ID_CATEG_VENTE+"}", ""+id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
