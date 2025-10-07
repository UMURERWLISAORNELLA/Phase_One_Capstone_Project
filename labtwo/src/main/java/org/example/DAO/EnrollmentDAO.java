package org.example.DAO;

import org.example.DatabaseConnection;
import java.sql.*;

public class EnrollmentDAO {

    public void updateEnrollment(int enrollmentId, int newCourseId) {
        String sql = "UPDATE enrollments SET course_id = ? WHERE enrollment_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, newCourseId);
            stmt.setInt(2, enrollmentId);
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println(" Enrollment updated successfully!");
            else
                System.out.println(" Enrollment not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertEnrollment(int studentId, int courseId) {
        String sql = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            stmt.executeUpdate();
            System.out.println(" Enrollment added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEnrollment(int id) {
        String sql = "DELETE FROM enrollments WHERE enrollment_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println(" Enrollment deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listEnrollments() {
        String sql = "SELECT * FROM enrollments";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("---- ENROLLMENT LIST ----");
            while (rs.next()) {
                System.out.println(rs.getInt("enrollment_id") + " | Student ID: " +
                        rs.getInt("student_id") + " | Course ID: " +
                        rs.getInt("course_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getEnrollmentById(int id) {
        String sql = "SELECT * FROM enrollments WHERE enrollment_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Enrollment ID: " + rs.getInt("enrollment_id") +
                        ", Student ID: " + rs.getInt("student_id") +
                        ", Course ID: " + rs.getInt("course_id"));
            } else {
                System.out.println("⚠ Enrollment not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
