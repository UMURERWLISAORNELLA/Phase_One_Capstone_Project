package org.example.DAO;

import org.example.DatabaseConnection;
import org.example.model.Course;
import java.sql.*;

public class CourseDAO {

    public void listCourses() {
        String sql = "SELECT * FROM courses";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("---- COURSE LIST ----");
            while (rs.next()) {
                System.out.println(rs.getInt("course_id") + " | " +
                        rs.getString("course_name") + " | " +
                        rs.getInt("credits"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCourse(String name, int credits) {
        String sql = "INSERT INTO courses (course_name, credits) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, credits);
            stmt.executeUpdate();
            System.out.println(" Course added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(int id) {
        String sql = "DELETE FROM courses WHERE course_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println(" Course deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(Course c) {
        String sql = "UPDATE courses SET course_name=?, credits=? WHERE course_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getCourseName());
            stmt.setInt(2, c.getCredits());
            stmt.setInt(3, c.getCourseId());
            stmt.executeUpdate();
            System.out.println(" Course updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Course getCourseById(int id) {
        String sql = "SELECT * FROM courses WHERE course_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Course(rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getInt("credits"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
