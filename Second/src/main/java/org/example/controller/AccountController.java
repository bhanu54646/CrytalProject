package org.example.controller;

import org.example.dto.*;
import org.example.model.AccountEntity;
import org.example.model.AccountTransaction;
import org.example.service.AccountServciceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/Second")
@RestController
public class AccountController {

    @Autowired
    AccountServciceImpl accountServcice;

    @PostMapping("/Credit/Amount")
    public AccountEntity CreditAmountIntoAccount(@RequestBody AccountEntity account) {
        System.out.println("reached controller");
        return accountServcice.creditAmountIntoAccount(account);

    }

    @PostMapping("/calculate/rateofinterest")
    public List<AccountDto> CalculateQuaterlyRateofInterestandCredit(@RequestBody AccountEntity account) {

        System.out.println(account.getAccountNo());
        return accountServcice.CalculateQuaterlyRateofInterestandCredit(account);

    }

    @PostMapping("/GetAccount/return/interestforall")
    public AccountDto getAllaccountRelatedToPersonTOcaluculateiNTERST(@RequestBody Map<String, String> request) {

        System.out.println(request);
        // String accountHolderName = request.get("accountHolderName");
        return accountServcice.getAllaccountRelatedToPersonTOcaluculateiNTERST(request);
    }


    @PostMapping("/deactiveAccount")
    public List<AccountDto> deActiveAllAccountofPerson(@RequestBody AccountEntity account) {

        return accountServcice.deActiveAllAccountofPerson(account);

    }

    @GetMapping("/getStatusAndHoldersName/{accountNo}")
    public AcccountEntityResponse getStatusAndHolderDetails(@PathVariable String accountNo) {

        System.out.println(accountNo);
        return accountServcice.getStatusAndHolderDetails(accountNo);
    }


    @PostMapping("/delete/accounts/fromAccountentity")
    public List<AccountDeleteResponse> deleteAccounts(@RequestBody List<String> accountNo) {

        System.out.println(accountNo);
        return accountServcice.deleteAccounts(accountNo);

    }

    @GetMapping("/get/all-accounts/{accountHolderName}")
    public List<String> getAccountsByHoldersName(@PathVariable String accountHolderName) {

        return accountServcice.getAccountsByHoldersName(accountHolderName);
    }

    @GetMapping("/get-active/accounts")
    public Map<String, String> getActiveAccounts() {
        return accountServcice.getActiveAccounts();

    }

    @PostMapping("/get/accounts/balance")
    public Map<String, Double> getAccountBalance(@RequestBody List<String> accountNos) {
        return accountServcice.getAccountBalance(accountNos);

    }

    //have to modify this api
    @GetMapping("get/min-Max/details")
    public List<AccountEntity> getMinandMaxBalancewithHoldersName() {
        return accountServcice.getMinandMaxBalancewithHoldersName();
    }


    @GetMapping("get/TopN/accounts")
    public List<AccountEntity> getTopNaccountswithBalance() {
        return accountServcice.getTopNaccountswithBalance();
    }

    @PostMapping("create/transaction/between/accounts")
    public TransactionResponse transactionBetweenTwoAccounts(@RequestBody TransactionRequest request) {
        System.out.println(request);
        return accountServcice.transactionBetweenTwoAccounts(request);
    }

    @GetMapping("/get/Transaction/details/{accountNo}")
    public List<AccountTransaction> getTransactinByAccountNo(@PathVariable String accountNo) {

        return accountServcice.getTransactinByAccountNo(accountNo);

    }

    @PostMapping("get/Transaction/History")
    public TransactionHistoryResponse getTransctionBetweendates(@RequestBody TransactionHistoryRequest request) {

        System.out.println(request);
        return accountServcice.getTransctionBetweendates(request);
    }

    @PostMapping("/verfiy-account-details")
    public VerifyAccountIdentityResponse VerfiyAccountIdentiry(@RequestBody VerifyAccountHolderIdentity request) {
        System.out.println(request);
        return accountServcice.VerfiyAccountIdentity(request);

    }


    @PostMapping("/verfiy-account-details/UsingMap")
    public Map<String, Object> VerifyAccountIdentityResponseusing(@RequestBody VerifyAccountHolderIdentity request) {
        System.out.println(request);
        return accountServcice.verfiyidentityusingMap(request);

    }

    @PostMapping("/calcuateMonthlyExpense/account")
    public Map<String,Object> calculateMontlyexpense(@RequestBody MonthlyExpenseRequst request) {
        System.out.println(request);

        return accountServcice.calculateMontlyexpense(request);


    }
}
