package com.mooneyserver.dublinpubs.util.resource;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceAccessor {

	// FXML Files
	public static final String FXML_LANDING_PAGE = "fxml/MainFrame.fxml";
	public static final String FXML_INSERT_PUB_DIALOG = "fxml/InsertPub.fxml";
	public static final String FXML_ERROR_DIALOG = "fxml/ExceptionDialog.fxml";

	// CSS Files
	public static final String CSS_APP = "css/application.css";

	// Localization Keys
	public static final String APP_FRAME_TITLE = "app.frame.title";
	public static final String APP_TABS_PUBLIST_PUBCOUNT = "app.tabs.pub_list.pub_count_lbl";
	public static final String APP_DIALOG_ERROR = "dialog.exception.title";

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