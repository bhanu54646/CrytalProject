package org.example.dao;

public class RiskCalculateRequest {
    double  policyNo;
    String policyHoldername;
    int age;
    char gender;
    String occupation;
    boolean smoker;
    boolean alcoholConsumer;
    String healthHistory;
    String location;

    public RiskCalculateRequest() {
    }

    public RiskCalculateRequest(double policyNo, String policyHoldername, int age, char gender, String occupation, boolean smoker, boolean alcoholConsumer, String healthHistory, String location) {
        this.policyNo = policyNo;
        this.policyHoldername = policyHoldername;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.smoker = smoker;
        this.alcoholConsumer = alcoholConsumer;
        this.healthHistory = healthHistory;
        this.location = location;
    }

    public double getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(double policyNo) {
        this.policyNo = policyNo;
    }

    public String getPolicyHoldername() {
        return policyHoldername;
    }

    public void setPolicyHoldername(String policyHoldername) {
        this.policyHoldername = policyHoldername;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }

    public boolean isAlcoholConsumer() {
        return alcoholConsumer;
    }

    public void setAlcoholConsumer(boolean alcoholConsumer) {
        this.alcoholConsumer = alcoholConsumer;
    }

    public String getHealthHistory() {
        return healthHistory;
    }

    public void setHealthHistory(String healthHistory) {
        this.healthHistory = healthHistory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "RiskCalculateRequest{" +
                "policyNo=" + policyNo +
                ", policyHoldername='" + policyHoldername + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", occupation='" + occupation + '\'' +
                ", smoker=" + smoker +
                ", alcoholConsumer=" + alcoholConsumer +
                ", healthHistory='" + healthHistory + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
