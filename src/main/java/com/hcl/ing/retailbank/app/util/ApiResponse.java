package com.hcl.ing.retailbank.app.util;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter @Getter @ToString
public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer statusCode;
	
	private String status;
	private String message;
	
	public ApiResponse() {
		super();
	}

	

}
