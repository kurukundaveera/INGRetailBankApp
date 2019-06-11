package com.hcl.ing.retailbank.app.dto;

import java.io.Serializable;

import com.hcl.ing.retailbank.app.util.ApiResponse;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class LoginResponse  extends  ApiResponse  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Long accounNumber;

}
