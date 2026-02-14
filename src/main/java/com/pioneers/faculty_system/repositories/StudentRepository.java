package com.pioneers.faculty_system.repositories;

import com.pioneers.faculty_system.models.dtos.faculty_system.StudentRequest;
import org.springframework.stereotype.Repository;
import java.util.LinkedHashSet;
import java.util.Set;

@Repository
public class StudentRepository {

    private final Set<StudentRequest> studentSet = new LinkedHashSet<>();

    public void save(StudentRequest student) {
        studentSet.add(student);
    }

    public Set<StudentRequest> findAll() {
        return studentSet;
    }

    public StudentRequest findByEmailAndPassword(String email, String password) {
        return studentSet.stream()
                .filter(s -> s.getEmail().equals(email))
                .filter(s -> s.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public void deleteAll() {
        studentSet.clear();
    }

    public void deleteByEmail(String email) {
        studentSet.removeIf(s -> s.getEmail().equals(email));
    }

    public StudentRequest findFirst() {
        return studentSet.stream().findFirst().orElse(null);
    }

    public StudentRequest updateStudent(String email,StudentRequest updatedStudent) {
        StudentRequest existing = studentSet.stream()
                .filter(s -> s.getEmail().equals(email))
                .findFirst()
                .orElse(null);

        if (existing == null) {
            return null;
        }

        studentSet.remove(existing);
        studentSet.add(updatedStudent);

        return  updatedStudent;
    }
}





//    public StudentResponse getStudent(String email, String password) {
//        StudentRequest student = studentSet.stream()
//                .filter(s -> s.getEmail().equals(email))
//                .filter(s -> s.getPassword().equals(password))
//                .findFirst()
//                .orElseThrow();
//
//        return MapToResponse.mapToResponse(student);
//
//    }

//    public StudentResponse updateStudent(StudentRequest student) {
//        final Address address = new Address();
//        address.setCountry(student.getAddress().getCountry());
//        address.setGovernance(student.getAddress().getGovernance());
//        address.setCity(student.getAddress().getCity());
//        address.setZipCode(student.getAddress().getZipCode());
//        address.setStreet(student.getAddress().getStreet());
//        address.setBuildingNumber(student.getAddress().getBuildingNumber());
//        address.setFloorNumber(student.getAddress().getFloorNumber());
//        address.setApartmentNumber(student.getAddress().getApartmentNumber());
//
//        final StudentResponse studentResponse=new StudentResponse();
//        studentResponse.setAddress(address);
//        studentResponse.setFullName(student.getFullNameForReq());
//        studentResponse.setEmail(student.getEmail());
//        studentResponse.setPhoneNumber(student.getPhoneNumber());
//
//        return studentResponse;
//    }

//    public StudentRequest getFirstStudent(Set<StudentRequest> studentSet) {
//        return studentSet.stream()
//                .findFirst()
//                .orElseThrow();
//    }
//
//    public void cleatAllStudent(Set<StudentRequest> studentSet) {
//        studentSet.clear();
//    }
//
//    public void cleatStudent(String email) {
//            studentSet.removeIf(s -> s.getEmail().equals(email));
//
//    }
//
//    public Set<StudentRequest> fetchAllStudents() {
//        return studentSet;
//    }
