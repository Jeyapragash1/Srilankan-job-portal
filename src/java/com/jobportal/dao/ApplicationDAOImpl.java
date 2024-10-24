package com.jobportal.dao;

import com.jobportal.models.Application;
import com.jobportal.utils.DBConnection;

import java.sql.Connection;
import java.sql.Date; // Use java.sql.Date for SQL DATE type
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationDAOImpl implements ApplicationDAO {
    private static final Logger LOGGER = Logger.getLogger(ApplicationDAOImpl.class.getName());
    private Connection connection;

    public ApplicationDAOImpl() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public boolean saveApplication(Application application) throws SQLException {
        String query = "INSERT INTO applications (student_id, job_id, status, application_date, cover_letter_path) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, application.getStudentId());
            pstmt.setInt(2, application.getJobId());
            pstmt.setString(3, application.getStatus());
            pstmt.setDate(4, Date.valueOf(application.getApplicationDate())); // Convert LocalDate to java.sql.Date
            pstmt.setString(5, application.getCoverLetterPath());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error saving application", e);
            throw e;
        }
    }

    @Override
    public Application getApplicationById(int id) throws SQLException {
        String query = "SELECT * FROM applications WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Application application = new Application();
                    application.setId(rs.getInt("id"));
                    application.setStudentId(rs.getInt("student_id"));
                    application.setJobId(rs.getInt("job_id"));
                    application.setStatus(rs.getString("status"));
                    application.setApplicationDate(rs.getDate("application_date").toLocalDate()); // Convert java.sql.Date to LocalDate
                    application.setCoverLetterPath(rs.getString("cover_letter_path"));
                    return application;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting application by ID", e);
            throw e;
        }
        return null;
    }

    @Override
    public List<Application> getApplicationsByStudentId(int studentId) throws SQLException {
        String query = "SELECT * FROM applications WHERE student_id = ?";
        List<Application> applications = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, studentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Application application = new Application();
                    application.setId(rs.getInt("id"));
                    application.setStudentId(rs.getInt("student_id"));
                    application.setJobId(rs.getInt("job_id"));
                    application.setStatus(rs.getString("status"));
                    application.setApplicationDate(rs.getDate("application_date").toLocalDate()); // Convert java.sql.Date to LocalDate
                    application.setCoverLetterPath(rs.getString("cover_letter_path"));
                    applications.add(application);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting applications by student ID", e);
            throw e;
        }
        return applications;
    }

    @Override
    public List<Application> getApplicationsByJobId(int jobId) throws SQLException {
        String query = "SELECT * FROM applications WHERE job_id = ?";
        List<Application> applications = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, jobId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Application application = new Application();
                    application.setId(rs.getInt("id"));
                    application.setStudentId(rs.getInt("student_id"));
                    application.setJobId(rs.getInt("job_id"));
                    application.setStatus(rs.getString("status"));
                    application.setApplicationDate(rs.getDate("application_date").toLocalDate()); // Convert java.sql.Date to LocalDate
                    application.setCoverLetterPath(rs.getString("cover_letter_path"));
                    applications.add(application);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting applications by job ID", e);
            throw e;
        }
        return applications;
    }

    @Override
    public boolean updateApplicationStatus(int id, String status) throws SQLException {
        String query = "UPDATE applications SET status = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating application status", e);
            throw e;
        }
    }

    @Override
    public boolean deleteApplication(int id) throws SQLException {
        String query = "DELETE FROM applications WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting application", e);
            throw e;
        }
    }
}
