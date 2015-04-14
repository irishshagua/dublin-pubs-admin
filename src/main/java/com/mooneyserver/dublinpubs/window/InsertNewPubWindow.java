package com.mooneyserver.dublinpubs.window;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.mooneyserver.dublinpubs.util.resource.ResourceAccessor;

@Singleton
public class InsertNewPubWindow extends Stage implements HideableWindow {

	@Inject
	private FXMLLoader fxmlLoader;
	@Inject
	private ResourceAccessor resourceAccessor;

	@PostConstruct
	private void InitialContext() throws IOException {
		fxmlLoader.setLocation(resourceAccessor
				.getResource(ResourceAccessor.FXML_INSERT_PUB_DIALOG));
		fxmlLoader.setResources(resourceAccessor.getResourceBundle());

		Parent root = (Parent) fxmlLoader.load();
		Scene scene = new Scene(root, 800, 600);

		this.setScene(scene);
		this.initModality(Modality.APPLICATION_MODAL);
		this.initStyle(StageStyle.UTILITY);
	}

	@Override
	public void displayWindow() {
		this.show();
	}

	@Override
	public void hideWindow() {
		this.hide();
	}
}