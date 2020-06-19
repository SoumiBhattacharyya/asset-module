package com.capgemini.assetmanagement.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.assetmanagement.application.entity.AssetResponse;
import com.capgemini.assetmanagement.application.entity.Assets;
import com.capgemini.assetmanagement.application.entity.RequestResponse;
import com.capgemini.assetmanagement.application.entity.Requests;
import com.capgemini.assetmanagement.application.entity.UserResponse;
import com.capgemini.assetmanagement.application.entity.Users;

@ControllerAdvice
public class GenericExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<RequestResponse<Requests>> handleException(RequestNotFoundException ex) {
		RequestResponse<Requests> response = new RequestResponse<Requests>(true, ex.getMessage(),null,null);
		return new ResponseEntity<RequestResponse<Requests>>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<UserResponse<Users>> handleException(UserNotFoundException ex) {
		UserResponse<Users> response = new UserResponse<Users>(true, ex.getMessage(), null,null);
		return new ResponseEntity<UserResponse<Users>>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<AssetResponse<Assets>> handleException(AssetNotFoundException ex) {
		AssetResponse<Assets> response = new AssetResponse<Assets>(true, ex.getMessage(), null,null);
		return new ResponseEntity<AssetResponse<Assets>>(response, HttpStatus.NOT_FOUND);
	}

}
