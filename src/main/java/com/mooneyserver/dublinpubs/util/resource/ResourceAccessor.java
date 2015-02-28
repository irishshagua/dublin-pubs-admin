package com.mooneyserver.dublinpubs.util.resource;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceAccessor {

	// FXML Files
	public static final String FXML_LANDING_PAGE = "fxml/MainFrame.fxml";

	// CSS Files
	public static final String CSS_APP = "css/application.css";

	// Localization Keys
	public static final String APP_FRAME_TITLE = "app.frame.title";
	public static final String APP_TABS_PUBLIST_PUBCOUNT = "app.tabs.pub_list.pub_count_lbl";

	// Localized Strings
	private static final String STRINGS = "i18n/AdminStrings";

	public URL getResource(String resourceName) {
		return ResourceAccessor.class.getClassLoader()
				.getResource(resourceName);
	}

	public ResourceBundle getResourceBundle() {
		return ResourceBundle.getBundle(STRINGS, Locale.getDefault());
	}
}