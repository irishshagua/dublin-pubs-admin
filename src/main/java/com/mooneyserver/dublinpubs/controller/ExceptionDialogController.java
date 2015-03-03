package com.mooneyserver.dublinpubs.controller;

import javax.inject.Inject;

import com.mooneyserver.dublinpubs.service.ErrorService;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ExceptionDialogController {

	@Inject
	private ErrorService errorService;
	
	@FXML
	private Label exceptionLabel;
	@FXML
	private TextArea exceptionDisplayTextArea;

	public void setExceptionDisplay(Throwable t) {
		exceptionLabel.setText(t.getLocalizedMessage());
		exceptionDisplayTextArea.setText(errorService.extractStackTrace(t));		
	}
}