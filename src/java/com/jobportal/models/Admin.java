package com.jobportal.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String email;
    private String password;
    private String role;

    // No-argument constructor
    public Admin() {}

    // Parameterized constructor
    public Admin(int id, String email, String password, String role) {
        this.id = id;
        setEmail(email);
        setPassword(password);
        this.role = role;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (email != null && pattern.matcher(email).matches()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 8) {
            this.password = password; // Ideally, you should encrypt the password before storing it
        } else {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role != null && !role.isEmpty()) {
            this.role = role;
        } else {
            throw new IllegalArgumentException("Role cannot be null or empty");
        }
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return id == admin.id && Objects.equals(email, admin.email) && Objects.equals(password, admin.password) && Objects.equals(role, admin.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, role);
    }
}
