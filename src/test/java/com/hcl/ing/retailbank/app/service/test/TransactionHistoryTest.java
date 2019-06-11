/*
package com.hcl.ing.retailbank.app.service.test;

 * package com.hcl.ing.retailbank.app;
 * 
 * import static org.assertj.core.api.Assertions.assertThat; import static
 * org.mockito.Mockito.when;
 * 
 * import java.util.ArrayList; import java.util.Date; import java.util.List;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.junit.MockitoJUnitRunner;
 * 
 * import com.hcl.ing.retailbank.app.entity.TransactionHistory; import
 * com.hcl.ing.retailbank.app.repository.TransactionHistoryRepository; import
 * com.hcl.ing.retailbank.app.service.RetailBankServiceImpl;
 * 
 * @RunWith(MockitoJUnitRunner.class) public class TransactionHistoryTest {
 * 
 * @Mock private TransactionHistoryRepository transactionHistoryRepository;
 * 
 * @InjectMocks private RetailBankServiceImpl retailBankServiceImpl;
 * 
 * @Test public void viewLastTenTransactionDetailsTest() { TransactionHistory
 * history=new TransactionHistory(); history.setComments("transfer to friend");
 * history.setClosingBalance(2000.5); history.setCreateDt(new Date());
 * history.setFromAccountNo(11L); history.setToAccountNo(22L);
 * history.setTransactionId(123L); history.setTransactionType("DEBIT");
 * 
 * List<TransactionHistory> list=new ArrayList<TransactionHistory>();
 * list.add(history);
 * 
 * TransactionResponse response =null; response.setList(list);
 * response.setMessage("SUCCESS"); response.setStatusCode(200);
 * 
 * 
 * when(transactionHistoryRepository.findAll()).thenReturn(list);
 * assertThat(retailBankServiceImpl.viewLastTenTransactionDetails(11L)).isNull()
 * ; //assertEquals(1, retailBankService.viewLastTenTransactionDetails(11L)); }
 * 
 * }
 */