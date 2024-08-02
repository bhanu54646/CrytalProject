package org.example.dto;

import org.example.model.AccountEntity;

import java.util.List;

public class TransactionResponse {

    String statusMessage;
    String statusCode;
    List<UpdatedDetails> de;


    @Override
    public String toString() {
        return "TransactionResponse{" +
                "statusMessage='" + statusMessage + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", de=" + de +
                '}';
    }

    public TransactionResponse(String statusMessage, String statusCode, List<UpdatedDetails> de) {
        this.statusMessage = statusMessage;
        this.statusCode = statusCode;
        this.de = de;
    }

    public TransactionResponse() {
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public List<UpdatedDetails> getDe() {
        return de;
    }

    public void setDe(List<UpdatedDetails> de) {
        this.de = de;
    }
}






