package org.example.Model;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.lang.ref.PhantomReference;

@Entity
@Table(name = "case_details")
public class CaseDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_id")
    private int caseID;
    @Column(name = "claim_type")
    private String caseType;
    @Column(name = "policy_no")
    private int policyNo;
    @Column(name = "lifeassured")
    private String lifeAssured;
    @Column(name = "date_of_death")
    private String dateOfDeath;
    @Column(name = "date_of_insurance")
    private String dateofInsurance;
    @Column(name = "cause_of_death")
    private String causeofDeath;
    @Column(name = "place_of_death")
    private String placeofDeath;
    @Column(name = "claim_amount")
    private String claimAmount;
    @Column(name = "claimer_name")
    private String claimerofclaim;


    public CaseDetailEntity() {
    }

    public CaseDetailEntity(int caseID, String caseType, int policyNo, String lifeAssured, String dateOfDeath, String dateofInsurance, String causeofDeath, String placeofDeath, String claimAmount, String claimerofclaim) {
        this.caseID = caseID;
        this.caseType = caseType;
        this.policyNo = policyNo;
        this.lifeAssured = lifeAssured;
        this.dateOfDeath = dateOfDeath;
        this.dateofInsurance = dateofInsurance;
        this.causeofDeath = causeofDeath;
        this.placeofDeath = placeofDeath;
        this.claimAmount = claimAmount;
        this.claimerofclaim = claimerofclaim;
    }

    @Override
    public String toString() {
        return "CaseDetailEntity{" +
                "caseID=" + caseID +
                ", caseType='" + caseType + '\'' +
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

    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
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
}
