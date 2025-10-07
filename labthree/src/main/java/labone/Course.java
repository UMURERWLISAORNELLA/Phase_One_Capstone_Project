package labone;


import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private String courseName;
    private Instructor instructor;
    private List<Student> enrolledStudents = new ArrayList<>();

    public Course(String courseCode, String courseName, Instructor instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    // Getters and setters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }
    public Instructor getInstructor() {
        return instructor;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    // Manage enrollments
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }
    public void showRoster() {
        System.out.println("\nCourse: " + courseName + " (" + courseCode + ")");
        System.out.println("Instructor: " + instructor.getName());
        System.out.println("Enrolled Students:");
        for (Student s : enrolledStudents) {
            System.out.println("  - " + s);
        }
    }

    public String toString() {
        return "Course [Code: " + courseCode +
                ", Name: " + courseName +
                ", Instructor: " + instructor.getName() + "]";
    }
}

