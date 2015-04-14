package com.mooneyserver.dublinpubs.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mooneyserver.dublinpubs.model.Pub;
import com.mooneyserver.dublinpubs.service.PubService;
import com.mooneyserver.dublinpubs.window.InsertNewPubWindow;

public class InsertPubController extends BaseController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(InsertPubController.class);

	@FXML
	private TextField pubName;
	@FXML
	private Spinner<Double> latitude;
	@FXML
	private Spinner<Double> longitude;
	@FXML
	private TextArea review;

	@Inject
	private PubService pubService;
	@Inject
	private Instance<InsertNewPubWindow> insertNewPubWindowAccessor;

	public void submitNewPub() {
		LOGGER.debug("Attempting to submit new pub");
		Pub pub = createPubFromFields();
		pubService
			.submitNewPubAsync(pub)
			.exceptionally(this::displayException);

		insertNewPubWindowAccessor.get().hideWindow();
	}

	public Pub createPubFromFields() {
		Pub pub = new Pub();
		pub.setName(pubName.getText());
		pub.setLatitude(Double.valueOf(latitude.getEditor().getText()));
		pub.setLongitude(Double.valueOf(longitude.getEditor().getText()));
		pub.setReview(review.getText());

		return pub;
	}

	public void clearFields() {
		pubName.setText("");
		latitude.getEditor().setText("0");
		longitude.getEditor().setText("0");
		review.setText("");
	}
}