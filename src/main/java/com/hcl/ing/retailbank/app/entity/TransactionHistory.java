package com.hcl.ing.retailbank.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TRANSACTION_HISTORY")

public class TransactionHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;

	@Column(name = "FROM_ACCOUNT_NO")
	private Long fromAccountNo;

	@Column(name = "TO_ACCOUNT_NO")
	private Long toAccountNo;

	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;

	@Column(name = "COMMENTS")
	private String comments;

	@Column(name = "CLOSING_BALANCE")
	private Double closingBalance;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DT", columnDefinition = "DATETIME")
	private Date createDt;
	
	@Column(name="AMOUNT")
	private Double amount;
	
	
	@Override
	public String toString() {
		return "TransactionHistory [transactionId=" + transactionId + ", fromAccountNo=" + fromAccountNo
				+ ", toAccountNo=" + toAccountNo + ", transactionType=" + transactionType + ", comments=" + comments
				+ ", closingBalance=" + closingBalance + ", createDt=" + createDt + "]";
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

	public TransactionHistory() {
		super();
	}

}
