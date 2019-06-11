package com.hcl.ing.retailbank.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.retailbank.app.dto.LoginRequest;
import com.hcl.ing.retailbank.app.dto.LoginResponse;
import com.hcl.ing.retailbank.app.service.LoginService;

@RestController
@RequestMapping("/retailbank")
@CrossOrigin(origins="*")
public class RetailBankController {
	
	@Autowired
	LoginService loginService;
	
	private static final Logger logger=LogManager.getLogger(RetailBankController.class);
	
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {
		logger.info("Enter into login controller");
		return loginService.login(request);
		
		
		
	}
	

}
