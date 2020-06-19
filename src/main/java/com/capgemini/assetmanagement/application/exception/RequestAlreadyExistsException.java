package com.capgemini.assetmanagement.application.exception;

@SuppressWarnings("serial")
public class RequestAlreadyExistsException extends RuntimeException{
	
	public RequestAlreadyExistsException(String message) {
		super(message);
	}

}
