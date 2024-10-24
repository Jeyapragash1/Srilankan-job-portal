package com.jobportal.dao;

import com.jobportal.models.Student;
import com.jobportal.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of StudentDao interface for managing student entities.
 */
public class StudentDaoImpl implements StudentDao {
    private static final Logger LOGGER = Logger.getLogger(StudentDaoImpl.class.getName());
    private final Connection connection;

    public StudentDaoImpl() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public boolean addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (name, email, phone, major, graduation_year, resume_path) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getPhone());
            statement.setString(4, student.getMajor());
            statement.setString(5, student.getGraduationYear());
            statement.setString(6, student.getResumePath());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding student", e);
            throw e;
        }
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        String sql = "UPDATE students SET name = ?, email = ?, phone = ?, major = ?, graduation_year = ?, resume_path = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getPhone());
            statement.setString(4, student.getMajor());
            statement.setString(5, student.getGraduationYear());
            statement.setString(6, student.getResumePath());
            statement.setInt(7, student.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating student", e);
            throw e;
        }
    }

    @Override
    public Student getStudentById(int id) throws SQLException {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToStudent(resultSet);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving student", e);
            throw e;
        }
        return null;
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting student", e);
            throw e;
        }
    }

    private Student mapResultSetToStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setPhone(resultSet.getString("phone"));
        student.setMajor(resultSet.getString("major"));
        student.setGraduationYear(resultSet.getString("graduation_year"));
        student.setResumePath(resultSet.getString("resume_path"));
        return student;
    }
}
