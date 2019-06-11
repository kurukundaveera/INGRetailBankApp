package com.hcl.ing.retailbank.app.dto;

import java.io.Serializable;

import com.hcl.ing.retailbank.app.util.ApiResponse;

public class LoginResponse  extends  ApiResponse  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Long accounNumber;
	
	public Long getAccounNumber() {
		return accounNumber;
	}
	public void setAccounNumber(Long accounNumber) {
		this.accounNumber = accounNumber;
	}
	
	

}
