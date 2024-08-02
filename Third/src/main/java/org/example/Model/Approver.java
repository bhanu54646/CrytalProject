package org.example.Model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "approver")
public class Approver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "approver_id")
    private int approveId;
    @Column(name = "approver_name")
    private String approverName;
    @Column(name = "case_id")
    private int caseID;
    @Column(name = "decesion")
    private String decesion;
    @Column(name = "comment")
    private String comment;
    @Column(name = "investigator_name")
    private String investigatorName;

    public int getApproveId() {
        return approveId;
    }

    public void setApproveId(int approveId) {
        this.approveId = approveId;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    public String getDecesion() {
        return decesion;
    }

    public void setDecesion(String decesion) {
        this.decesion = decesion;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getInvestigatorName() {
        return investigatorName;
    }

    public void setInvestigatorName(String investigatorName) {
        this.investigatorName = investigatorName;
    }

    public Approver() {
    }

    public Approver(String comment, int approveId, String approverName, int caseID, String decesion, String investigatorName) {
        this.comment = comment;
        this.approveId = approveId;
        this.approverName = approverName;
        this.caseID = caseID;
        this.decesion = decesion;
        this.investigatorName = investigatorName;
    }

    @Override
    public String toString() {
        return "Approver{" +
                "approveId=" + approveId +
                ", approverName='" + approverName + '\'' +
                ", caseID=" + caseID +
                ", decesion='" + decesion + '\'' +
                ", comment='" + comment + '\'' +
                ", investigatorName='" + investigatorName + '\'' +
                '}';
    }


}
