package org.example.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class MedicalClaimRequest {

    String procedureRiskLevel;
    double medicalCost;
    boolean criticalCondition;
    String investigationRequired;
    String treatmentype;
    String ImmediateReviewRequired;

    public String getProcedureRiskLevel() {
        return procedureRiskLevel;
    }

    public void setProcedureRiskLevel(String procedureRiskLevel) {
        this.procedureRiskLevel = procedureRiskLevel;
    }

    public double getMedicalCost() {
        return medicalCost;
    }

    public void setMedicalCost(double medicalCost) {
        this.medicalCost = medicalCost;
    }

    public boolean isCriticalCondition() {
        return criticalCondition;
    }

    public void setCriticalCondition(boolean criticalCondition) {
        this.criticalCondition = criticalCondition;
    }

    public String getInvestigationRequired() {
        return investigationRequired;
    }

    public void setInvestigationRequired(String investigationRequired) {
        this.investigationRequired = investigationRequired;
    }

    public String getTreatmentype() {
        return treatmentype;
    }

    public void setTreatmentype(String treatmentype) {
        this.treatmentype = treatmentype;
    }

    public String getImmediateReviewRequired() {
        return ImmediateReviewRequired;
    }

    public void setImmediateReviewRequired(String immediateReviewRequired) {
        ImmediateReviewRequired = immediateReviewRequired;
    }

    @Override
    public String toString() {
        return "MedicalClaimRequest{" +
                "procedureRiskLevel='" + procedureRiskLevel + '\'' +
                ", medicalCost=" + medicalCost +
                ", criticalCondition=" + criticalCondition +
                ", investigationRequired='" + investigationRequired + '\'' +
                ", treatmentype='" + treatmentype + '\'' +
                ", ImmediateReviewRequired='" + ImmediateReviewRequired + '\'' +
                '}';
    }

    public MedicalClaimRequest() {
    }

    public MedicalClaimRequest(String procedureRiskLevel, double medicalCost, boolean criticalCondition, String investigationRequired, String treatmentype, String immediateReviewRequired) {
        this.procedureRiskLevel = procedureRiskLevel;
        this.medicalCost = medicalCost;
        this.criticalCondition = criticalCondition;
        this.investigationRequired = investigationRequired;
        this.treatmentype = treatmentype;
        ImmediateReviewRequired = immediateReviewRequired;
    }
}
