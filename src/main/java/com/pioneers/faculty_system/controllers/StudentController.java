package com.pioneers.faculty_system.controllers;

import com.pioneers.faculty_system.helperclass.MapToResponse;
import com.pioneers.faculty_system.models.dtos.GeneralResponse;
import com.pioneers.faculty_system.models.dtos.faculty_system.StudentRequest;
import com.pioneers.faculty_system.models.dtos.faculty_system.StudentResponse;
import com.pioneers.faculty_system.services.StudentService;
import com.pioneers.faculty_system.helperclass.ServerResponse;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

/**
 * Create a controller layer with multiple APIs for our university site as the following APIs:
 * 1- register student (first name, last name, email, phone number, password)
 * 2- login student into his account by (email, password)
 * 3- fetch all students who registered in the site
 * 4- delete all students in our system
 * 5- delete particular student from the system by his email
 * 6- find the first student who registered in the site
 * 7- update student information in the site
 * <p/>
 * Note: Don't touch the services, repositories packages
 * Note: Don't use any kind of database
 **/

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/update")
    public GeneralResponse<StudentResponse> updateStudent(
            @RequestParam String email,
            @RequestBody StudentRequest studentRequest) {

        return ServerResponse.success(MapToResponse.mapToResponse(studentService.EditStudent(email,studentRequest)));
    }

    @GetMapping("/getFirst")
    public GeneralResponse<StudentResponse> getFirstStudent() {
        StudentRequest student = studentService.getFirstStudent();

        if (student == null) {
            return ServerResponse.failure("No students found");
        }

        return ServerResponse.success(
                MapToResponse.mapToResponse(student)
        );
    }

    @GetMapping("/clearAll")
    public GeneralResponse<Void> clearAllStudents() {
        studentService.clearAllStudents();
        return ServerResponse.success(null);
    }

    @GetMapping("/clearStudent")
    public GeneralResponse<Void> clearStudent(
            @RequestParam String email) {

        studentService.clearStudentByEmail(email);
        return ServerResponse.success(null);
    }

    @GetMapping("/fetchAll")
    public GeneralResponse<Set<StudentRequest>> fetchAllStudents() {

        return ServerResponse.success(
                studentService.fetchAllStudents()
        );
    }


}

