package com.bu.bsaini.Capacitometer.Exceptions;

public class CustomException extends RuntimeException {

	/**
	 * constant variable to hold serial version id
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor to hold exception message
	 * @param message
	 */
	public CustomException(String message) {
		super(message);
	}
}
