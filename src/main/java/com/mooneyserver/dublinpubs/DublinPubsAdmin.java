package com.mooneyserver.dublinpubs;

import javafx.application.Application;
import javafx.stage.Stage;

import org.jboss.weld.environment.se.Weld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mooneyserver.dublinpubs.util.di.DublinPubsAdminCdi;

public class DublinPubsAdmin extends Application {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DublinPubsAdmin.class);

	private Weld weld;

	@Override
	public void start(Stage primaryStage) throws Exception {
		weld.initialize().instance().select(DublinPubsAdminCdi.class).get()
				.start(primaryStage);
	}

	@Override
	public void init() throws Exception {
		super.init();
		weld = new Weld();
	}

	@Override
	public void stop() throws Exception {
		LOGGER.info("Closing Dublin Pubs Admin Desktop Client");
		weld.shutdown();
		super.stop();		
	}

	public static void main(String[] args) {
		LOGGER.info("Starting up Dublin Pubs Admin Desktop Client");
		launch(args);
	}
}