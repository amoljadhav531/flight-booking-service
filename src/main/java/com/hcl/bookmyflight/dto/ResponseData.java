package com.hcl.bookmyflight.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class ResponseData implements Serializable {

	private static final long serialVersionUID = 4806995052658367581L;
	
	private String message;
	private HttpStatus httpStatus;
	private Object data;

	public ResponseData() {
		super();
	}

	public ResponseData(String message, HttpStatus httpStatus, Object data) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
