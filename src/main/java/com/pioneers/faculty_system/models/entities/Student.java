package com.pioneers.faculty_system.models.entities;

import java.util.Objects;

public class Student {
    private static int counter =1;
    private final int studentID;
    private String studentName;

    public Student( String studentName) {
        this.studentID = counter++;
        this.studentName = studentName;
    }

    public int getStudentID() {
        return studentID;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentID == student.studentID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(studentID);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
