package org.example.Model;


import javax.persistence.*;

@Entity
@Table(name = "lifeAssured_details_Entity")
public class LifeAssuredDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_no")
    private int PolicyNo;
    @Column(name="first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "Dob")
    private String Dob;
    @Column(name="pan_no")
    private String panNo;
    @Column(name="country_of_birth")
    private String countryOfBirth;
    @Column(name = "marital_status")
    private String maritalStatus;
    @Column(name = "address")
    private String address;

    @Override
    public String toString() {
        return "LifeAssuredDetailsEntity{" +
                "PolicyNo=" + PolicyNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Dob='" + Dob + '\'' +
                ", panNo='" + panNo + '\'' +
                ", countryOfBirth='" + countryOfBirth + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public LifeAssuredDetailsEntity() {

    }

    public LifeAssuredDetailsEntity(int policyNo, String firstName, String lastName, String dob, String panNo, String countryOfBirth, String maritalStatus, String address) {
        PolicyNo = policyNo;
        this.firstName = firstName;
        this.lastName = lastName;
        Dob = dob;
        this.panNo = panNo;
        this.countryOfBirth = countryOfBirth;
        this.maritalStatus = maritalStatus;
        this.address = address;
    }


    public int getPolicyNo() {
        return PolicyNo;
    }

    public void setPolicyNo(int policyNo) {
        PolicyNo = policyNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
