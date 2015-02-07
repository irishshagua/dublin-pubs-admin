package com.mooneyserver.dublinpubs.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.inject.Inject;

import com.mooneyserver.dublinpubs.service.PubService;

public class AdminController {

	@FXML
	private Label pubCountLabel;

	@Inject
	private PubService pubService;

	@FXML
	public void initialize() {
		pubCountLabel.setText(String.format("#Pubs: %d",
				pubService.getNumberOfVisitedPubs()));
	}
}