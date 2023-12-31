package com.springrest.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springrest.apierror.ApiError;

import lombok.extern.slf4j.Slf4j;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handle invalid data exception while invalid data from request.
	 * 
	 * @param ex the Exception
	 * @return the ApiError object
	 */
	@ExceptionHandler(CourseException.class)
	protected ResponseEntity<Object> handleInvalidDataExcetpion(CourseException ex) {
		ApiError apiError = new ApiError();
		apiError.setMessage(ex.getError());
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		return  new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
