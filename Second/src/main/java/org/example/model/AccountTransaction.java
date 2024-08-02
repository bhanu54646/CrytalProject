package org.example.model;


import javax.persistence.*;

@Entity
@Table(name = "account_transaction_history")
public class AccountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Txn_id")
    int trasactionId;
    @Column(name = "debit")
    double debit;
    @Column(name = "credit")
    double credit;
    @Column(name = "account_no")
    String accountNo;
    @Column(name = "balance")
    double balance;
    @Column(name = "txn_From_Date")
    String accountTxnFromDate;
    @Column(name = "txn_To_Date")
    String accountTxnToDate;


    @Override
    public String toString() {
        return "AccountTransaction{" +
                "trasactionId=" + trasactionId +
                ", debit=" + debit +
                ", credit=" + credit +
                ", accountNo='" + accountNo + '\'' +
                ", balance=" + balance +
                ", accountTxnFromDate='" + accountTxnFromDate + '\'' +
                ", accountTxnToDate='" + accountTxnToDate + '\'' +
                '}';
    }

    public AccountTransaction() {
    }

    public AccountTransaction(int trasactionId, double debit, double credit, String accountNo, double balance, String accountTxnFromDate, String accountTxnToDate) {
        this.trasactionId = trasactionId;
        this.debit = debit;
        this.credit = credit;
        this.accountNo = accountNo;
        this.balance = balance;
        this.accountTxnFromDate = accountTxnFromDate;
        this.accountTxnToDate = accountTxnToDate;
    }

    public int getTrasactionId() {
        return trasactionId;
    }

    public void setTrasactionId(int trasactionId) {
        this.trasactionId = trasactionId;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountTxnFromDate() {
        return accountTxnFromDate;
    }

    public void setAccountTxnFromDate(String accountTxnFromDate) {
        this.accountTxnFromDate = accountTxnFromDate;
    }

    public String getAccountTxnToDate() {
        return accountTxnToDate;
    }

    public void setAccountTxnToDate(String accountTxnToDate) {
        this.accountTxnToDate = accountTxnToDate;
    }
}