package com.mooneyserver.dublinpubs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mooneyserver.dublinpubs.model.Pub;

public class PubService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PubService.class);

	private static final String REST_BASE_URL = "http://dublinpubs-mooneyserver.rhcloud.com/rest";
	private static final String REST_PUBS_PATH = "pubs";

	@Inject
	private Client restClient;

	public CompletableFuture<List<Pub>> retrieveVisitedPubsAsync() {
		return CompletableFuture.supplyAsync(this::retrieveVisitedPubs);
	}

	public List<Pub> retrieveVisitedPubs() {
		LOGGER.debug("Starting call to the 'Visited Pubs' REST service now");
		List<Pub> visitedPubs = new ArrayList<Pub>();

		try {
			visitedPubs = restClient
				.target(REST_BASE_URL)
				.path(REST_PUBS_PATH)
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Pub>>() {});
		} catch (ResponseProcessingException e) {
			LOGGER.error(
					"Error retrieving pubs. Unable to deserialize response {}",
					e.getResponse().getEntity(), e);
			throw e;
		} catch (ProcessingException | WebApplicationException e) {
			LOGGER.error(
					"Error retrieving pubs. Rest Call to Pubs endpoint failed",
					e);
			throw e;
		}
		LOGGER.debug("'Visited Pubs' Rest service call complete: {}",
				visitedPubs);

		return visitedPubs;
	}
}