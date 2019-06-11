package com.hcl.ing.retailbank.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.hcl.ing.retailbank.app.entity.TransactionHistory;


public class TransactionResponse {
	
	List<TransactionHistory> list=new ArrayList<TransactionHistory>();
	String message;
	Integer statusCode;
	public List<TransactionHistory> getList() {
		return list;
	}
	public void setList(List<TransactionHistory> list) {
		this.list = list;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
