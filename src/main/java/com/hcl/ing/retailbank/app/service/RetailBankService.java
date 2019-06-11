package com.hcl.ing.retailbank.app.service;

import org.springframework.http.ResponseEntity;

import com.hcl.ing.retailbank.app.dto.AccountSummaryResponse;

public interface RetailBankService {

	ResponseEntity<AccountSummaryResponse> accountSummary(Long acccountNumber);

}
