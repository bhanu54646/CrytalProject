package org.example.repository;

import org.example.model.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Integer> {


    @Query("Select p from AccountTransaction p where p.accountNo=?1")
    public List<AccountTransaction> findTransactions(String accountNo);


    @Query("Select p from AccountTransaction p where p.accountNo=:accountNo and p.accountTxnFromDate>=:accountTxnFromDate and p.accountTxnToDate<=:accountTxnToDate")
    public List<AccountTransaction> findTransactionBetweenDates(@Param("accountNo") String accountNo, @Param("accountTxnFromDate") String accountTxnFromDate,@Param("accountTxnToDate") String accountTxnToDate);



}
