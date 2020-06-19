package com.capgemini.assetmanagement.application.exception;

@SuppressWarnings("serial")
public class AssetNotFoundException extends RuntimeException {

	public AssetNotFoundException(String message) {
		super(message);
	}

}
