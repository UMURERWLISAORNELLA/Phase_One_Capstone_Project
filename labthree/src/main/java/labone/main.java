package labone;

import java.util.*;

public class main {
    public static void main(String[] args) {

        //  Step 1: Create instructors
        Instructor ben = new Instructor("Mr. Ben", "ben@school.com", "T201", "Math");
        Instructor jane = new Instructor("Ms. Jane", "jane@school.com", "T202", "Physics");

        //  Step 2: Map to store instructors by ID
        Map<String, Instructor> instructorMap = new HashMap<>();
        instructorMap.put(ben.getInstructorId(), ben);
        instructorMap.put(jane.getInstructorId(), jane);

        // Step 3: Create courses
        Course mathCourse = new Course("MTH101", "Basic Mathematics", ben);
        Course physicsCourse = new Course("PHY102", "Physics Fundamentals", jane);

        // Assign courses to instructors
        ben.addCourse(mathCourse);
        jane.addCourse(physicsCourse);
        //  Step 4: Create some students
        Student alice = new UndergraduateStudent("Alice", "alice@school.com", "S101", 85);
        Student bob = new GraduateStudent("Bob", "bob@school.com", "S102", 90);

        // Enroll them
        mathCourse.enrollStudent(alice);
        physicsCourse.enrollStudent(bob);

        //  Step 5: Put all courses into a list for easy access
        List<Course> allCourses = new ArrayList<>();
        allCourses.add(mathCourse);
        allCourses.add(physicsCourse);

        //  Step 6: Menu system
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n UNIVERSITY STUDENT MANAGEMENT SYSTEM MENU ");
            System.out.println("1. View all instructors");
            System.out.println("2. View all courses and enrolled students");
            System.out.println("3. Enroll a new student into a course");
            System.out.println("4. Look up an instructor by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = input.nextInt();
            input.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.println("\n Instructors:");
                    for (Instructor i : instructorMap.values()) {
                        System.out.println(i);
                    }
                    break;

                case 2:
                    System.out.println("\n Courses and Enrolled Students:");
                    for (Course c : allCourses) {
                        c.showRoster();
                    }
                    break;

                case 3:
                    System.out.println("\n Enroll New Student");
                    System.out.print("Enter student name: ");
                    String name = input.nextLine();
                    System.out.print("Enter student email: ");
                    String email = input.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentId = input.nextLine();
                    System.out.print("Enter student grade (0–100): ");
                    int grade = input.nextInt();
                    input.nextLine();

                    System.out.print("Is the student Undergraduate or Graduate (U/G)? ");
                    String type = input.nextLine().trim().toUpperCase();

                    Student newStudent;
                    if (type.equals("G")) {
                        newStudent = new GraduateStudent(name, email, studentId, grade);
                    } else {
                        newStudent = new UndergraduateStudent(name, email, studentId, grade);
                    }
                    System.out.println("\nAvailable courses:");
                    for (int i = 0; i < allCourses.size(); i++) {
                        System.out.println((i + 1) + ". " + allCourses.get(i).getCourseName());
                    }
                    System.out.print("Choose a course number to enroll: ");
                    int courseChoice = input.nextInt();
                    input.nextLine();

                    if (courseChoice >= 1 && courseChoice <= allCourses.size()) {
                        allCourses.get(courseChoice - 1).enrollStudent(newStudent);
                        System.out.println(" Student enrolled successfully!");
                    } else {
                        System.out.println("Invalid course choice.");
                    }
                    break;
                case 4:
                    System.out.print("\nEnter Instructor ID to look up: ");
                    String id = input.nextLine();
                    Instructor found = instructorMap.get(id);
                    if (found != null) {
                        System.out.println("Instructor found: " + found);
                    } else {
                        System.out.println(" Instructor not found.");
                    }
                    break;

                case 5:
                    System.out.println("\nExiting system... Goodbye!");
                    break;

                default:
                    System.out.println(" Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);

        input.close();
    }
}


