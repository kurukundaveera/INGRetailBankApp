package com.hcl.ing.retailbank.app.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter @Getter
public class LoginRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	
	

}
