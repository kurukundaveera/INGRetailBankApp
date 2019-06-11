package com.hcl.ing.retailbank.app.dto;

import java.io.Serializable;
import java.util.Date;

public class AccountSummaryResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long accountNo;
	private String accountType;
	private Double closingBalance;
	private Date createDt;
	private String meassage;
	
	public String getMeassage() {
		return meassage;
	}
	public void setMeassage(String meassage) {
		this.meassage = meassage;
	}
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
	
	
}
