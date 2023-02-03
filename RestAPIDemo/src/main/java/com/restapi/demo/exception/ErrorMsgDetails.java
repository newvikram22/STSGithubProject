package com.restapi.demo.exception;

import java.time.LocalDateTime;

public class ErrorMsgDetails {
	
	
	private LocalDateTime errorTime;
	private String message;
	private int status;
	public LocalDateTime getErrorTime() {
		return errorTime;
	}
	public void setErrorTime(LocalDateTime errorTime) {
		this.errorTime = errorTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public ErrorMsgDetails(LocalDateTime now, String message2, int value) {
		super();
		this.errorTime = now;
		this.message = message2;
		this.status = value;
	}
	public ErrorMsgDetails() {
		super();
	}
	
	
	
	

}
