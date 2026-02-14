package com.pioneers.faculty_system.models.dtos.faculty_system;

import java.util.Objects;

public class StudentResponse {
    private  int studentID;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Address address ;

    public StudentResponse() {

    }

    public StudentResponse(int studentID, String fullName, String email, String phoneNumber, Address address) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String retrieveAddress()
    {
        return address.getCountry() + "/"
                + address.getGovernance() + "/"
                + address.getCity() + "/"
                + address.getZipCode() + "/"
                + address.getStreet() + "/"
                + address.getBuildingNumber() + "/"
                + address.getFloorNumber() + "/"
                + address.getApartmentNumber();
    }


    public int getStudentID() {
        return studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentResponse that = (StudentResponse) o;
        return studentID == that.studentID && Objects.equals(fullName, that.fullName) && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, fullName, email, phoneNumber, address);
    }

    @Override
    public String toString() {
        return "StudentResponse{" +
                "studentID=" + studentID +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                '}';
    }
}
