package org.example.dao;

public class ClaimRequest {

    private String claimType;
    private int policyNo;
    private String lifeAssured;
    private String dateOfDeath;
    private String dateofInsurance;
    private String causeofDeath;
    private String placeofDeath;
    private String claimAmount;
    private String claimerofclaim;

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public int getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(int policyNo) {
        this.policyNo = policyNo;
    }

    public String getLifeAssured() {
        return lifeAssured;
    }

    public void setLifeAssured(String lifeAssured) {
        this.lifeAssured = lifeAssured;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getDateofInsurance() {
        return dateofInsurance;
    }

    public void setDateofInsurance(String dateofInsurance) {
        this.dateofInsurance = dateofInsurance;
    }

    public String getCauseofDeath() {
        return causeofDeath;
    }

    public void setCauseofDeath(String causeofDeath) {
        this.causeofDeath = causeofDeath;
    }

    public String getPlaceofDeath() {
        return placeofDeath;
    }

    public void setPlaceofDeath(String placeofDeath) {
        this.placeofDeath = placeofDeath;
    }

    public String getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(String claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getClaimerofclaim() {
        return claimerofclaim;
    }

    public void setClaimerofclaim(String claimerofclaim) {
        this.claimerofclaim = claimerofclaim;
    }

    @Override
    public String toString() {
        return "ClaimRequest{" +
                "claimType='" + claimType + '\'' +
                ", policyNo=" + policyNo +
                ", lifeAssured='" + lifeAssured + '\'' +
                ", dateOfDeath='" + dateOfDeath + '\'' +
                ", dateofInsurance='" + dateofInsurance + '\'' +
                ", causeofDeath='" + causeofDeath + '\'' +
                ", placeofDeath='" + placeofDeath + '\'' +
                ", claimAmount='" + claimAmount + '\'' +
                ", claimerofclaim='" + claimerofclaim + '\'' +
                '}';
    }

    public ClaimRequest() {
    }

    public ClaimRequest(String claimType, int policyNo, String lifeAssured, String dateOfDeath, String dateofInsurance, String causeofDeath, String placeofDeath, String claimAmount, String claimerofclaim) {
        this.claimType = claimType;
        this.policyNo = policyNo;
        this.lifeAssured = lifeAssured;
        this.dateOfDeath = dateOfDeath;
        this.dateofInsurance = dateofInsurance;
        this.causeofDeath = causeofDeath;
        this.placeofDeath = placeofDeath;
        this.claimAmount = claimAmount;
        this.claimerofclaim = claimerofclaim;
    }


}
