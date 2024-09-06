package org.example.dao;

public class InvestigatorRequest {
    String approverName;

    public InvestigatorRequest(String approverName) {
        this.approverName = approverName;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    @Override
    public String toString() {
        return "InvestigatorRequest{" +
                "approverName='" + approverName + '\'' +
                '}';
    }

    public InvestigatorRequest() {
    }
}