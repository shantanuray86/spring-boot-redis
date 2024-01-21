package com.redis.exceptions;

public class ApplicationException extends Exception{

	/**
	 * Constructor
	 */
	
	public ApplicationException() {
		super();
	}
	
	/**
	 * Constructor
	 * @param message
	 */
	
	public ApplicationException(String msg) {
		super(msg);
	}
	
	/**
	 * Constructor
	 * @param message
	 */
	
	public ApplicationException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Constructor
	 * @param message
	 */
	
	public ApplicationException(String msg,Throwable cause) {
		super(msg,cause);
	}
}
