package com.mooneyserver.dublinpubs.util.di;

import static com.mooneyserver.dublinpubs.util.resource.ResourceAccessor.APP_FRAME_TITLE;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.inject.Inject;

import com.mooneyserver.dublinpubs.util.resource.ResourceAccessor;

public class DublinPubsAdminCdi {

	@Inject
	private FXMLLoader fxmlLoader;
	@Inject
	private ResourceAccessor resourceAccessor;

	public void start(Stage primaryStage) throws IOException {
		fxmlLoader.setLocation(resourceAccessor
				.getResource(ResourceAccessor.FXML_LANDING_PAGE));
		fxmlLoader.setResources(resourceAccessor.getResourceBundle());

		Parent root = (Parent) fxmlLoader.load();

		Scene scene = new Scene(root, 800, 600);
		scene.getStylesheets().add(
				resourceAccessor.getResource(ResourceAccessor.CSS_APP)
						.toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.setTitle(resourceAccessor.getResourceBundle().getString(
				APP_FRAME_TITLE));
		
		primaryStage.show();
	}
}