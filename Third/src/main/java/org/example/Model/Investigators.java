package org.example.Model;

import javax.persistence.*;

@Entity
@Table(name="Investigator")
public class Investigators {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int investigatorId;
    @Column(name = "case_id")
    private int caseID;
    @Column(name = "investigator_name")
    private String investigatorName;
    @Column(name = "findings")
    private String findings;
    @Column(name = "recommandation")
    private String recommandation;
    @Column(name = "status")
    private String status;
    private String approverName;
    @Override
    public String toString() {
        return "Investigators{" +
                "investigatorId=" + investigatorId +
                ", caseID=" + caseID +
                ", investigatorName='" + investigatorName + '\'' +
                ", findings='" + findings + '\'' +
                ", recommandation='" + recommandation + '\'' +
                ", status='" + status + '\'' +
                ", approverName='" + approverName + '\'' +
                '}';
    }

    public Investigators() {
    }

    public int getInvestigatorId() {
        return investigatorId;
    }

    public void setInvestigatorId(int investigatorId) {
        this.investigatorId = investigatorId;
    }

    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    public String getInvestigatorName() {
        return investigatorName;
    }

    public void setInvestigatorName(String investigatorName) {
        this.investigatorName = investigatorName;
    }

    public String getRecommandation() {
        return recommandation;
    }

    public void setRecommandation(String recommandation) {
        this.recommandation = recommandation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public Investigators(int investigatorId, int caseID, String investigatorName, String findings, String recommandation, String status, String approverName) {
        this.investigatorId = investigatorId;
        this.caseID = caseID;
        this.investigatorName = investigatorName;
        this.findings = findings;
        this.recommandation = recommandation;
        this.status = status;
        this.approverName = approverName;
    }
}
