package com.mooneyserver.dublinpubs.controller;

import static com.mooneyserver.dublinpubs.util.resource.ResourceAccessor.APP_TABS_PUBLIST_PUBCOUNT;

import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mooneyserver.dublinpubs.model.Pub;
import com.mooneyserver.dublinpubs.model.ui.PubRow;
import com.mooneyserver.dublinpubs.service.PubService;

public class PubListController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PubListController.class);

	@FXML
	private Label pubCountLabel;
	@FXML
	private TableView<PubRow> pubsTableView;
	@FXML
	private TableColumn<PubRow, String> nameColumn;
	@FXML
	private TableColumn<PubRow, Number> latitudeColumn;
	@FXML
	private TableColumn<PubRow, Number> longitudeColumn;
	@FXML
	private TableColumn<PubRow, String> reviewColumn;
	@FXML
	private ResourceBundle resources;

	@Inject
	private PubService pubService;

	@FXML
	public void initialize() {
		LOGGER.debug("Initializing Admin Page controller.");

		LOGGER.debug("Binding Table columns to properties");
		nameColumn.setCellValueFactory(cellData -> cellData.getValue()
				.getName());
		latitudeColumn.setCellValueFactory(cellData -> cellData.getValue()
				.getLatitude());
		longitudeColumn.setCellValueFactory(cellData -> cellData.getValue()
				.getLongitude());
		reviewColumn.setCellValueFactory(cellData -> cellData.getValue()
				.getReview());

		refreshPubList();
	}

	public void addPubToTable(Pub pub) {
		ObservableList<PubRow> tableData = pubsTableView.getItems();
		tableData.add(PubRow.fromPub(pub));
	}

	public void refreshPubList() {
		LOGGER.debug("Requesting visited pubs from REST service");
		pubService.retrieveVisitedPubsAsync().thenAcceptAsync(
				this::updateUiWithPubDetails);
	}

	void updateUiWithPubDetails(List<Pub> visitedPubs) {
		LOGGER.debug("Pub list received [{}]. Updating UI now", visitedPubs);

		Platform.runLater(() -> {
			updateCountLabelWithPubDetails(visitedPubs);
			updateTableViewWithPubDetails(visitedPubs);
		});
	}

	public void updateCountLabelWithPubDetails(List<Pub> visitedPubs) {
		pubCountLabel.setText(String.format("%s: %d",
				resources.getString(APP_TABS_PUBLIST_PUBCOUNT),
				visitedPubs.size()));
	}

	public void updateTableViewWithPubDetails(List<Pub> visitedPubs) {
		visitedPubs.forEach(this::addPubToTable);
	}
}