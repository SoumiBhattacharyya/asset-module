package com.capgemini.assetmanagement.application.exception;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends RuntimeException{
	
	public UserAlreadyExistsException(String message) {
		super(message);
	}

}
