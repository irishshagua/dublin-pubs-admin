package com.mooneyserver.dublinpubs.controller;

public interface DisplaysErrors {

	<T> T displayException(Throwable t);
}