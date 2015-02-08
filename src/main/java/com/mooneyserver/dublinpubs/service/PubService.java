package com.mooneyserver.dublinpubs.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
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

	private Client restClient;

	@PostConstruct
	void initRestClient() {
		restClient = ClientBuilder.newClient();
	}

	public CompletableFuture<List<Pub>> retrieveVisitedPubsAsync() {
		return CompletableFuture.supplyAsync(this::retrieveVisitedPubs);
	}

	public List<Pub> retrieveVisitedPubs() {
		LOGGER.debug("Starting call to the 'Visited Pubs' REST service now");
		List<Pub> visitedPubs = restClient.target(REST_BASE_URL)
				.path(REST_PUBS_PATH).request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Pub>>() {
				});
		LOGGER.debug("'Visited Pubs' Rest service call complete: {}",
				visitedPubs);

		return visitedPubs;
	}
}