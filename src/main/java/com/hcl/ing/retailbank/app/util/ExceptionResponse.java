package com.hcl.ing.retailbank.app.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter @Getter 
public class ExceptionResponse {

	private String errorMsg;
	
	private String requestUri;
	private Integer statusCode;
	
	public ExceptionResponse() {
		super();
	}

	
	
}
