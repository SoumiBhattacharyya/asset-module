package com.capgemini.assetmanagement.application.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse<T> {

	private boolean error;
	private String message;
//	T data;
	private List<User> data;
	private User users;

	
}
