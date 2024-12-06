package org.example.model;


import javax.persistence.*;
@Table(name = "risk_profile_dump")
@Entity
public class RiskProfile {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "risk_id")
    int riskid;
    @Column(name = "risk_level")
    String risk;
    @Column(name="recommandation")
    String recommandation;
    @Column(name = "holder_name")
    String holderName;
    @Column(name="policy_no")
    double policyNo;

    public RiskProfile(int riskid, String risk, String recommandation, String holderName, double policyNo) {
        this.riskid = riskid;
        this.risk = risk;
        this.recommandation = recommandation;
        this.holderName = holderName;
        this.policyNo = policyNo;
    }

    public int getRiskid() {
        return riskid;
    }

    public void setRiskid(int riskid) {
        this.riskid = riskid;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getRecommandation() {
        return recommandation;
    }

    public void setRecommandation(String recommandation) {
        this.recommandation = recommandation;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(double policyNo) {
        this.policyNo = policyNo;
    }

    @Override
    public String toString() {
        return "RiskProfile{" +
                "riskid=" + riskid +
                ", risk='" + risk + '\'' +
                ", recommandation='" + recommandation + '\'' +
                ", holderName='" + holderName + '\'' +
                ", policyNo=" + policyNo +
                '}';
    }

    public RiskProfile() {
    }
}
