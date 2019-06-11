package com.hcl.ing.retailbank.app.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.retailbank.app.dto.FundTransferRequest;
import com.hcl.ing.retailbank.app.dto.FundTransferResponse;
import com.hcl.ing.retailbank.app.service.RetailBankService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/retailbank")
@CrossOrigin
public class RetailBankController {
	
	private static final Logger logger=LogManager.getLogger(RetailBankController.class);
	
	@Autowired
	private RetailBankService retailBankService;
	
	@PostMapping("/fundTransfer")
	@ApiOperation(notes = "Transfer funds from one account to another account",nickname = "transferFunds", value = "transferring funds")
	public ResponseEntity<FundTransferResponse> transferFunds(@Valid @RequestBody FundTransferRequest request){
		logger.info(this.getClass().getName()+" transferFunds is calling ...!");
		if(request!=null) {
			if(logger.isDebugEnabled()) {
			logger.debug("FundTransferRequest object is :: "+request.toString());
			}
		}
		return retailBankService.fundTransfer(request);
	}
	

}
