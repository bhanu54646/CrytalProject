package org.example.dto;

import java.time.LocalDate;

public class TransactionHistoryRequest {
    String accountNo;
    String fromDate;
    String toDate;

    @Override
    public String toString() {
        return "TransactionHistoryRequest{" +
                "accountNo='" + accountNo + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                '}';
    }

    public TransactionHistoryRequest() {
    }

    public TransactionHistoryRequest(String accountNo, String fromDate, String toDate) {
        this.accountNo = accountNo;
        this.fromDate = fromDate;
        this.toDate = toDate;
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
}
