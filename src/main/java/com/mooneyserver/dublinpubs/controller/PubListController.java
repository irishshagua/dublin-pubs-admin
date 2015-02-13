package com.mooneyserver.dublinpubs.controller;

import static com.mooneyserver.dublinpubs.util.resource.ResourceAccessor.APP_TABS_PUBLIST_PUBCOUNT;

import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mooneyserver.dublinpubs.model.Pub;
import com.mooneyserver.dublinpubs.service.PubService;

public class PubListController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PubListController.class);

	@FXML
	private Label pubCountLabel;
	@FXML
	private ResourceBundle resources;

	@Inject
	private PubService pubService;

	@FXML
	public void initialize() {
		LOGGER.debug("Initializing Admin Page controller. Requesting visited pubs from REST service");
		pubService.retrieveVisitedPubsAsync().thenAcceptAsync(
				this::updateUiWithPubDetails);
	}

	void updateUiWithPubDetails(List<Pub> visitedPubs) {
		LOGGER.debug("Pub list received [{}]. Updating UI now", visitedPubs);

		Platform.runLater(() -> {
			pubCountLabel.setText(String.format("%s: %d",
					resources.getString(APP_TABS_PUBLIST_PUBCOUNT),
					visitedPubs.size()));
		});
	}
}