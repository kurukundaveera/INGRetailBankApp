package com.hcl.ing.retailbank.app.service;

import com.hcl.ing.retailbank.app.dto.LoginRequest;
import com.hcl.ing.retailbank.app.dto.LoginResponse;

public interface LoginService {
	
	/**
	 * This API  For Login to USER
	 * @param request
	 * @return
	 */
	public LoginResponse login(LoginRequest request);

}
