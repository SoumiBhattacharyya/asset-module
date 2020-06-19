package com.capgemini.assetmanagement.application.exception;

@SuppressWarnings("serial")
public class InsufficientAssetQuantity extends RuntimeException {

	public InsufficientAssetQuantity(String message) {
		super(message);
	}

}
