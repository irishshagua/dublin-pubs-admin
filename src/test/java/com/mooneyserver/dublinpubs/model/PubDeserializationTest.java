package com.mooneyserver.dublinpubs.model;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PubDeserializationTest {

	private static final String SAMPLE_PUB_JSON_STRING = "models/pub.json";

	@Test
	public void testPubDeserializationToModel() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Pub pub = objectMapper.readValue(getSamplePubJson(), Pub.class);

		Assert.assertEquals(new Integer(1), pub.getId());
		Assert.assertEquals("Pub Name", pub.getName());
		Assert.assertEquals(new Double(53.33972), pub.getLatitude());
		Assert.assertEquals(new Double(-6.25886), pub.getLongitude());
		Assert.assertEquals("Some Review About A Pub", pub.getReview());
	}

	private String getSamplePubJson() {
		try {
			return IOUtils.toString(PubDeserializationTest.class
					.getClassLoader().getResourceAsStream(
							SAMPLE_PUB_JSON_STRING));
		} catch (IOException e) {
			Assert.fail(e.getMessage());
			return "";
		}
	}
}