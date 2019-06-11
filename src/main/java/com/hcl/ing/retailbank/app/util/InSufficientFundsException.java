package com.hcl.ing.retailbank.app.util;


public class InSufficientFundsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InSufficientFundsException() {
		super();
	}
	
	public InSufficientFundsException(final String message) {
		super(message);
	}
	
	
}
