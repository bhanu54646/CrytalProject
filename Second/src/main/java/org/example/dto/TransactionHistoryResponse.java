package org.example.dto;

import org.example.model.AccountEntity;
import org.example.model.AccountTransaction;

import java.util.List;

public class TransactionHistoryResponse {

    String statusMessage;
    String statusCode;

    @Override
    public String toString() {
        return "TransactionHistoryResponse{" +
                "statusMessage='" + statusMessage + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", transactions=" + transactions +
                '}';
    }

    List<AccountTransaction> transactions;

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public List<AccountTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<AccountTransaction> transactions) {
        this.transactions = transactions;
    }

    public TransactionHistoryResponse(String statusMessage, String statusCode, List<AccountTransaction> transactions) {
        this.statusMessage = statusMessage;
        this.statusCode = statusCode;
        this.transactions = transactions;
    }

    public TransactionHistoryResponse() {
    }
}
