package com.springrest.exception;

import lombok.Data;

@Data
public class CourseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String error;

	public CourseException(String error) {
		this.error = error;
	}

}