package com.jobportal.dao;

import com.jobportal.models.Admin;
import com.jobportal.models.User;
import com.jobportal.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminDaoImpl implements AdminDao {
    
    private static final Logger LOGGER = Logger.getLogger(AdminDaoImpl.class.getName());

    private Connection connection;

    public AdminDaoImpl() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public Admin getAdminById(int id) throws SQLException {
        Admin admin = null;
        String query = "SELECT * FROM Admins WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    admin = new Admin();
                    admin.setId(rs.getInt("id"));
                    admin.setEmail(rs.getString("email"));
                    admin.setPassword(rs.getString("password"));
                    admin.setRole(rs.getString("role"));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting admin by ID", e);
            throw e;
        }
        return admin;
    }

    @Override
    public Admin getAdminByEmail(String email) throws SQLException {
        Admin admin = null;
        String query = "SELECT * FROM Admins WHERE email = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    admin = new Admin();
                    admin.setId(rs.getInt("id"));
                    admin.setEmail(rs.getString("email"));
                    admin.setPassword(rs.getString("password"));
                    admin.setRole(rs.getString("role"));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting admin by email", e);
            throw e;
        }
        return admin;
    }

    @Override
    public boolean addAdmin(Admin admin) throws SQLException {
        String query = "INSERT INTO Admins (email, password, role) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, admin.getEmail());
            ps.setString(2, admin.getPassword());
            ps.setString(3, admin.getRole());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding admin", e);
            throw e;
        }
    }

    @Override
    public boolean updateAdmin(Admin admin) throws SQLException {
        String query = "UPDATE Admins SET email = ?, password = ?, role = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, admin.getEmail());
            ps.setString(2, admin.getPassword());
            ps.setString(3, admin.getRole());
            ps.setInt(4, admin.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating admin", e);
            throw e;
        }
    }

    @Override
    public boolean deleteAdmin(int id) throws SQLException {
        String query = "DELETE FROM Admins WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting admin", e);
            throw e;
        }
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM Users";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting all users", e);
            throw e;
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        String query = "DELETE FROM Users WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting user", e);
            throw e;
        }
    }

    @Override
    public int getTotalUsers() {
        String query = "SELECT COUNT(*) FROM Users";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting total users", e);
        }
        return 0;
    }

    @Override
    public int getTotalJobs() {
        String query = "SELECT COUNT(*) FROM Jobs";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting total jobs", e);
        }
        return 0;
    }
}
