package org.example.dto;

public class MonthlyExpenseRequst {
    String  accountNo;
    String fromDate;
    String toDate;

    @Override
    public String toString() {
        return "MonthlyExpenseRequst{" +
                "accountNo='" + accountNo + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                '}';
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public MonthlyExpenseRequst() {
    }

    public MonthlyExpenseRequst(String accountNo, String fromDate, String toDate) {
        this.accountNo = accountNo;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}
