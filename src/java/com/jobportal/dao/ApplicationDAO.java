package com.jobportal.dao;

import com.jobportal.models.Application;
import java.sql.SQLException;
import java.util.List;

/**
 * Interface for Application DAO operations.
 */
public interface ApplicationDAO {
    
    /**
     * Saves a new application.
     *
     * @param application the application object to save
     * @return true if the application was saved successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean saveApplication(Application application) throws SQLException;
    
    /**
     * Retrieves an application by its ID.
     *
     * @param id the application ID
     * @return the application object
     * @throws SQLException if a database access error occurs
     */
    Application getApplicationById(int id) throws SQLException;
    
    /**
     * Retrieves applications by student ID.
     *
     * @param studentId the student ID
     * @return a list of application objects
     * @throws SQLException if a database access error occurs
     */
    List<Application> getApplicationsByStudentId(int studentId) throws SQLException;
    
    /**
     * Retrieves applications by job ID.
     *
     * @param jobId the job ID
     * @return a list of application objects
     * @throws SQLException if a database access error occurs
     */
    List<Application> getApplicationsByJobId(int jobId) throws SQLException;
    
    /**
     * Updates the status of an application.
     *
     * @param id the application ID
     * @param status the new status
     * @return true if the application status was updated successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean updateApplicationStatus(int id, String status) throws SQLException;
    
    /**
     * Deletes an application by its ID.
     *
     * @param id the application ID
     * @return true if the application was deleted successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean deleteApplication(int id) throws SQLException;
}
