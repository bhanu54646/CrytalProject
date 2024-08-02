package org.example.dao;

public class AssignToApproverRequest {

    int caseId;
    int approverid;
    int invesId;

    public AssignToApproverRequest() {
    }

    public AssignToApproverRequest(int caseId, int approverid, int invesId) {
        this.caseId = caseId;
        this.approverid = approverid;
        this.invesId = invesId;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public int getApproverid() {
        return approverid;
    }

    public void setApproverid(int approverid) {
        this.approverid = approverid;
    }

    public int getInvesId() {
        return invesId;
    }

    public void setInvesId(int invesId) {
        this.invesId = invesId;
    }
}
