package com.hcl.ing.retailbank.app.dto;

import java.io.Serializable;

public class FundTransferRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fromAccount;

	private Long toAccount;

	private Double amount;

	private String comments;

	public Long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Long getToAccount() {
		return toAccount;
	}

	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public FundTransferRequest() {
		super();
	}
}
