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
@Table(name = "ACCOUNT_SUMMARY")
public class AccountSummary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNo;

	@Column(name = "ACCOUNT_TYPE")
	private String accountType;

	@Column(name = "ACCOUNT_NAME")
	private String accountName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "EMAIL_ID")
	private String email;

	@Column(name = "CLOSING_BALANCE")
	private Double closingBalance;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DT", columnDefinition = "DATETIME")
	private Date createDt;

	@Column(name = "USER_ID")
	private Long userId;

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public AccountSummary() {
		super();
	}


}
