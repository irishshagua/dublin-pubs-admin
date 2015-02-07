package com.mooneyserver.dublinpubs.resource;

import java.net.URL;

public class ResourceAccessor {

	// FXML Files
	public static final String FXML_LANDING_PAGE = "fxml/Admin.fxml";
	
	// CSS Files
	public static final String CSS_APP = "css/application.css";
	
	public URL getResource(String resourceName) {
		return ResourceAccessor.class.getClassLoader().getResource(resourceName);
	}
}