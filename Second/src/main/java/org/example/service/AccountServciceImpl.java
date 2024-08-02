package org.example.service;

import org.example.dto.*;
import org.example.model.AccountEntity;
import org.example.model.AccountTransaction;
import org.example.repository.AccountRepository;
import org.example.repository.AccountTransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class AccountServciceImpl implements AccountService {

    private final Logger logger = LoggerFactory.getLogger(AccountServciceImpl.class);

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountTransactionRepository accountTransactionRepository;


    @Override
    public AccountEntity creditAmountIntoAccount(AccountEntity account) {

        System.out.println("Reached service");

        AccountEntity acc = new AccountEntity();
        System.out.println(acc);
        try {

            acc = accountRepository.save(account);
            System.out.println(acc);
        } catch (Exception e) {
            System.out.println(e);
        }

        return acc;
    }

    @Override
    public List<AccountDto> CalculateQuaterlyRateofInterestandCredit(AccountEntity accountno) {

        double balanceAfterInterestCredit = 0;
        double interest = 2.7;
        int time = 3;
        double calucatedinterest = 0;

        System.out.println(interest);
        System.out.println(balanceAfterInterestCredit);
        System.out.println(time);
        System.out.println(calucatedinterest);

        List<AccountDto> l = new ArrayList<>();
        AccountDto dto = new AccountDto();
        System.out.println(dto);

        System.out.println(l.size());

        List<AccountEntity> ac = accountRepository.getAccountByAccountNo(accountno.getAccountNo());

        for (AccountEntity s : ac) {
            s.getAccountBalance();

            calucatedinterest = (s.getAccountBalance() * interest * time) / 100;

            System.out.println(calucatedinterest);

            balanceAfterInterestCredit = calucatedinterest + s.getAccountBalance();

            s.setAccountBalance(balanceAfterInterestCredit);

            System.out.println(balanceAfterInterestCredit);

//            dto.setAccountNo(s.getAccountNo());
//            dto.setBranch(s.getBranch());
//            dto.setActive(s.isActive());
//            dto.setAccountHolderName(s.getAccountHolderName());
//            dto.setAccountBalance(balanceAfterInterestCredit);
//            dto.setAccountHolderPhoneNo(s.getAccountHolderPhoneNo());
            l.add(dto);
            System.out.println(dto);
            accountRepository.save(s);
        }

        System.out.println(l);

        return l;
    }


    @Override
    public AccountDto getAllaccountRelatedToPersonTOcaluculateiNTERST(Map<String, String> accountHolderName) {

        double balanceAfterInterestCredit = 0;
        double interest = 2.7;
        int time = 3;
        double calucatedinterest = 0;
        String name = accountHolderName.get("accountHolderName");
        System.out.println(name);

        List<AccountEntity> a = accountRepository.getAllAccount(name);
        System.out.println(a);


        AccountDto dto = new AccountDto();
        System.out.println(dto);


        if (a.size() > 0) {
            for (AccountEntity ac : a) {
                calucatedinterest = (ac.getAccountBalance() * interest * time) / 100;
                balanceAfterInterestCredit = ac.getAccountBalance() + calucatedinterest;
                ac.setAccountBalance(balanceAfterInterestCredit);
                accountRepository.save(ac);
            }
            dto.setMessage("Account details Updated Successfully");
            dto.setStatusCode("200");
            dto.setAccount(a);
            return dto;

        } else {
            dto.setMessage("Account doesn't exist");
            dto.setStatusCode("500");
            dto.setAccount(a);
            return dto;
        }
    }


    @Override
    public List<AccountDto> deActiveAllAccountofPerson(AccountEntity account) {
        List<AccountDto> Dtolist = new ArrayList<>();

        AccountDto dto = new AccountDto();

        int b = 0;
        String name = account.getAccountHolderName();
        List<AccountEntity> a = accountRepository.getAllAccount(name);
        if (a.size() > 0) {
            for (AccountEntity ac : a) {
                String branch = ac.getBranch();
                System.out.println(branch);
                if (branch != null && branch.equalsIgnoreCase("Thane")) {
                    System.out.println(ac.isActive());
                    b = accountRepository.updateBranchStatus(branch);

                }
            }
            List<AccountEntity> d = accountRepository.getAllAccount(name);

            dto.setMessage("updated");
            dto.setStatusCode("200");
            dto.setAccount(d);
            Dtolist.add(dto);
            return Dtolist;
        } else {

            dto.setMessage("No account details found");
            dto.setStatusCode("404");
            dto.setAccount(a);
            Dtolist.add(dto);
            return Dtolist;
        }
    }

    @Override
    public AcccountEntityResponse getStatusAndHolderDetails(String accountNo) {

        AccountEntity a = accountRepository.getStatusAndHolderDetails(accountNo);
        System.out.println(a);
        boolean status = a.isActive();
        String name = a.getAccountHolderName();

        AcccountEntityResponse at = new AcccountEntityResponse();
        System.out.println(at);
        at.setActive(status);
        at.setAccountHolderName(name);

        System.out.println(at);


        return at;
    }


    @Override
    public List<AccountDeleteResponse> deleteAccounts(List<String> accountNo) {
        logger.info("logging request for" + accountNo);
        System.out.println(accountNo.size());

        List<AccountDeleteResponse> abb = new ArrayList<>();
        //  System.out.println(acc);
        try {
            // int count = accountRepository.deleteAccounts(accountNo);
            List<String> existaccount = new ArrayList<>();
            List<String> notExistaccount = new ArrayList<>();
            for (String accno : accountNo) {
                if (accountRepository.existByAccountNo(accno)) {
                    boolean status = accountRepository.existByAccountNo(accno);
                    accountRepository.deleteAccounts(accountNo);
                    System.out.println(status);
                    existaccount.add(accno);
                } else {
                    notExistaccount.add(accno);
                }
            }
            System.out.println(existaccount);
            System.out.println(notExistaccount);
            //  accountRepository.exis
            if (!existaccount.isEmpty()) {
                AccountDeleteResponse acc = new AccountDeleteResponse();
                System.out.println("inside the existaccount");
                acc.setStatusMessage("Records Deleted Successfully");
                acc.setStatusCode("200");
                acc.setAccountNo(existaccount);
                abb.add(acc);

            }
            if (!notExistaccount.isEmpty()) {
                AccountDeleteResponse acc = new AccountDeleteResponse();
                acc.setStatusMessage("Account details not found");
                acc.setStatusCode("404");
                acc.setAccountNo(notExistaccount);
                abb.add(acc);

            }


            System.out.println(abb);

//            if (count > 0) {
//
//                acc.setStatusMessage("Account Nos successfully deleted");
//                acc.setStatusCode("200");
//                acc.setAccountNo(accountNo);
//                return acc;
//            } else {
//
//                acc.setStatusMessage("Account Details Not Found");
//                acc.setStatusCode("404");
//                acc.setAccountNo(accountNo);
//                return acc;
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.error("Exception occurred while deleting accounts: {}", e.getMessage(), e);

        }
        return abb;
    }


    @Override
    public List<String> getAccountsByHoldersName(String accountHolderName) {
        List<String> accountNos = new ArrayList<>();
        System.out.println(accountHolderName);
        List<AccountEntity> ac = accountRepository.getAllAcountsofPerson(accountHolderName);
        for (AccountEntity a : ac) {
            String account = a.getAccountNo();
            String name = a.getAccountHolderName();
            accountNos.add(account);
        }

        System.out.println(accountNos);
        return accountNos;
    }


    @Override
    public Map<String, String> getActiveAccounts() {
        List<AccountEntity> accounts = accountRepository.getAllActiveAccount();
        Map<String, String> details = new HashMap<>();

        if (!accounts.isEmpty()) {
            System.out.println("account fectched are" + accounts);


            for (AccountEntity ac : accounts) {
                String accountno = ac.getAccountNo();
                Boolean status = ac.isActive();
                details.put(accountno, "is active");
            }

            System.out.println(details);

            return details;

        }
        return details;
    }

    @Override
    public Map<String, Double> getAccountBalance(List<String> accountNos) {
        Map<String, Double> map = new HashMap<>();
        System.out.println(map);
        System.out.println(accountNos);
        //  List<Map<String,String>> a=new ArrayList<>();
        List<AccountEntity> detailsofaccount = accountRepository.getAccountDetails(accountNos);

        System.out.println(detailsofaccount);

        for (AccountEntity account : detailsofaccount) {

            map.put(account.getAccountNo(), account.getAccountBalance());
        }
        return map;
    }

    @Override
    public List<AccountEntity> getMinandMaxBalancewithHoldersName() {
        List<AccountEntity> accounts = accountRepository.findAll();

        Collections.sort(accounts);

        return accounts;
    }

    @Override
    public List<AccountEntity> getTopNaccountswithBalance() {
        List<AccountEntity> accounts = accountRepository.getTopNaccounts();
        return accounts;

    }

    @Override
    public TransactionResponse transactionBetweenTwoAccounts(TransactionRequest request) {
        String currentFormatedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        TransactionResponse tras = new TransactionResponse();
        System.out.println(tras);
        UpdatedDetails s = new UpdatedDetails();
        System.out.println(s);
        List<UpdatedDetails> listofUpdtated = new ArrayList<>();
        System.out.println(listofUpdtated);
        try {
            System.out.println(request.getFromAccountNo());
            AccountEntity accountFromDetail = accountRepository.getStatusAndHolderDetails(request.getFromAccountNo());
            System.out.println(accountFromDetail);
            System.out.println("to account no" + "  " + request.getToAccontNo());
            AccountEntity accountToDetail = accountRepository.getStatusAndHolderDetails(request.getToAccontNo());
            System.out.println("data fetch from to account" + accountToDetail);
            if (accountFromDetail != null && accountToDetail != null) {
                if (accountFromDetail.getAccountBalance() < request.getAmount()) {
                    tras.setStatusMessage("acccount" + " " + accountFromDetail.getAccountNo() + " " + "does not have sufficient balance to do transaction please check the accountbalance is " + " " + accountFromDetail.getAccountBalance());
                    tras.setStatusCode("400");
                    tras.setDe(listofUpdtated);
                    return tras;
                }
                double finalBalnceFromaccount = accountFromDetail.getAccountBalance() - request.getAmount();
                double finalToBalance = accountToDetail.getAccountBalance() + request.getAmount();
                System.out.println(finalBalnceFromaccount);
                System.out.println(finalToBalance);
                accountFromDetail.setAccountBalance(finalBalnceFromaccount);
                accountToDetail.setAccountBalance(finalToBalance);
                accountRepository.save(accountFromDetail);
                accountRepository.save(accountToDetail);
                //Maintaining TRANSACTION HISTORY
                AccountTransaction historyFrom = new AccountTransaction();
                AccountTransaction historyTo = new AccountTransaction();
                System.out.println("HISTORY INITIALLY :" + " " + historyFrom);
                System.out.println("HISTORY INITIALLY :" + " " + historyTo);
                historyFrom.setAccountNo(request.getFromAccountNo());
                historyFrom.setDebit(request.getAmount());
                historyFrom.setBalance(finalBalnceFromaccount);
                historyFrom.setAccountTxnFromDate(currentFormatedDate);
                historyFrom.setAccountTxnToDate(currentFormatedDate);
                historyTo.setAccountNo(request.getToAccontNo());
                historyTo.setCredit(request.getAmount());
                historyTo.setBalance(finalToBalance);
                historyTo.setAccountTxnFromDate(currentFormatedDate);
                historyTo.setAccountTxnToDate(currentFormatedDate);
                accountTransactionRepository.save(historyFrom);
                accountTransactionRepository.save(historyTo);
                //END TO Maintaining Transaction History
                s.setFromAccountNo(request.getFromAccountNo());
                s.setToAccontNo(request.getToAccontNo());
                s.setBlanceFromaccount(accountFromDetail.getAccountBalance());
                s.setBalanceToaccount(accountToDetail.getAccountBalance());
                listofUpdtated.add(s);
                tras.setStatusMessage("Transaction done successfully");
                tras.setStatusCode("200");
                tras.setDe(listofUpdtated);
                return tras;
            } else {
                tras.setStatusMessage("Please check the account details are incorrect");
                tras.setStatusCode("404!");
                s.setFromAccountNo(request.getFromAccountNo());
                s.setToAccontNo(request.getToAccontNo());
                s.setBlanceFromaccount(0);
                s.setBalanceToaccount(0);
                listofUpdtated.add(s);
                tras.setDe(listofUpdtated);
                return tras;
            }
        } catch (Exception e) {
            tras.setStatusMessage(e.getMessage());
            tras.setStatusCode("500");
            tras.setDe(listofUpdtated);
            return tras;
        }
    }


    @Override
    public List<AccountTransaction> getTransactinByAccountNo(String accountNo) {

        List<AccountTransaction> a = accountTransactionRepository.findTransactions(accountNo);

        return a;
    }

    public TransactionHistoryResponse getTransctionBetweendates(TransactionHistoryRequest request) {

        System.out.println(request.getAccountNo());
        TransactionHistoryResponse his = new TransactionHistoryResponse();
        List<AccountTransaction> trasaction = new ArrayList<>();
        try {
            List<AccountEntity> accontdetails = accountRepository.getAccountByAccountNo(request.getAccountNo());
            System.out.println(accontdetails);

            if (!accontdetails.isEmpty()) {

                trasaction = accountTransactionRepository.findTransactionBetweenDates(request.getAccountNo(), request.getFromDate(), request.getToDate());
                System.out.println(his);
                his.setStatusCode("L2005");
                his.setStatusMessage("Transaction Fetched succesfully for" + " " + request.getAccountNo());
                his.setTransactions(trasaction);
                return his;
            } else {
                System.out.println(his);
                his.setStatusCode("404!");
                his.setStatusMessage("No account details found");
                his.setTransactions(trasaction);
                return his;
            }
        } catch (Exception e) {
            his.setStatusCode("500");
            his.setStatusMessage("exception-occured" + e.getMessage());
            his.setTransactions(trasaction);
            return his;
        }
    }

    @Override
    public VerifyAccountIdentityResponse VerfiyAccountIdentity(VerifyAccountHolderIdentity request) {
        VerifyAccountIdentityResponse res = new VerifyAccountIdentityResponse();
        List<AccountEntity> accounts = new ArrayList<>();
        AccountEntity newaccount = new AccountEntity();
        try {


            List<AccountEntity> account = accountRepository.getAccountByAccountNo(request.getAccountNo());
            if (!account.isEmpty()) {
                for (AccountEntity ac : account) {
                    if (ac.getAccountHolderName().equalsIgnoreCase(request.getHoldersName()) && ac.getAccountHolderPhoneNo().equals(request.getPhoneNo())) {

                        res.setStatusMessage("account details verfied and fetched succesfully for" + " " + request.getAccountNo());
                        res.setStatusCode("200");
                        res.setAccountDetails(account);
                        return res;
                    } else if (!request.getHoldersName().equals(ac.getAccountHolderName()) || !request.getPhoneNo().equals(ac.getAccountHolderPhoneNo())) {
                        res.setStatusCode("404");
                        res.setStatusMessage("Not an verfied user please check holder name  and phone no for AccountNo " + " " + request.getAccountNo());
                        newaccount.setAccountNo(request.getAccountNo());
                        newaccount.setAccountHolderName(request.getHoldersName());
                        newaccount.setAccountBalance(0);
                        newaccount.setBranch("");
                        newaccount.setAccountHolderPhoneNo(request.getPhoneNo());
                        accounts.add(newaccount);
                        res.setAccountDetails(accounts);
                        return res;
                    }
                }
            } else {
                res.setStatusMessage("AccountNo doesNotExist" + " " + request.getAccountNo());
                res.setStatusCode("404");
                res.setAccountDetails(account);
                return res;
            }
        } catch (Exception e) {

            res.setStatusMessage("exception occured" + " " + e.getMessage());
            res.setStatusCode("500");
            res.setAccountDetails(accounts);
            return res;
        }

        return res;
    }

    @Override
    public Map<String, Object> verfiyidentityusingMap(VerifyAccountHolderIdentity request) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(map.size());

        List<AccountEntity> accounts = new ArrayList<>();
        AccountEntity newaccount = new AccountEntity();
        try {


            List<AccountEntity> account = accountRepository.getAccountByAccountNo(request.getAccountNo());
            if (!account.isEmpty()) {
                for (AccountEntity ac : account) {
                    if (ac.getAccountHolderName().equalsIgnoreCase(request.getHoldersName()) && ac.getAccountHolderPhoneNo().equals(request.getPhoneNo())) {

                        map.put("statusMessage", "accountDetails Verfied and fetched succesfully for " + " " + request.getAccountNo());
                        map.put("statuscode", "200");
                        map.put("aacountDetails", account);
                        return map;
                    } else if (!request.getHoldersName().equals(ac.getAccountHolderName()) || !request.getPhoneNo().equals(ac.getAccountHolderPhoneNo())) {
                        map.put("statusMessage", "accountDetails not  verified please check holdername and phone for accountNo" + " " + request.getAccountNo());
                        map.put("statusCode", "404");
                        map.put("accountDetails", accounts);

                    }
                }
            } else {
                map.put("statusMessage", "AccountNo doesNotExist for accountNO" + " " + request.getAccountNo());
                map.put("statusCode", "404");
                map.put("accountDetails", account);
                return map;
            }
        } catch (Exception e) {
            map.put("statusMessage", "exception occured" + " " + e.getMessage());
            map.put("statusCode", "500");
            map.put("accountDetails", accounts);
            return map;
        }

        return map;

    }

    @Override
    public Map<String, Object> calculateMontlyexpense(MonthlyExpenseRequst request) {
        Map<String, Object> map = new HashMap<>();
        double totalexpenses = 0;
        System.out.println(totalexpenses);

        List<AccountTransaction> a = accountTransactionRepository.findTransactionBetweenDates(request.getAccountNo(), request.getFromDate(), request.getToDate());
        if (!a.isEmpty()) {
            for (AccountTransaction ac : a) {
                totalexpenses = totalexpenses + ac.getDebit();
            }

            map.put("StatusMessage", "expenseses fetched successfully from" + " " + request.getFromDate() + " " + request.getToDate());
            map.put("StatusCode", "200");
            map.put("expenses", totalexpenses);

            return map;

        } else {
            map.put("StatusMessage", "No accountNoFound");
            map.put("statusCode", "404");

            return map;
        }

    }
}