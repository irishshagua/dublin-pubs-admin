package com.mooneyserver.dublinpubs.di;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.inject.Inject;

import com.mooneyserver.dublinpubs.resource.ResourceAccessor;

public class DublinPubsAdminCdi {

	@Inject
	private FXMLLoader fxmlLoader;
	@Inject
	private ResourceAccessor resourceAccessor;

	public void start(Stage primaryStage)
			throws IOException {
		fxmlLoader.setLocation(resourceAccessor
				.getResource(ResourceAccessor.FXML_LANDING_PAGE));
		Parent root = (Parent) fxmlLoader.load();

		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(
				resourceAccessor.getResource(ResourceAccessor.CSS_APP)
						.toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}