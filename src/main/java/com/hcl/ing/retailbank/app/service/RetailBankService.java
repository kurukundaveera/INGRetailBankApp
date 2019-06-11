package com.hcl.ing.retailbank.app.service;

import org.springframework.http.ResponseEntity;

import com.hcl.ing.retailbank.app.dto.FundTransferRequest;
import com.hcl.ing.retailbank.app.dto.FundTransferResponse;

public interface RetailBankService {
	
	public ResponseEntity<FundTransferResponse> fundTransfer(FundTransferRequest request);

}
