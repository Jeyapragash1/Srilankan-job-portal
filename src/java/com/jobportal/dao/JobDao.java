package com.jobportal.dao;

import com.jobportal.models.Job;
import java.sql.SQLException;
import java.util.List;

/**
 * Interface for Job DAO operations.
 */
public interface JobDao {
    
    /**
     * Saves a new job.
     *
     * @param job the job object to save
     * @return true if the job was saved successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean saveJob(Job job) throws SQLException;
    
    /**
     * Retrieves a job by its ID.
     *
     * @param id the job ID
     * @return the job object
     * @throws SQLException if a database access error occurs
     */
    Job getJobById(int id) throws SQLException;
    
    /**
     * Retrieves jobs by employer ID.
     *
     * @param employerId the employer ID
     * @return a list of job objects
     * @throws SQLException if a database access error occurs
     */
    List<Job> getJobsByEmployerId(int employerId) throws SQLException;
    
    /**
     * Searches for jobs based on title, location, and requirements.
     *
     * @param title the job title
     * @param location the job location
     * @param requirements the job requirements
     * @return a list of job objects matching the search criteria
     * @throws SQLException if a database access error occurs
     */
    List<Job> searchJobs(String title, String location, String requirements) throws SQLException;
    
    /**
     * Updates an existing job.
     *
     * @param job the job object to update
     * @return true if the job was updated successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean updateJob(Job job) throws SQLException;
    
    /**
     * Deletes a job by its ID.
     *
     * @param id the job ID
     * @return true if the job was deleted successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean deleteJob(int id) throws SQLException;
}
