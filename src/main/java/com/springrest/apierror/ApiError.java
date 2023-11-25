package com.springrest.apierror;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {

	private HttpStatus status;
	private String message;
}
