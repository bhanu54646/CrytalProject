package org.example.model;

import java.util.List;

public class StudentEntityResponse {

    String version;
    String statuCode;
    String statuMessage;
    List<StudentEntity> sr;
    public String getStatuCode() {
        return statuCode;
    }

    public void setStatuCode(String statuCode) {
        this.statuCode = statuCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatuMessage() {
        return statuMessage;
    }

    public void setStatuMessage(String statuMessage) {
        this.statuMessage = statuMessage;
    }

    public List<StudentEntity> getSr() {
        return sr;
    }

    public void setSr(List<StudentEntity> sr) {
        this.sr = sr;
    }


}
