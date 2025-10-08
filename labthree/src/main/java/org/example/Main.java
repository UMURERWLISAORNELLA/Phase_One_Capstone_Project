package org.example;

import org.example.DAO.*;
import org.example.model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

        while (true) {

            System.out.println(" UNIVERSITY MANAGEMENT SYSTEM");
            System.out.println("===============================");
            System.out.println("1️  Manage Students");
            System.out.println("2️ Manage Courses");
            System.out.println("3 Manage Enrollments");
            System.out.println("0️ Exit");
            System.out.print("➡  Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> manageStudents(scanner, studentDAO);
                case 2 -> manageCourses(scanner, courseDAO);
                case 3 -> manageEnrollments(scanner, enrollmentDAO, studentDAO, courseDAO);
                case 0 -> {
                    System.out.println(" Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println(" Invalid choice! Try again.");
            }
        }
    }


    // STUDENT MANAGEMENT
    // ============================
    private static void manageStudents(Scanner scanner, StudentDAO studentDAO) {
        while (true) {
            System.out.println("\n--- STUDENT MENU ---");
            System.out.println("1️  Insert Student");
            System.out.println("2️  List Students");
            System.out.println("3️ Update Student");
            System.out.println("4  Delete Student");
            System.out.println("0️  Back");
            System.out.print("➡ Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    studentDAO.insertStudent(name, email);
                }
                case 2 -> studentDAO.listStudents();
                case 3 -> {
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String email = scanner.nextLine();
                    studentDAO.updateStudent(new Student(id, name, email));
                }
                case 4 -> {
                    System.out.print("Enter student ID to delete: ");
                    int id = scanner.nextInt();
                    studentDAO.deleteStudent(id);
                }
                case 0 -> { return; }
                default -> System.out.println(" Invalid choice!");
            }
        }
    }

    // COURSE MANAGEMENT
    // ============================
    private static void manageCourses(Scanner scanner, CourseDAO courseDAO) {
        while (true) {
            System.out.println("\n--- COURSE MENU ---");
            System.out.println("1️  Insert Course");
            System.out.println("2️  List Courses");
            System.out.println("3️  Update Course");
            System.out.println("4️  Delete Course");
            System.out.println("0  Back");
            System.out.print("➡  Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter course name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter course credits (3–10): ");
                    int credits = scanner.nextInt();
                    courseDAO.insertCourse(name, credits);
                }
                case 2 -> courseDAO.listCourses();
                case 3 -> {
                    System.out.print("Enter course ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new credits: ");
                    int credits = scanner.nextInt();
                    courseDAO.updateCourse(new Course(id, name, credits));
                }
                case 4 -> {
                    System.out.print("Enter course ID to delete: ");
                    int id = scanner.nextInt();
                    courseDAO.deleteCourse(id);
                }
                case 0 -> { return; }
                default -> System.out.println(" Invalid choice!");
            }
        }
    }


    // ENROLLMENT MANAGEMENT
    // ============================
    private static void manageEnrollments(Scanner scanner, EnrollmentDAO enrollmentDAO,
                                          StudentDAO studentDAO, CourseDAO courseDAO) {
        while (true) {
            System.out.println("\n--- ENROLLMENT MENU ---");
            System.out.println("1️  Enroll Student in Course");
            System.out.println("2️  List Enrollments");
            System.out.println("3️  Update Enrollment (Change Course)");
            System.out.println("4️  Delete Enrollment");
            System.out.println("0️  Back");
            System.out.print("➡  Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("\nAvailable Students:");
                    studentDAO.listStudents();
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();

                    System.out.println("\nAvailable Courses:");
                    courseDAO.listCourses();
                    System.out.print("Enter course ID: ");
                    int courseId = scanner.nextInt();

                    enrollmentDAO.insertEnrollment(studentId, courseId);
                }
                case 2 -> enrollmentDAO.listEnrollments();
                case 3 -> {
                    enrollmentDAO.listEnrollments();
                    System.out.print("Enter enrollment ID to update: ");
                    int enrollmentId = scanner.nextInt();
                    System.out.println("\nAvailable Courses:");
                    courseDAO.listCourses();
                    System.out.print("Enter new course ID: ");
                    int newCourseId = scanner.nextInt();
                    enrollmentDAO.updateEnrollment(enrollmentId, newCourseId);
                }
                case 4 -> {
                    enrollmentDAO.listEnrollments();
                    System.out.print("Enter enrollment ID to delete: ");
                    int id = scanner.nextInt();
                    enrollmentDAO.deleteEnrollment(id);
                }
                case 0 -> { return; }
                default -> System.out.println(" Invalid choice!");
            }
        }
    }
}
