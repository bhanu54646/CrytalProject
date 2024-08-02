package org.example.dto;

import org.example.model.AccountEntity;

public class AcccountEntityResponse {

    String accountHolderName;
    boolean active;


    public AcccountEntityResponse()
    {

    }


    public AcccountEntityResponse(boolean active, String accountHolderName) {
        this.active = active;
        this.accountHolderName = accountHolderName;
    }

    @Override
    public String toString() {
        return "AcccountEntityResponse{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", active=" + active +
                '}';
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
}
