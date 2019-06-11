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
@Table(name="ACCOUNT_SUMMARY")
@Data @Getter @Setter @ToString
public class AccountSummary implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNo;
	
	@Column(name="ACCOUNT_TYPE")
	private String accountType;
	
	@Column(name="ACCOUNT_NAME")
	private String accountName;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="EMAIL_ID")
	private String email;
	
	@Column(name="CLOSING_BALANCE")
	private Double closingBalance;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DT",columnDefinition = "DATETIME")
	private Date createDt;
	
	@Column(name="USER_ID")
	private Long userId;
	
	
	public AccountSummary() {
		super();
	}

	
}
