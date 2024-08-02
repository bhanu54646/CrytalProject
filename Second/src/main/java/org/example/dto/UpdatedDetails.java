package org.example.dto;

public class UpdatedDetails {

    String fromAccountNo;
    String toAccontNo;
    double blanceFromaccount;
    double balanceToaccount;


    public UpdatedDetails() {
    }

    public UpdatedDetails(String fromAccountNo, String toAccontNo, double blanceFromaccount, double balanceToaccount) {
        this.fromAccountNo = fromAccountNo;
        this.toAccontNo = toAccontNo;
        this.blanceFromaccount = blanceFromaccount;
        this.balanceToaccount = balanceToaccount;
    }

    public String getFromAccountNo() {
        return fromAccountNo;
    }

    public void setFromAccountNo(String fromAccountNo) {
        this.fromAccountNo = fromAccountNo;
    }

    public String getToAccontNo() {
        return toAccontNo;
    }

    public void setToAccontNo(String toAccontNo) {
        this.toAccontNo = toAccontNo;
    }

    public double getBlanceFromaccount() {
        return blanceFromaccount;
    }

    public void setBlanceFromaccount(double blanceFromaccount) {
        this.blanceFromaccount = blanceFromaccount;
    }

    public double getBalanceToaccount() {
        return balanceToaccount;
    }

    public void setBalanceToaccount(double balanceToaccount) {
        this.balanceToaccount = balanceToaccount;
    }

    @Override
    public String toString() {
        return "UpdatedDetails{" +
                "fromAccountNo='" + fromAccountNo + '\'' +
                ", toAccontNo='" + toAccontNo + '\'' +
                ", blanceFromaccount=" + blanceFromaccount +
                ", balanceToaccount=" + balanceToaccount +
                '}';
    }
}
