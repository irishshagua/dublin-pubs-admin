package com.mooneyserver.dublinpubs.controller;

import java.util.List;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mooneyserver.dublinpubs.model.Pub;
import com.mooneyserver.dublinpubs.service.PubService;

public class AdminController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdminController.class);

	@FXML
	private Label pubCountLabel;

	@Inject
	private PubService pubService;

	@FXML
	public void initialize() {
		LOGGER.debug("Initializing Admin Page controller. Requesting visited pubs from REST service");
		pubService.retrieveVisitedPubsAsync().thenAcceptAsync(
				this::updateUiWithPubDetails);
	}

	void updateUiWithPubDetails(List<Pub> visitedPubs) {
		Platform.runLater(() -> {
			LOGGER.debug("Pub list received [{}]. Updating UI now", visitedPubs);
			pubCountLabel.setText(String.format("#Pubs: %d", visitedPubs.size()));
		});
	}
}