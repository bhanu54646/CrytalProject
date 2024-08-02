package org.example.model;


import javax.persistence.*;

@Entity
@Table(name = "pay_bank_parking")
public class PayBankParkingEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_bank_id")
    private long pay_bank_id;

    @Column(name = "branch_name")
    private String branch_name;

    @Column(name = "policy_number")
    private String policy_number;

    @Column(name = "application_no")
    private String application_no;

    @Column(name = "business_type")
    private String business_type;

    @Column(name = "la_name")
    private String la_name;

    @Column(name = "plan_name")
    private String plan_name;

    @Column(name = "premium_amount")
    private String premium_amount;

    @Column(name = "payment_mode")
    private String payment_mode;

    @Column(name = "ext_ref_no")
    private String ext_ref_no;

    @Column(name = "cod_drawer_acct")
    private String cod_drawer_acct;

    @Column(name = "payor_name")
    private String payor_name;

    @Override
    public String toString() {
        return "PayBankParkingEntity{" +
                "pay_bank_id=" + pay_bank_id +
                ", branch_name='" + branch_name + '\'' +
                ", policy_number='" + policy_number + '\'' +
                ", application_no='" + application_no + '\'' +
                ", business_type='" + business_type + '\'' +
                ", la_name='" + la_name + '\'' +
                ", plan_name='" + plan_name + '\'' +
                ", premium_amount='" + premium_amount + '\'' +
                ", payment_mode='" + payment_mode + '\'' +
                ", ext_ref_no='" + ext_ref_no + '\'' +
                ", cod_drawer_acct='" + cod_drawer_acct + '\'' +
                ", payor_name='" + payor_name + '\'' +
                '}';
    }

    public PayBankParkingEntity() {
    }

    public PayBankParkingEntity(long pay_bank_id, String branch_name, String policy_number, String application_no, String business_type, String la_name, String plan_name, String premium_amount, String payment_mode, String ext_ref_no, String cod_drawer_acct, String payor_name) {
        this.pay_bank_id = pay_bank_id;
        this.branch_name = branch_name;
        this.policy_number = policy_number;
        this.application_no = application_no;
        this.business_type = business_type;
        this.la_name = la_name;
        this.plan_name = plan_name;
        this.premium_amount = premium_amount;
        this.payment_mode = payment_mode;
        this.ext_ref_no = ext_ref_no;
        this.cod_drawer_acct = cod_drawer_acct;
        this.payor_name = payor_name;
    }

    public long getPay_bank_id() {
        return pay_bank_id;
    }

    public void setPay_bank_id(long pay_bank_id) {
        this.pay_bank_id = pay_bank_id;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getPolicy_number() {
        return policy_number;
    }

    public void setPolicy_number(String policy_number) {
        this.policy_number = policy_number;
    }

    public String getApplication_no() {
        return application_no;
    }

    public void setApplication_no(String application_no) {
        this.application_no = application_no;
    }

    public String getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(String business_type) {
        this.business_type = business_type;
    }

    public String getLa_name() {
        return la_name;
    }

    public void setLa_name(String la_name) {
        this.la_name = la_name;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public String getPremium_amount() {
        return premium_amount;
    }

    public void setPremium_amount(String premium_amount) {
        this.premium_amount = premium_amount;
    }

    public String getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }

    public String getExt_ref_no() {
        return ext_ref_no;
    }

    public void setExt_ref_no(String ext_ref_no) {
        this.ext_ref_no = ext_ref_no;
    }

    public String getCod_drawer_acct() {
        return cod_drawer_acct;
    }

    public void setCod_drawer_acct(String cod_drawer_acct) {
        this.cod_drawer_acct = cod_drawer_acct;
    }

    public String getPayor_name() {
        return payor_name;
    }

    public void setPayor_name(String payor_name) {
        this.payor_name = payor_name;
    }
}

