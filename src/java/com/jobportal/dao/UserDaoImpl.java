package com.jobportal.dao;

import com.jobportal.models.User;
import com.jobportal.utils.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
    private final Connection connection;

    public UserDaoImpl() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public User getUserByEmail(String email) throws SQLException {
        User user = null;
        String query = "SELECT * FROM Users WHERE email = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = mapResultSetToUser(rs);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error getting user by email: {}", email, e);
            throw e;
        }
        return user;
    }

    @Override
    public User getUserById(int id) throws SQLException {
        User user = null;
        String query = "SELECT * FROM Users WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = mapResultSetToUser(rs);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error getting user by ID: {}", id, e);
            throw e;
        }
        return user;
    }

    @Override
    public boolean addUser(User user) throws SQLException {
        String query = "INSERT INTO Users (email, password, role) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.error("Error adding user: {}", user, e);
            throw e;
        }
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        String query = "UPDATE Users SET email = ?, password = ?, role = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.setInt(4, user.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.error("Error updating user: {}", user, e);
            throw e;
        }
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        String query = "DELETE FROM Users WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.error("Error deleting user with ID: {}", id, e);
            throw e;
        }
    }

    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        return user;
    }
}
