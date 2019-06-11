package com.hcl.ing.retailbank.app.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RetailBankGlobalExceptionHandler {

	@ExceptionHandler(RetailBankServiceException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleStockServiceException(final RetailBankServiceException exception,
			final HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMsg(exception.getMessage());
		response.setRequestUri(request.getRequestURI());
		return response;
	}

	
}
