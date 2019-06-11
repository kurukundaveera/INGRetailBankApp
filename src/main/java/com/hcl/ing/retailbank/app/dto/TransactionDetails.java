package com.hcl.ing.retailbank.app.dto;

import java.io.Serializable;
import java.util.Date;

public class TransactionDetails  implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private Long transactionId;
	
	private Long fromAccountNo;
	
	private Long toAccountNo;
	
	private String transactionType;
	
	private String comments;
	
	private Double closingBalance;
	
	private Date createDt;
	
	private Double amount;
	
	public TransactionDetails() {
		super();
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getFromAccountNo() {
		return fromAccountNo;
	}

	public void setFromAccountNo(Long fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}

	public Long getToAccountNo() {
		return toAccountNo;
	}

	public void setToAccountNo(Long toAccountNo) {
		this.toAccountNo = toAccountNo;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	

}
