package com.hcl.ing.retailbank.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.hcl.ing.retailbank.app.entity.TransactionHistory;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data @Getter @Setter @ToString
public class TransactionResponse {
	
	List<TransactionHistory> list=new ArrayList<TransactionHistory>();
	String message;
	Integer statusCode;
	
	
}
