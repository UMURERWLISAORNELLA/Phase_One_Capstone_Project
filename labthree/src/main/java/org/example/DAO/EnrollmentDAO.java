package org.example.DAO;

import org.example.DatabaseConnection;
import java.sql.*;

public class EnrollmentDAO {
    public void insertEnrollment(int studentId, int courseId) {
        String sql = "INSERT INTO enrollments(student_id, course_id) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            stmt.executeUpdate();
            System.out.println(" Enrollment added!");
        } catch (SQLException e) {
            System.out.println(" Error inserting enrollment: " + e.getMessage());
        }
    }

    public void listEnrollments() {
        String sql = "SELECT e.enrollment_id, s.name, c.course_name FROM enrollments e " +
                "JOIN students s ON e.student_id = s.student_id " +
                "JOIN courses c ON e.course_id = c.course_id";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- ENROLLMENTS ---");
            while (rs.next()) {
                System.out.println(rs.getInt("enrollment_id") + " | " + rs.getString("name") + " → " + rs.getString("course_name"));
            }
        } catch (SQLException e) {
            System.out.println(" Error listing enrollments: " + e.getMessage());
        }
    }

    public void updateEnrollment(int enrollmentId, int newCourseId) {
        String sql = "UPDATE enrollments SET course_id=? WHERE enrollment_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, newCourseId);
            stmt.setInt(2, enrollmentId);
            stmt.executeUpdate();
            System.out.println(" Enrollment updated!");
        } catch (SQLException e) {
            System.out.println(" Error updating enrollment: " + e.getMessage());
        }
    }

    public void deleteEnrollment(int id) {
        String sql = "DELETE FROM enrollments WHERE enrollment_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println(" Enrollment deleted!");
        } catch (SQLException e) {
            System.out.println(" Error deleting enrollment: " + e.getMessage());
        }
    }

    public void getEnrollmentById(int id) {
        String sql = "SELECT e.enrollment_id, s.name, c.course_name FROM enrollments e " +
                "JOIN students s ON e.student_id = s.student_id " +
                "JOIN courses c ON e.course_id = c.course_id WHERE e.enrollment_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Enrollment: " + rs.getInt("enrollment_id") + " | " +
                        rs.getString("name") + " → " + rs.getString("course_name"));
            } else {
                System.out.println(" Enrollment not found!");
            }
        } catch (SQLException e) {
            System.out.println(" Error fetching enrollment: " + e.getMessage());
        }
    }
}
