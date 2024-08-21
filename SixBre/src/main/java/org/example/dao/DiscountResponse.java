package org.example.dao;

public class DiscountResponse {

    String statusMessage;
    int discount;

    @Override
    public String toString() {
        return "DiscountResponse{" +
                "statusMessage='" + statusMessage + '\'' +
                ", discount=" + discount +
                '}';
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public DiscountResponse() {
    }

    public DiscountResponse(String statusMessage, int discount) {
        this.statusMessage = statusMessage;
        this.discount = discount;
    }
}
