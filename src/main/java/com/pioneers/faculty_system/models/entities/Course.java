package com.pioneers.faculty_system.models.entities;

import java.util.Objects;

public class Course {

    private static int counter = 1;   // shared counter
    private final int courseID;       // unique per object
    private String courseName;

    public Course(String courseName) {
        this.courseID = counter++;   // assign then increment
        this.courseName = courseName;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return courseID == course.courseID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseID);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
