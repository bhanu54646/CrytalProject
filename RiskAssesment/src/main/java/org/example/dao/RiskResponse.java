package org.example.dao;

public class RiskResponse {

    String risk;
    String recommandation;
   String holderName;
   double policyNo;

    public RiskResponse() {
    }

    public RiskResponse(String risk, String recommandation, String holderName, double policyNo) {
        this.risk = risk;
        this.recommandation = recommandation;
        this.holderName = holderName;
        this.policyNo = policyNo;
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
        return "RiskResponse{" +
                "risk='" + risk + '\'' +
                ", recommandation='" + recommandation + '\'' +
                ", holderName='" + holderName + '\'' +
                ", policyNo=" + policyNo +
                '}';
    }
}
