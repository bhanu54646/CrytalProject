package org.example.dao;

import org.example.Model.Investigators;

import java.util.List;

public class InvestiGatorResponse{

    String statusCode;
    String statusMessage;
    List<Investigators> investigators;

    public InvestiGatorResponse(List<Investigators> investigators, String statusCode, String statusMessage) {
        this.investigators = investigators;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public InvestiGatorResponse() {
    }

    @Override
    public String toString() {
        return "InvestiGatorResponse{" +
                "investigators=" + investigators +
                ", statusCode='" + statusCode + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                '}';
    }

    public List<Investigators> getInvestigators() {
        return investigators;
    }

    public void setInvestigators(List<Investigators> investigators) {
        this.investigators = investigators;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
