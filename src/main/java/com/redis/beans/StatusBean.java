package com.redis.beans;

public class StatusBean {
	
	 private String status;
	 private String errorCode;
	 private String errormsg;
	 
	public StatusBean(String status, String errorCode, String errormsg) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.errormsg = errormsg;
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
	 

}
