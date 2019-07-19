package com.hcl.bookmyflight.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResponseData implements Serializable {

	private static final long serialVersionUID = 4806995052658367581L;

	private String message;
	private HttpStatus httpStatus;
	private Object data;

}
