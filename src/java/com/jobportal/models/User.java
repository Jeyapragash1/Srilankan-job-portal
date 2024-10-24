package com.jobportal.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String email;
    private String password;
    private String role; // 'student' or 'employer'
    private String name;

    // No-argument constructor
    public User() {}

    // Parameterized constructor
    public User(int id, String email, String password, String role, String name) {
        this.id = id;
        setEmail(email);
        setPassword(password);
        setRole(role);
        setName(name);
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("ID cannot be negative");
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
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
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
        // Here you should encrypt the password before storing it
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role == null || (!role.equals("student") && !role.equals("employer"))) {
            throw new IllegalArgumentException("Role must be either 'student' or 'employer'");
        }
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
               Objects.equals(email, user.email) &&
               Objects.equals(password, user.password) &&
               Objects.equals(role, user.role) &&
               Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, role, name);
    }
}
