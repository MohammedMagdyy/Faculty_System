package com.pioneers.rest.services;

import com.pioneers.rest.models.dtos.faculty_system.StudentRequest;
import com.pioneers.rest.repositories.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void setStudent(StudentRequest student) {
        studentRepository.save(student);
    }

    public StudentRequest findByEmailAndPassword(String email, String password) {
        return studentRepository.findByEmailAndPassword(email, password);
    }

    public Set<StudentRequest> fetchAllStudents() {
        return studentRepository.findAll();
    }

    public void clearAllStudents() {
        studentRepository.deleteAll();
    }

    public void clearStudentByEmail(String email) {
        studentRepository.deleteByEmail(email);
    }

    public StudentRequest getFirstStudent() {
        StudentRequest firstStudent = studentRepository.findFirst();

        if (firstStudent == null) {
            return null;
        }
        return firstStudent;
    }

    public StudentRequest EditStudent(String email,StudentRequest student) {
            StudentRequest updated = studentRepository.updateStudent(email, student);

            if (updated == null) {
                return null;
            }
            return updated;
    }
}