package com.capgemini.assetmanagement.application.exception;

@SuppressWarnings("serial")
public class AssetAlreadyExistsException extends RuntimeException {

	public AssetAlreadyExistsException(String message) {
		super(message);
	}

}
