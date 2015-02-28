package com.mooneyserver.dublinpubs.model.ui;

import org.junit.Assert;
import org.junit.Test;

import com.mooneyserver.dublinpubs.model.Pub;

public class PubRowTest {

	private static final String PUB_NAME = "A Pub";
	private static final Double LATITUDE = 1.1234;
	private static final Double LONGITUDE = -4.7584;
	private static final String REVIEW = "A fuckin shithole, but sure they had beer...";
	
	@Test
	public void testFromPub() {
		PubRow pubRow = PubRow.fromPub(generateSamplePub());
		
		Assert.assertEquals(PUB_NAME, pubRow.getName().get());
		Assert.assertEquals(LATITUDE, (Double) pubRow.getLatitude().get());
		Assert.assertEquals(LONGITUDE, (Double) pubRow.getLongitude().get());
		Assert.assertEquals(REVIEW, pubRow.getReview().get());
	}
	
	private Pub generateSamplePub() {
		Pub pub = new Pub();
		pub.setId(1);
		pub.setName(PUB_NAME);
		pub.setLatitude(LATITUDE);
		pub.setLongitude(LONGITUDE);
		pub.setReview(REVIEW);
		
		return pub;
	}
}