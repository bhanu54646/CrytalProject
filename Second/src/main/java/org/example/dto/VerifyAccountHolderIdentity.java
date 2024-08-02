package org.example.dto;

public class VerifyAccountHolderIdentity {

    String accountNo;
    String phoneNo;
    String HoldersName;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getHoldersName() {
        return HoldersName;
    }

    public void setHoldersName(String holdersName) {
        HoldersName = holdersName;
    }

    public VerifyAccountHolderIdentity() {
    }

    public VerifyAccountHolderIdentity(String accountNo, String phoneNo, String holdersName) {
        this.accountNo = accountNo;
        this.phoneNo = phoneNo;
        HoldersName = holdersName;
    }

    @Override
    public String toString() {
        return "VerifyAccountHolderIdentity{" +
                "accountNo='" + accountNo + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", HoldersName='" + HoldersName + '\'' +
                '}';
    }


}
