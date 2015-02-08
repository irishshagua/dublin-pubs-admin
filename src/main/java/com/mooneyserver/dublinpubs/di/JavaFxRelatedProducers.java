package com.mooneyserver.dublinpubs.di;

import java.nio.charset.StandardCharsets;

import javafx.fxml.FXMLLoader;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class JavaFxRelatedProducers {

	@Inject
	private FxmlLoaderCallback fxmlLoaderCallback;

	@Produces
	public FXMLLoader createLoader() {
		return new FXMLLoader(null, null, null, fxmlLoaderCallback, StandardCharsets.UTF_8);
	}
}