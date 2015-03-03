package com.mooneyserver.dublinpubs.util.di;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import javafx.fxml.FXMLLoader;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.client.Client;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

public class JavaFxRelatedProducers {

	@Inject
	private FxmlLoaderCallback fxmlLoaderCallback;

	@Produces
	public FXMLLoader createLoader() {
		return new FXMLLoader(null, null, null, fxmlLoaderCallback,
				StandardCharsets.UTF_8);
	}

	@Produces
	public Client createRestClient() {
		return new ResteasyClientBuilder().socketTimeout(15, TimeUnit.SECONDS)
				.build();
	}
}