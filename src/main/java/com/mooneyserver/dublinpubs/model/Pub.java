package com.mooneyserver.dublinpubs.model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class Pub {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("latitude")
	private Double latitude;

	@JsonProperty("longitude")
	private Double longitude;

	@JsonProperty("review")
	private String review;
}