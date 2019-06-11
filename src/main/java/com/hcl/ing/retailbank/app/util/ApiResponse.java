package com.hcl.ing.retailbank.app.util;

import java.io.Serializable;

public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer statusCode;

	private String status;
	private String message;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ApiResponse() {
		super();
	}

}
