package com.stg.exception;

public class CustomException extends RuntimeException {

	private String message;

	public CustomException() {
		super();
	}

	public CustomException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {

		return this.message;
	}

}
