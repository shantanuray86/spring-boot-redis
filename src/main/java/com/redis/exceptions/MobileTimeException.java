package com.redis.exceptions;

public class MobileTimeException extends RuntimeException{
	

	private static final long serialVersionUID = 1l;
	
	String status;
	String errorCode;
	String errormsg;
	Exception exception;
	
	public MobileTimeException(String status, String errorCode, String errormsg, Exception exception) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.errormsg = errormsg;
		this.exception = exception;
	}
	
	public MobileTimeException(String status, String errorCode, String errormsg) {
		
//		this.status = status;
//		this.errorCode = errorCode;
//		this.errormsg = errormsg;
		this(status,errorCode,errormsg,null);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	
	

}
