package com.rab3tech.rest.controller;

public class AppResponse {
	
	private int code;
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "AppResponse [code=" + code + ", message=" + message + "]";
	}
	
	

}
