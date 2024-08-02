package org.example.dao;

public class AssignToInvestigatorRequest {

    int caseId;
    int investigatorId;
    String investigatorName;

    public AssignToInvestigatorRequest(int caseId, int investigatorId, String investigatorName) {
        this.caseId = caseId;
        this.investigatorId = investigatorId;
        this.investigatorName = investigatorName;
    }

    public AssignToInvestigatorRequest() {
    }

    @Override
    public String toString() {
        return "AssignToInvestigatorRequest{" +
                "caseId=" + caseId +
                ", investigatorId=" + investigatorId +
                ", investigatorName='" + investigatorName + '\'' +
                '}';
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public int getInvestigatorId() {
        return investigatorId;
    }

    public void setInvestigatorId(int investigatorId) {
        this.investigatorId = investigatorId;
    }

    public String getInvestigatorName() {
        return investigatorName;
    }

    public void setInvestigatorName(String investigatorName) {
        this.investigatorName = investigatorName;
    }
}
