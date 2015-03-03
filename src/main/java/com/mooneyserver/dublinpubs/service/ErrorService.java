package com.mooneyserver.dublinpubs.service;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorService {

	public String extractStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);

		return sw.toString();
	}
}