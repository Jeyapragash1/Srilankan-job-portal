package com.jobportal.dao;

import com.jobportal.models.Admin;
import com.jobportal.models.User;
import java.sql.SQLException;
import java.util.List;

/**
 * Interface for Admin DAO operations.
 */
public interface AdminDao {

    /**
     * Retrieves an admin by their ID.
     *
     * @param id the admin ID
     * @return the admin object
     * @throws SQLException if a database access error occurs
     */
    Admin getAdminById(int id) throws SQLException;

    /**
     * Retrieves an admin by their email.
     *
     * @param email the admin email
     * @return the admin object
     * @throws SQLException if a database access error occurs
     */
    Admin getAdminByEmail(String email) throws SQLException;

    /**
     * Adds a new admin.
     *
     * @param admin the admin object to add
     * @return true if the admin was added successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean addAdmin(Admin admin) throws SQLException;

    /**
     * Updates an existing admin.
     *
     * @param admin the admin object to update
     * @return true if the admin was updated successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean updateAdmin(Admin admin) throws SQLException;

    /**
     * Deletes an admin by their ID.
     *
     * @param id the admin ID
     * @return true if the admin was deleted successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean deleteAdmin(int id) throws SQLException;

    /**
     * Retrieves all users.
     *
     * @return a list of user objects
     * @throws SQLException if a database access error occurs
     */
    List<User> getAllUsers() throws SQLException;

    /**
     * Deletes a user by their ID.
     *
     * @param id the user ID
     * @return true if the user was deleted successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean deleteUser(int id) throws SQLException;

    /**
     * Gets the total number of users.
     *
     * @return the total number of users
     */
    int getTotalUsers();

    /**
     * Gets the total number of jobs.
     *
     * @return the total number of jobs
     */
    int getTotalJobs();
}

