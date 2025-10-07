package org.example.DAO;

import org.example.DatabaseConnection;
import org.example.model.Course;
import java.sql.*;

public class CourseDAO {
    public void insertCourse(String name, int credits) {
        String sql = "INSERT INTO courses(course_name, credits) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, credits);
            stmt.executeUpdate();
            System.out.println(" Course added successfully!");
        } catch (SQLException e) {
            System.out.println(" Error inserting course: " + e.getMessage());
        }
    }

    public void listCourses() {
        String sql = "SELECT * FROM courses";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- COURSES ---");
            while (rs.next()) {
                System.out.println(rs.getInt("course_id") + " | " + rs.getString("course_name") + " | Credits: " + rs.getInt("credits"));
            }
        } catch (SQLException e) {
            System.out.println(" Error listing courses: " + e.getMessage());
        }
    }

    public void updateCourse(Course course) {
        String sql = "UPDATE courses SET course_name=?, credits=? WHERE course_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, course.getCourseName());
            stmt.setInt(2, course.getCredits());
            stmt.setInt(3, course.getCourseId());
            stmt.executeUpdate();
            System.out.println(" Course updated!");
        } catch (SQLException e) {
            System.out.println(" Error updating course: " + e.getMessage());
        }
    }

    public void deleteCourse(int id) {
        String sql = "DELETE FROM courses WHERE course_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println(" Course deleted!");
        } catch (SQLException e) {
            System.out.println(" Error deleting course: " + e.getMessage());
        }
    }

    public Course getCourseById(int id) {
        String sql = "SELECT * FROM courses WHERE course_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Course(rs.getInt("course_id"), rs.getString("course_name"), rs.getInt("credits"));
            }
        } catch (SQLException e) {
            System.out.println(" Error fetching course: " + e.getMessage());
        }
        return null;
    }
}
