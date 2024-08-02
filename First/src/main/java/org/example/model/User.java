package org.example.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;

@Document(collection = "users")
public class User {
      @Id
      String id;
      String firstName;
      String lastName;
      String emailId;
      int age;
      String address;
      String phoneNumber;
      boolean status;
      private List<Address> adr;


      public User()
      {

      }
      public String getId() {
            return id;
      }




      @Override
      public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", emailId='" + emailId + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", status=" + status +
                    ", adr=" + adr +
                    '}';
      }

      public User(String id, String firstName, String lastName, String emailId, int age, String address, String phoneNumber, boolean status, List<Address> adr) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.emailId = emailId;
            this.age = age;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.status = status;
            this.adr = adr;
      }

      public void setId(String id) {
            this.id = id;
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

      public String getEmailId() {
            return emailId;
      }

      public void setEmailId(String emailId) {
            this.emailId = emailId;
      }

      public int getAge() {
            return age;
      }

      public void setAge(int age) {
            this.age = age;
      }

      public String getAddress() {
            return address;
      }

      public void setAddress(String address) {
            this.address = address;
      }

      public String getPhoneNumber() {
            return phoneNumber;
      }

      public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
      }

      public boolean isStatus() {
            return status;
      }

      public void setStatus(boolean status) {
            this.status = status;
      }

      public List<Address> getAdr() {
            return adr;
      }

      public void setAdr(List<Address> adr) {
            this.adr = adr;
      }





}
