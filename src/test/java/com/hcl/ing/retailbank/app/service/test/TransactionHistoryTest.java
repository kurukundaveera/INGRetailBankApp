
package com.hcl.ing.retailbank.app.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static
org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import
org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.retailbank.app.dto.TransactionResponse;
import com.hcl.ing.retailbank.app.entity.TransactionHistory;
import
com.hcl.ing.retailbank.app.repository.TransactionHistoryRepository;
import
com.hcl.ing.retailbank.app.service.RetailBankServiceImpl;

@RunWith(MockitoJUnitRunner.class) 
public class TransactionHistoryTest {

	@Mock 
	private TransactionHistoryRepository transactionHistoryRepository;

	@InjectMocks 
	private RetailBankServiceImpl retailBankServiceImpl;

	@Test 
	public void viewLastTenTransactionDetailsTest() { 
		TransactionHistory history=new TransactionHistory();
		history.setTransactionId(1L);
		history.setComments("transfer to friend");
		history.setClosingBalance(2000.5); 
		history.setCreateDt(new Date());
		history.setFromAccountNo(11L);
		history.setToAccountNo(22L);
		history.setTransactionId(123L);
		history.setTransactionType("DEBIT");

		List<TransactionHistory> list=new ArrayList<TransactionHistory>();
		list.add(history);

		TransactionResponse response =new TransactionResponse(); 
		response.setList(list);
		
		when(transactionHistoryRepository.findAll(11L)).thenReturn(list);
		assertThat(retailBankServiceImpl.viewLastTenTransactionDetails(11L)).isNotNull();
		

	}
}