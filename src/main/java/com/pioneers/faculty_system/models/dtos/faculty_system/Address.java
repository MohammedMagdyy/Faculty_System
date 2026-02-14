package com.pioneers.faculty_system.models.dtos.faculty_system;

import java.util.Objects;

public class Address {
    private String country;
    private String governance;
    private String city;
    private int zipCode;
    private String street;
    private int buildingNumber;
    private int floorNumber;
    private int apartmentNumber;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGovernance() {
        return governance;
    }

    public void setGovernance(String governance) {
        this.governance = governance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address that = (Address) o;
        return zipCode == that.zipCode
                && buildingNumber == that.buildingNumber
                && floorNumber == that.floorNumber
                && apartmentNumber == that.apartmentNumber
                && Objects.equals(country, that.country)
                && Objects.equals(governance, that.governance)
                && Objects.equals(city, that.city)
                && Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, governance, city, zipCode, street, buildingNumber, floorNumber, apartmentNumber);
    }

    @Override
    public String toString() {
        return "AddressRequest{" +
                "country='" + country + '\'' +
                ", governance='" + governance + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", street='" + street + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", floorNumber=" + floorNumber +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}
