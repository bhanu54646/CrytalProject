package org.example.dao;

public class ClaimInvestigationRequest {

    public double policyDuration;
    public long dateOfDeath;
    public long policyIssueDate;
    public String causeOfDeath;
    public double claimAmount;
    public String investigationRequired;

    public ClaimInvestigationRequest(double policyDuration, long dateOfDeath, long policyIssueDate, String causeOfDeath, double claimAmount, String investigationRequired) {
        this.policyDuration = policyDuration;
        this.dateOfDeath = dateOfDeath;
        this.policyIssueDate = policyIssueDate;
        this.causeOfDeath = causeOfDeath;
        this.claimAmount = claimAmount;
        this.investigationRequired = investigationRequired;
    }

    @Override
    public String toString() {
        return "ClaimInvestigationRequest{" +
                "policyDuration=" + policyDuration +
                ", dateOfDeath=" + dateOfDeath +
                ", policyIssueDate=" + policyIssueDate +
                ", causeOfDeath='" + causeOfDeath + '\'' +
                ", claimAmount=" + claimAmount +
                ", investigationRequired='" + investigationRequired + '\'' +
                '}';
    }

    public ClaimInvestigationRequest() {
    }

    public double getPolicyDuration() {
        return policyDuration;
    }

    public void setPolicyDuration(double policyDuration) {
        this.policyDuration = policyDuration;
    }

    public long getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(long dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public long getPolicyIssueDate() {
        return policyIssueDate;
    }

    public void setPolicyIssueDate(long policyIssueDate) {
        this.policyIssueDate = policyIssueDate;
    }

    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getInvestigationRequired() {
        return investigationRequired;
    }

    public void setInvestigationRequired(String investigationRequired) {
        this.investigationRequired = investigationRequired;
    }
}
