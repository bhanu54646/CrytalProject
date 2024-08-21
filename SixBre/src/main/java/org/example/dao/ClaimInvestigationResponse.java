package org.example.dao;

public class ClaimInvestigationResponse {

    String statusMessage;
    String InvestigationRequired;

    @Override
    public String toString() {
        return "ClaimInvestigationResponse{" +
                "statusMessage='" + statusMessage + '\'' +
                ", InvestigationRequired='" + InvestigationRequired + '\'' +
                '}';
    }

    public ClaimInvestigationResponse() {
    }

    public ClaimInvestigationResponse(String statusMessage, String investigationRequired) {
        this.statusMessage = statusMessage;
        InvestigationRequired = investigationRequired;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getInvestigationRequired() {
        return InvestigationRequired;
    }

    public void setInvestigationRequired(String investigationRequired) {
        InvestigationRequired = investigationRequired;
    }
}
