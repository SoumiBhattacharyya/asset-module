package com.capgemini.assetmanagement.application.exception;

public class RequestNotFoundException extends RuntimeException {

	public RequestNotFoundException(String message) {
		super(message);
	}

}
