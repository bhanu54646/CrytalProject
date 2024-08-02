package org.example.dto;

public class TransactionRequest {


    String fromAccountNo;
    String toAccontNo;
    double amount;



    public TransactionRequest()
    {

    }
    public TransactionRequest(double amount, String toAccontNo, String fromAccountNo) {
        this.amount = amount;
        this.toAccontNo = toAccontNo;
        this.fromAccountNo = fromAccountNo;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "fromAccountNo='" + fromAccountNo + '\'' +
                ", toAccontNo='" + toAccontNo + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getToAccontNo() {
        return toAccontNo;
    }

    public void setToAccontNo(String toAccontNo) {
        this.toAccontNo = toAccontNo;
    }

    public String getFromAccountNo() {
        return fromAccountNo;
    }

    public void setFromAccountNo(String fromAccountNo) {
        this.fromAccountNo = fromAccountNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
