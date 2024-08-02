package org.example.dto;

import java.util.List;

public class AccountDeleteResponse {

String statusMessage;
String statusCode;
List<String> accountNo;

public AccountDeleteResponse()
{

}


    public AccountDeleteResponse(String statusCode, String statusMessage, List<String> accountNo) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "AccountDeleteResponse{" +
                "statusMessage='" + statusMessage + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", accountNo=" + accountNo +
                '}';
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

    public List<String> getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(List<String> accountNo) {
        this.accountNo = accountNo;
    }
}
