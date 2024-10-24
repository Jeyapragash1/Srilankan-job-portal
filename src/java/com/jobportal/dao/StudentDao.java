package com.jobportal.dao;

import com.jobportal.models.Student;
import java.sql.SQLException;

/**
 * Interface for Student DAO operations.
 */
public interface StudentDao {
    
    /**
     * Adds a new student.
     *
     * @param student the student object to add
     * @return true if the student was added successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean addStudent(Student student) throws SQLException;
    
    /**
     * Retrieves a student by their ID.
     *
     * @param id the student ID
     * @return the student object
     * @throws SQLException if a database access error occurs
     */
    Student getStudentById(int id) throws SQLException;
    
    /**
     * Updates an existing student.
     *
     * @param student the student object to update
     * @return true if the student was updated successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean updateStudent(Student student) throws SQLException;
    
    /**
     * Deletes a student by their ID.
     *
     * @param id the student ID
     * @return true if the student was deleted successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    boolean deleteStudent(int id) throws SQLException;
}
