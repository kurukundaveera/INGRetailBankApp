package com.hcl.ing.retailbank.app.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter @Getter @ToString
public class FundTransferRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long fromAccount;
	
	private Long toAccount;
	
	private Double amount;
	
	private String comments;
	
	public FundTransferRequest() {
		super();
	}
}
