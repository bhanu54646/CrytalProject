package org.example.Dto;

import javax.persistence.Entity;


public class StudentDto {

    String email;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    String firstName;
    int age;
    String statuscode;
    String message;
    @Override
    public String toString() {
        return "StudentDto{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
