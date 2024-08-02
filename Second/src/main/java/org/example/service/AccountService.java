package org.example.service;

import org.example.dto.*;
import org.example.model.AccountEntity;
import org.example.model.AccountTransaction;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AccountService {

    public AccountEntity creditAmountIntoAccount(AccountEntity account);

    public List<AccountDto> CalculateQuaterlyRateofInterestandCredit(AccountEntity accountno);

    public AccountDto getAllaccountRelatedToPersonTOcaluculateiNTERST(Map<String, String> accountHolderName);

    public List<AccountDto> deActiveAllAccountofPerson(AccountEntity account);

    public AcccountEntityResponse getStatusAndHolderDetails(String accountNo);

    public List<AccountDeleteResponse> deleteAccounts(List<String> accountNo);

    public List<String> getAccountsByHoldersName(String accountHolderName);

    public Map<String, String> getActiveAccounts();

    public Map<String, Double> getAccountBalance(List<String> accountNos);

    public List<AccountEntity> getMinandMaxBalancewithHoldersName();

    public List<AccountEntity> getTopNaccountswithBalance();

    public TransactionResponse transactionBetweenTwoAccounts(TransactionRequest request);

    public List<AccountTransaction> getTransactinByAccountNo(String accountNo);

    public TransactionHistoryResponse getTransctionBetweendates(TransactionHistoryRequest request);

    public VerifyAccountIdentityResponse VerfiyAccountIdentity(VerifyAccountHolderIdentity request);

    public  Map<String,Object> verfiyidentityusingMap(VerifyAccountHolderIdentity request);

    public Map<String,Object> calculateMontlyexpense(MonthlyExpenseRequst  request);
}
