package com.ionix.test.exception;

import org.springframework.http.HttpStatus;

public class RESTException extends Exception{

	private static final long serialVersionUID = 1L;
	private final HttpStatus status;


	public RESTException(HttpStatus status) {
		this.status = status;
	}

	public RESTException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
}
