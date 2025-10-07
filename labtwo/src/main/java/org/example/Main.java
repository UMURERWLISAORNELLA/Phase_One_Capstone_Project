package org.example;

import org.example.DAO.*;
import org.example.model.Student;
import org.example.model.Course;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

        while (true) {
            System.out.println("\n===== SCHOOL DATABASE MENU =====");
            System.out.println("1. Insert Student");
            System.out.println("2. List Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Get Student by ID");
            System.out.println("6. Insert Course");
            System.out.println("7. List Courses");
            System.out.println("8. Update Course");
            System.out.println("9. Delete Course");
            System.out.println("10. Get Course by ID");
            System.out.println("11. Insert Enrollment");
            System.out.println("12. List Enrollments");
            System.out.println("13. Update Enrollment");
            System.out.println("14. Delete Enrollment");
            System.out.println("15. Get Enrollment by ID");
            System.out.println("16. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                // ---------------- STUDENT ----------------
                case 1:
                    sc.nextLine();
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student email: ");
                    String email = sc.nextLine();
                    studentDAO.insertStudent(name, email);
                    break;

                case 2:
                    studentDAO.listStudents();
                    break;

                case 3:
                    System.out.print("Enter student ID to update: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();
                    Student updatedStudent = new Student(sid, newName, newEmail);
                    studentDAO.updateStudent(updatedStudent);
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int delSid = sc.nextInt();
                    studentDAO.deleteStudent(delSid);
                    break;

                case 5:
                    System.out.print("Enter student ID to view: ");
                    int getSid = sc.nextInt();
                    Student foundStudent = studentDAO.getStudentById(getSid);
                    if (foundStudent != null) {
                        System.out.println("ID: " + foundStudent.getStudentId() +
                                " | Name: " + foundStudent.getName() +
                                " | Email: " + foundStudent.getEmail());
                    } else {
                        System.out.println(" Student not found!");
                    }
                    break;

                // ---------------- COURSE ----------------
                case 6:
                    sc.nextLine();
                    System.out.print("Enter course name: ");
                    String courseName = sc.nextLine();
                    System.out.print("Enter course credits: ");
                    int credits = sc.nextInt();
                    courseDAO.insertCourse(courseName, credits);
                    break;

                case 7:
                    courseDAO.listCourses();
                    break;

                case 8:
                    System.out.print("Enter course ID to update: ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new course name: ");
                    String newCourseName = sc.nextLine();
                    System.out.print("Enter new credits: ");
                    int newCredits = sc.nextInt();
                    Course updatedCourse = new Course(cid, newCourseName, newCredits);
                    courseDAO.updateCourse(updatedCourse);
                    break;

                case 9:
                    System.out.print("Enter course ID to delete: ");
                    int delCid = sc.nextInt();
                    courseDAO.deleteCourse(delCid);
                    break;

                case 10:
                    System.out.print("Enter course ID to view: ");
                    int getCid = sc.nextInt();
                    Course foundCourse = courseDAO.getCourseById(getCid);
                    if (foundCourse != null) {
                        System.out.println("ID: " + foundCourse.getCourseId() +
                                " | Name: " + foundCourse.getCourseName() +
                                " | Credits: " + foundCourse.getCredits());
                    } else {
                        System.out.println(" Course not found!");
                    }
                    break;

                // ---------------- ENROLLMENT ----------------
                case 11:
                    System.out.print("Enter student ID: ");
                    int esid = sc.nextInt();
                    System.out.print("Enter course ID: ");
                    int ecid = sc.nextInt();
                    enrollmentDAO.insertEnrollment(esid, ecid);
                    break;

                case 12:
                    enrollmentDAO.listEnrollments();
                    break;

                case 13:
                    System.out.print("Enter enrollment ID to update: ");
                    int eid = sc.nextInt();
                    System.out.print("Enter new course ID: ");
                    int newCourseId = sc.nextInt();
                    enrollmentDAO.updateEnrollment(eid, newCourseId);
                    break;

                case 14:
                    System.out.print("Enter enrollment ID to delete: ");
                    int delEid = sc.nextInt();
                    enrollmentDAO.deleteEnrollment(delEid);
                    break;

                case 15:
                    System.out.print("Enter enrollment ID to view: ");
                    int getEid = sc.nextInt();
                    enrollmentDAO.getEnrollmentById(getEid);
                    break;

                case 16:
                    System.out.println(" Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid choice, please try again.");
            }
        }
    }
}
