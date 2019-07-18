package com.hcl.bookmyflight.exception;

public class BookMyFlightException extends Exception {

	private static final long serialVersionUID = -7000578025975626294L;

	public BookMyFlightException(Throwable t, String msg) {
		super(msg, t);
	}

	public BookMyFlightException(Throwable t) {
		super(t);
	}

	public BookMyFlightException(String msg) {
		super(msg);
	}

}
