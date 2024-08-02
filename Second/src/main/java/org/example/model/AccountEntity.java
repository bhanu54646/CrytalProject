package org.example.model;


import javax.persistence.*;

@Entity
@Table(name = "account_entity")
public class AccountEntity implements   Comparable<AccountEntity>{

    @Id
    @Column(name = "account_no")
    String accountNo;
    @Column(name = "account_Holder_name")
    String accountHolderName;
    @Column(name = "branch")
    String branch;
    @Column(name = "active")
    boolean active;
    @Column(name = "account_holer_name")
    String accountHolderPhoneNo;
    @Column(name = "account_balance")
    double accountBalance;


    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAccountHolderPhoneNo() {
        return accountHolderPhoneNo;
    }

    public void setAccountHolderPhoneNo(String accountHolderPhoneNo) {
        this.accountHolderPhoneNo = accountHolderPhoneNo;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "accountNo='" + accountNo + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", branch='" + branch + '\'' +
                ", active=" + active +
                ", accountHolderPhoneNo='" + accountHolderPhoneNo + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }

    public AccountEntity(double accountBalance, String accountHolderPhoneNo, boolean active, String branch, String accountHolderName, String accountNo) {
        this.accountBalance = accountBalance;
        this.accountHolderPhoneNo = accountHolderPhoneNo;
        this.active = active;
        this.branch = branch;
        this.accountHolderName = accountHolderName;
        this.accountNo = accountNo;
    }

    public AccountEntity()
    {

    }

    public  AccountEntity(Boolean active ,String accountHolderName){
        this.active=active;
        this.accountHolderName=accountHolderName;
    }

    @Override
    public int compareTo(AccountEntity account) {
       if(this.accountBalance -account.accountBalance>0)
       {
           return 1;
       }
       else
           return 0;
    }
}
