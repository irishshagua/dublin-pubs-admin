package com.mooneyserver.dublinpubs.util.di;

import javafx.util.Callback;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FxmlLoaderCallback implements Callback<Class<?>, Object> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FxmlLoaderCallback.class);

	@Inject
	Instance<Object> instance;

	@Override
	public Object call(Class<?> param) {
		LOGGER.debug("FXML Loader injection requested for {}", param);
		return instance.select(param).get();
	}
}