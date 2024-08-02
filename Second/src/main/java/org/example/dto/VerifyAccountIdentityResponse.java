package org.example.dto;

import org.example.model.AccountEntity;

import java.util.List;

public class VerifyAccountIdentityResponse {

    String statusMessage;
    String statusCode;
    List<AccountEntity> accountDetails;


    @Override
    public String toString() {
        return "VerifyAccountIdentityResponse{" +
                "statusMessage='" + statusMessage + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", accountDetails=" + accountDetails +
                '}';
    }

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

    public List<AccountEntity> getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(List<AccountEntity> accountDetails) {
        this.accountDetails = accountDetails;
    }



    public VerifyAccountIdentityResponse(List<AccountEntity> accountDetails, String statusCode, String statusMessage) {
        this.accountDetails = accountDetails;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public VerifyAccountIdentityResponse() {
    }
}
