package com.pioneers.faculty_system.controllers;

import com.pioneers.faculty_system.helperclass.MapToResponse;
import com.pioneers.faculty_system.helperclass.ServerResponse;
import com.pioneers.faculty_system.models.dtos.GeneralResponse;
import com.pioneers.faculty_system.models.dtos.faculty_system.StudentRequest;
import com.pioneers.faculty_system.models.dtos.faculty_system.StudentResponse;
import com.pioneers.faculty_system.services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final StudentService studentService;

    public AuthController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/register")
    public GeneralResponse<StudentResponse> registerStudent(
            @RequestBody StudentRequest studentRequest) {

        studentService.setStudent(studentRequest);

        return ServerResponse.success(
                MapToResponse.mapToResponse(studentRequest)
        );
    }

    @GetMapping("/login")
    public GeneralResponse<StudentResponse> login(
            @RequestParam String email,
            @RequestParam String password) {

        return ServerResponse.success(
                MapToResponse.mapToResponse(
                        studentService.findByEmailAndPassword(email, password)
                )
        );
    }

}
