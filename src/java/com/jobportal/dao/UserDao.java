package com.jobportal.dao;

import com.jobportal.models.User;
import java.sql.SQLException;

/**
 * Interface for User DAO operations.
 */
public interface UserDao {
    
    /**
     * Retrieves a user by their email.
     *
     * @param email the user's email
     * @return the user object
     * @throws SQLException if a database access error occurs
     */
    User getUserByEmail(String email) throws SQLException;
    
    /**
     * Retrieves a user by their ID.
     *
     * @param id the user ID
     * @return the user object
     * @throws SQLException if a database access error occurs
     */
    User getUserById(int id) throws SQLException;
    
    /**
     * Adds a new user.
     *
     * @param user the user object to add
     * @return true if the user was added successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean addUser(User user) throws SQLException;
    
    /**
     * Updates an existing user.
     *
     * @param user the user object to update
     * @return true if the user was updated successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean updateUser(User user) throws SQLException;
    
    /**
     * Deletes a user by their ID.
     *
     * @param id the user ID
     * @return true if the user was deleted successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean deleteUser(int id) throws SQLException;
}
