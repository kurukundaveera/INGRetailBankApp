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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="TRANSACTION_HISTORY")
@Data @Getter @Setter @ToString
public class TransactionHistory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	
	@Column(name="FROM_ACCOUNT_NO")
	private Long fromAccountNo;
	
	@Column(name="TO_ACCOUNT_NO")
	private Long toAccountNo;
	
	@Column(name="TRANSACTION_TYPE")
	private String transactionType;
	
	@Column(name="COMMENTS")
	private String comments;
	
	@Column(name="CLOSING_BALANCE")
	private Double closingBalance;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DT",columnDefinition = "DATETIME")
	private Date createDt;
	
	
	public TransactionHistory() {
		super();
	}
	
}
