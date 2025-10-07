package org.example.DAO;

import org.example.DatabaseConnection;
import org.example.model.Student;
import java.sql.*;

public class StudentDAO {
    public void insertStudent(String name, String email) {
        String sql = "INSERT INTO students(name, email) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println(" Student added successfully!");
        } catch (SQLException e) {
            System.out.println(" Error inserting student: " + e.getMessage());
        }
    }

    public void listStudents() {
        String sql = "SELECT * FROM students";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- STUDENTS ---");
            while (rs.next()) {
                System.out.println(rs.getInt("student_id") + " | " + rs.getString("name") + " | " + rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(" Error listing students: " + e.getMessage());
        }
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name=?, email=? WHERE student_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setInt(3, student.getStudentId());
            stmt.executeUpdate();
            System.out.println(" Student updated!");
        } catch (SQLException e) {
            System.out.println(" Error updating student: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE student_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println(" Student deleted!");
        } catch (SQLException e) {
            System.out.println(" Error deleting student: " + e.getMessage());
        }
    }

    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE student_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("student_id"), rs.getString("name"), rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(" Error fetching student: " + e.getMessage());
        }
        return null;
    }
}
