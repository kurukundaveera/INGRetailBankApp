package com.hcl.ing.retailbank.app.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter @Getter @ToString
public class FundTransferRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message="Source account number is required")
	private Long fromAccount;
	
	@NotNull(message = "Destination account number is required")
	private Long toAccount;
	
	@NotNull(message="Amount is required")
	private Double amount;
	
	private String comments;
	
	public FundTransferRequest() {
		super();
	}
}
