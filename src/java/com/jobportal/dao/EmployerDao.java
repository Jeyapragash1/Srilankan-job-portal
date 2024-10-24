package com.jobportal.dao;

import com.jobportal.models.Employer;
import java.sql.SQLException;

/**
 * Interface for Employer DAO operations.
 */
public interface EmployerDao {
    
    /**
     * Retrieves an employer by their ID.
     *
     * @param id the employer ID
     * @return the employer object
     * @throws SQLException if a database access error occurs
     */
    Employer getEmployerById(int id) throws SQLException;
    
    /**
     * Saves a new employer.
     *
     * @param employer the employer object to save
     * @return true if the employer was saved successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean saveEmployer(Employer employer) throws SQLException;
    
    /**
     * Updates an existing employer.
     *
     * @param employer the employer object to update
     * @return true if the employer was updated successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean updateEmployer(Employer employer) throws SQLException;
    
    /**
     * Deletes an employer by their ID.
     *
     * @param id the employer ID
     * @return true if the employer was deleted successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean deleteEmployer(int id) throws SQLException;
}
