package com.pioneers.rest.controllers;

import com.pioneers.rest.helperclass.MapToResponse;
import com.pioneers.rest.models.dtos.GeneralResponse;
import com.pioneers.rest.models.dtos.faculty_system.StudentRequest;
import com.pioneers.rest.models.dtos.faculty_system.StudentResponse;
import com.pioneers.rest.services.StudentService;
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

    @GetMapping("/register")
    public GeneralResponse<StudentResponse> registerStudent(
            @RequestBody StudentRequest studentRequest) {

        studentService.setStudent(studentRequest);

        return success(
                MapToResponse.mapToResponse(studentRequest)
        );
    }

    @GetMapping("/login")
    public GeneralResponse<StudentResponse> login(
            @RequestParam String email,
            @RequestParam String password) {

        return success(
                MapToResponse.mapToResponse(
                        studentService.findByEmailAndPassword(email, password)
                )
        );
    }

    @GetMapping("/update")
    public GeneralResponse<StudentResponse> updateStudent(
            @RequestParam String email,
            @RequestBody StudentRequest studentRequest) {

        return success(MapToResponse.mapToResponse(studentService.EditStudent(email,studentRequest)));
    }

    @GetMapping("/getFirst")
    public GeneralResponse<StudentResponse> getFirstStudent() {
        StudentRequest student = studentService.getFirstStudent();

        if (student == null) {
            return failure("No students found");
        }

        return success(
                MapToResponse.mapToResponse(student)
        );
    }

    @GetMapping("/clearAll")
    public GeneralResponse<Void> clearAllStudents() {
        studentService.clearAllStudents();
        return success(null);
    }

    @GetMapping("/clearStudent")
    public GeneralResponse<Void> clearStudent(
            @RequestParam String email) {

        studentService.clearStudentByEmail(email);
        return success(null);
    }

    @GetMapping("/fetchAll")
    public GeneralResponse<Set<StudentRequest>> fetchAllStudents() {

        return success(
                studentService.fetchAllStudents()
        );
    }

    private <T> GeneralResponse<T> success(T data) {
        GeneralResponse<T> response = new GeneralResponse<>();
        response.setStatus(200);
        response.setMessage("Success");
        response.setData(data);
        return response;
    }

    private <T> GeneralResponse<T> failure(String message) {
        GeneralResponse<T> response = new GeneralResponse<>();
        response.setStatus(404);
        response.setMessage(message);
        response.setData(null);
        return response;
    }
}

