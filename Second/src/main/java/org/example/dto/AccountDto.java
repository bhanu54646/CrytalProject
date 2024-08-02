package org.example.dto;

import org.example.model.AccountEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

public class AccountDto {

    String message;
    String statusCode;
    List<AccountEntity> account;

    public AccountDto()
    {

    }

    public AccountDto(String message, String statusCode, List<AccountEntity> account) {
        this.message = message;
        this.statusCode = statusCode;
        this.account = account;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "message='" + message + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", account=" + account +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public List<AccountEntity> getAccount() {
        return account;
    }

    public void setAccount(List<AccountEntity> account) {
        this.account = account;
    }
}
