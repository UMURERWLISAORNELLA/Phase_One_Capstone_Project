package labone;

import java.util.HashSet;
import java.util.Set;

public class Instructor extends Person{

    private String instructorId;
    private String subject;
    private Set<Course> coursesTaught = new HashSet<>();

    public Instructor(String name, String email, String instructorId, String subject) {
        super(name, email);
        this.instructorId = instructorId;
        this.subject = subject;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Manage courses taught
    public void addCourse(Course course) {
        coursesTaught.add(course);
    }

    public Set<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public String toString() {
        return "Instructor [" + super.toString() +
                ", Instructor ID: " + instructorId +
                ", Subject: " + subject + "]";
    }
}
