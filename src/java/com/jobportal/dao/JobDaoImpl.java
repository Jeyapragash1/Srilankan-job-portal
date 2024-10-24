package com.jobportal.dao;

import com.jobportal.models.Job;
import com.jobportal.utils.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of JobDao interface for managing job entities.
 */
public class JobDaoImpl implements JobDao {
    private static final Logger logger = LoggerFactory.getLogger(JobDaoImpl.class);

    private final Connection connection;

    public JobDaoImpl() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public boolean saveJob(Job job) {
        String query = "INSERT INTO jobs (title, description, location, requirements, employer_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, job.getTitle());
            pstmt.setString(2, job.getDescription());
            pstmt.setString(3, job.getLocation());
            pstmt.setString(4, job.getRequirements());
            pstmt.setInt(5, job.getEmployerId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error saving job: {}", job, e);
            return false;
        }
    }

    @Override
    public Job getJobById(int id) {
        String query = "SELECT * FROM jobs WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToJob(rs);
                }
            }
        } catch (SQLException e) {
            logger.error("Error getting job by ID: {}", id, e);
        }
        return null;
    }

    @Override
    public List<Job> getJobsByEmployerId(int employerId) {
        String query = "SELECT * FROM jobs WHERE employer_id = ?";
        List<Job> jobs = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, employerId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    jobs.add(mapResultSetToJob(rs));
                }
            }
        } catch (SQLException e) {
            logger.error("Error getting jobs by employer ID: {}", employerId, e);
        }
        return jobs;
    }

    @Override
    public List<Job> searchJobs(String title, String location, String requirements) {
        String query = "SELECT * FROM jobs WHERE title LIKE ? AND location LIKE ? AND requirements LIKE ?";
        List<Job> jobs = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, "%" + title + "%");
            pstmt.setString(2, "%" + location + "%");
            pstmt.setString(3, "%" + requirements + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    jobs.add(mapResultSetToJob(rs));
                }
            }
        } catch (SQLException e) {
            logger.error("Error searching jobs with title: {}, location: {}, requirements: {}", title, location, requirements, e);
        }
        return jobs;
    }

    @Override
    public boolean updateJob(Job job) {
        String query = "UPDATE jobs SET title = ?, description = ?, location = ?, requirements = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, job.getTitle());
            pstmt.setString(2, job.getDescription());
            pstmt.setString(3, job.getLocation());
            pstmt.setString(4, job.getRequirements());
            pstmt.setInt(5, job.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error updating job: {}", job, e);
            return false;
        }
    }

    @Override
    public boolean deleteJob(int id) {
        String query = "DELETE FROM jobs WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error deleting job with ID: {}", id, e);
            return false;
        }
    }

    private Job mapResultSetToJob(ResultSet rs) throws SQLException {
        Job job = new Job();
        job.setId(rs.getInt("id"));
        job.setTitle(rs.getString("title"));
        job.setDescription(rs.getString("description"));
        job.setLocation(rs.getString("location"));
        job.setRequirements(rs.getString("requirements"));
        job.setEmployerId(rs.getInt("employer_id"));
        return job;
    }
}
