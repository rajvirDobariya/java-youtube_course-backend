package com.springrest.apierror;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiError {

	private HttpStatus status;
	private String message;
}
