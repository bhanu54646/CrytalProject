package org.example.repository;

import org.example.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    @Query("select p from AccountEntity p where p.accountNo=?1")
    List<AccountEntity> getAccountByAccountNo(String accountNo);

    @Query("select p from AccountEntity p where p.accountHolderName=?1")
    List<AccountEntity> getAllAccount(String accountHolderName);

    @Modifying
    @Transactional
    @Query("UPDATE AccountEntity p SET p.active = false WHERE p.branch = ?1")
    int updateBranchStatus(String branch);

    @Transactional
    @Query("select  p from AccountEntity p where p.accountNo=?1")
    AccountEntity getStatusAndHolderDetails(String accountNo);

    @Modifying
    @Transactional
    @Query("delete from   AccountEntity  p where p.accountNo in :accountNo")
    int deleteAccounts(@Param("accountNo") List<String> accountNo);

    @Query("select count(p) > 0 from AccountEntity p where p.accountNo=?1")
    boolean existByAccountNo(String accountNo);

    @Query("select p from AccountEntity p where p.accountHolderName=?1")
    public List<AccountEntity> getAllAcountsofPerson(String accountHolderName);

    @Query("select p from AccountEntity p where p.active=true")
    public List<AccountEntity> getAllActiveAccount();

    @Query("select p from AccountEntity p where p.accountNo in :accountNos")
    public List<AccountEntity> getAccountDetails(@Param("accountNos") List<String> accountNos);

    @Query("select p from AccountEntity p  order by p.accountBalance desc")
    public  List<AccountEntity> getTopNaccounts();

//    @Transactional
//    @Modifying
//    @Query("Update AccountEntity  p set p.accountBalance where acciunton")
//    int updateAccountBalance(double balance);

}
