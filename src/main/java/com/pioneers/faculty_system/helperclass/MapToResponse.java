package com.pioneers.rest.helperclass;

import com.pioneers.rest.models.dtos.faculty_system.Address;
import com.pioneers.rest.models.dtos.faculty_system.StudentRequest;
import com.pioneers.rest.models.dtos.faculty_system.StudentResponse;

public class MapToResponse {


    public static StudentResponse mapToResponse(StudentRequest student){

        Address address = new Address();
        address.setCountry(student.getAddress().getCountry());
        address.setGovernance(student.getAddress().getGovernance());
        address.setCity(student.getAddress().getCity());
        address.setZipCode(student.getAddress().getZipCode());
        address.setStreet(student.getAddress().getStreet());
        address.setBuildingNumber(student.getAddress().getBuildingNumber());
        address.setFloorNumber(student.getAddress().getFloorNumber());
        address.setApartmentNumber(student.getAddress().getApartmentNumber());

        StudentResponse response = new StudentResponse();
        response.setFullName(student.getFullNameForReq());
        response.setEmail(student.getEmail());
        response.setPhoneNumber(student.getPhoneNumber());
        response.setAddress(address);

        return response;
    }

}
