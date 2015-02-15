package com.mooneyserver.dublinpubs.model.ui;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;

import com.mooneyserver.dublinpubs.model.Pub;

public class PubRow {

	@Getter
	private SimpleStringProperty name = new SimpleStringProperty();
	@Getter
	private SimpleDoubleProperty latitude = new SimpleDoubleProperty();
	@Getter
	private SimpleDoubleProperty longitude = new SimpleDoubleProperty();
	@Getter
	private SimpleStringProperty review = new SimpleStringProperty();

	public static PubRow fromPub(Pub pub) {
		PubRow pubRow = new PubRow();

		pubRow.name.set(pub.getName());
		pubRow.latitude.set(pub.getLatitude());
		pubRow.longitude.set(pub.getLongitude());
		pubRow.review.set(pub.getReview());

		return pubRow;
	}
}