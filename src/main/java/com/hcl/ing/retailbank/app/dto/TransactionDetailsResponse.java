package com.hcl.ing.retailbank.app.dto;

import java.io.Serializable;

import com.hcl.ing.retailbank.app.util.ApiResponse;

public class TransactionDetailsResponse extends ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private TransactionDetails transactionDetails;
	
	public TransactionDetailsResponse() {
		super();
		
	}

	public TransactionDetails getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(TransactionDetails transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	
	

}
