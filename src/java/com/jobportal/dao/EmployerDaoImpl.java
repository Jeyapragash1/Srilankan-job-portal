package com.jobportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jobportal.models.Employer;
import com.jobportal.utils.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployerDaoImpl implements EmployerDao {
    private static final Logger logger = LoggerFactory.getLogger(EmployerDaoImpl.class);

    private Connection connection;

    public EmployerDaoImpl() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public Employer getEmployerById(int id) {
        Employer employer = null;
        String query = "SELECT * FROM employers WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    employer = new Employer();
                    employer.setId(rs.getInt("id"));
                    employer.setCompanyName(rs.getString("company_name"));
                    employer.setCompanyDescription(rs.getString("company_description"));
                    employer.setContactEmail(rs.getString("contact_email"));
                    employer.setContactPhone(rs.getString("contact_phone"));
                    employer.setLocation(rs.getString("location"));
                    employer.setWebsite(rs.getString("website"));
                    employer.setLogoPath(rs.getString("logo_path"));
                }
            }
        } catch (SQLException e) {
            logger.error("Error getting employer by ID: {}", id, e);
        }
        return employer;
    }

    @Override
    public boolean saveEmployer(Employer employer) {
        String query = "INSERT INTO employers (company_name, company_description, contact_email, contact_phone, location, website, logo_path) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, employer.getCompanyName());
            stmt.setString(2, employer.getCompanyDescription());
            stmt.setString(3, employer.getContactEmail());
            stmt.setString(4, employer.getContactPhone());
            stmt.setString(5, employer.getLocation());
            stmt.setString(6, employer.getWebsite());
            stmt.setString(7, employer.getLogoPath());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error saving employer: {}", employer, e);
            return false;
        }
    }

    @Override
    public boolean updateEmployer(Employer employer) {
        String query = "UPDATE employers SET company_name = ?, company_description = ?, contact_email = ?, contact_phone = ?, location = ?, website = ?, logo_path = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, employer.getCompanyName());
            stmt.setString(2, employer.getCompanyDescription());
            stmt.setString(3, employer.getContactEmail());
            stmt.setString(4, employer.getContactPhone());
            stmt.setString(5, employer.getLocation());
            stmt.setString(6, employer.getWebsite());
            stmt.setString(7, employer.getLogoPath());
            stmt.setInt(8, employer.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error updating employer: {}", employer, e);
            return false;
        }
    }

    @Override
    public boolean deleteEmployer(int id) {
        String query = "DELETE FROM employers WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error deleting employer with ID: {}", id, e);
            return false;
        }
    }
}
