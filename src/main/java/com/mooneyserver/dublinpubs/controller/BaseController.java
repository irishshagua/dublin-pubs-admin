package com.mooneyserver.dublinpubs.controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mooneyserver.dublinpubs.util.resource.ResourceAccessor;

public abstract class BaseController implements DisplaysErrors {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(BaseController.class);

	@Inject
	private FXMLLoader fxmlLoader;
	@Inject
	private ResourceAccessor resourceAccessor;

	public Void displayException(Throwable t) {
		Platform.runLater(() -> {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Serious Error");
			alert.setContentText(t.getLocalizedMessage());
			alert.getDialogPane().setContent(generateErrorDialogNode(t));
			alert.setResizable(true);
			alert.showAndWait();
		});

		return null;
	}

	private Node generateErrorDialogNode(Throwable t) {
		try {
			fxmlLoader.setLocation(resourceAccessor
					.getResource(ResourceAccessor.FXML_ERROR_DIALOG));
			Node content = fxmlLoader.load();
			ExceptionDialogController controller = fxmlLoader
					.<ExceptionDialogController> getController();
			controller.setExceptionDisplay(t);

			return content;
		} catch (IOException e) {
			LOGGER.error(
					"Critical error trying to build exception display dialog",
					e);
			return null;
		}
	}
}