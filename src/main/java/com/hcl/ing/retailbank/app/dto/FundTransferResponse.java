package com.hcl.ing.retailbank.app.dto;

import java.io.Serializable;

import com.hcl.ing.retailbank.app.util.ApiResponse;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter @Getter @ToString
public class FundTransferResponse extends ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public FundTransferResponse() {
		super();
	}

}
