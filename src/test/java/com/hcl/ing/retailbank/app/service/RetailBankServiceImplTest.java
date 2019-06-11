package com.hcl.ing.retailbank.app.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.ing.retailbank.app.dto.AccountSummaryResponse;
import com.hcl.ing.retailbank.app.dto.FundTransferRequest;
import com.hcl.ing.retailbank.app.dto.FundTransferResponse;
import com.hcl.ing.retailbank.app.dto.TransactionDetails;
import com.hcl.ing.retailbank.app.dto.TransactionDetailsResponse;
import com.hcl.ing.retailbank.app.entity.AccountSummary;
import com.hcl.ing.retailbank.app.entity.TransactionHistory;
import com.hcl.ing.retailbank.app.repository.AccountSummaryRepository;
import com.hcl.ing.retailbank.app.repository.TransactionHistoryRepository;


@RunWith(MockitoJUnitRunner.class)
public class RetailBankServiceImplTest {
	
	@Mock
	private AccountSummaryRepository accountSummaryRepository;
	
	@Mock
	private TransactionHistoryRepository transactionHistoryRepository;
	
	@InjectMocks
	private RetailBankServiceImpl retailBankService;

	
	@Test
	public void fundTransferTest() {
		
		FundTransferRequest request=new FundTransferRequest();
		request.setToAccount(2L);
		request.setFromAccount(1L);
		request.setAmount(2000.0);
		request.setComments("fund transfer");
		
		AccountSummary  fromSummary=new AccountSummary();
		fromSummary.setAccountNo(1L);
		fromSummary.setAccountName("uday");
		fromSummary.setAccountType("savings");
		fromSummary.setAddress("bangalore");
		fromSummary.setClosingBalance(10000.0);
		fromSummary.setEmail("uday@hcl.com");
		fromSummary.setUserId(1L);
		
		
		AccountSummary  toSummary=new AccountSummary();
		toSummary.setAccountNo(2L);
		toSummary.setAccountName("kumar");
		toSummary.setAccountType("savings");
		toSummary.setAddress("bangalore");
		toSummary.setClosingBalance(12000.0);
		toSummary.setEmail("kumar@hcl.com");
		toSummary.setUserId(2L);
		
		when(accountSummaryRepository.findByAccountNo(1L)).thenReturn(fromSummary);
		when(accountSummaryRepository.findByAccountNo(2L)).thenReturn(toSummary);
		
		ResponseEntity<FundTransferResponse> response = retailBankService.fundTransfer(request);
		if(response!=null) {
			FundTransferResponse body = response.getBody();
			Integer statusCode = body.getStatusCode();
			Double code=Double.valueOf(""+statusCode);
			Double act=200.0;
			assertEquals(code, act);
			/*
			 * String actual="Your funds transferred successfully ...!"; String
			 * expected=body.getMessage(); assertEquals(expected, actual);
			 */
			
		}
		
		
	}
	
	@Test
	public void accountsummary() {
		
		Optional<AccountSummary> optional=Optional.empty();
	
		AccountSummary accountSummary=new AccountSummary(); 
		accountSummary.setAccountNo(1L);
		accountSummary.setAccountType("saving");
		accountSummary.setClosingBalance(10000.0);
		Date createDt=new Date();
		accountSummary.setCreateDt(createDt);
		
		optional=Optional.of(accountSummary);
		
		when(accountSummaryRepository.findById(1L)).thenReturn(optional);
		/*
		 * AccountSummaryResponse accountSummaryResponse=new AccountSummaryResponse();
		 * accountSummaryResponse.setAccountNo(1L);
		 * accountSummaryResponse.setAccountType("saving");
		 * accountSummaryResponse.setClosingBalance(10000.0);
		 * accountSummaryResponse.setCreateDt(createDt);
		 */
		
		ResponseEntity<AccountSummaryResponse> response=retailBankService.accountSummary(1L);
		assertEquals(200, response.getStatusCodeValue());
			
		}
	
	@Test
	public void findTransactionByIdTest() {
		
		TransactionHistory transaction=new TransactionHistory();
		transaction.setClosingBalance(20000.0);
		transaction.setComments("added");
		transaction.setCreateDt(new Date());
		transaction.setFromAccountNo(1L);
		transaction.setToAccountNo(2L);
		transaction.setTransactionId(23L);
		transaction.setTransactionType("saving");
		
		
		when(transactionHistoryRepository.findByTransactionId(23L)).thenReturn(transaction);
		ResponseEntity<TransactionDetailsResponse> responseEntity = retailBankService.findTransactionById(23L);
		
		if(responseEntity!=null) {
			TransactionDetailsResponse body = responseEntity.getBody();
			TransactionDetails transactionDetails = body.getTransactionDetails();
			String comments = transactionDetails.getComments();
			String actual="added";
			assertEquals(comments, actual);
		}
		
		
		
		
		}
		
		
	}
