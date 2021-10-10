package com.laptrinhjavaweb.exception;

public class InvalidTokenException extends RuntimeException{
	private String message;
	
	public InvalidTokenException() {
		// TODO Auto-generated constructor stub
	}
	
	public InvalidTokenException(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
