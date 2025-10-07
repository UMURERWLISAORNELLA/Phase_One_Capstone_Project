package org.example.model;

public class Course {
    private int courseId;
    private String courseName;
    private int credits;

    public Course(int courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public Course(String courseName, int credits) {
        this.courseName = courseName;
        this.credits = credits;
    }

    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }

    public void setCourseId(int courseId) { this.courseId = courseId; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setCredits(int credits) { this.credits = credits; }
}
