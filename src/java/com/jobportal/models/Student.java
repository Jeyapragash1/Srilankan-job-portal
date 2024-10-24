package com.jobportal.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String address;
    private String major;
    private String graduationYear;
    private String resumePath;

    // No-argument constructor
    public Student() {}

    // Parameterized constructor
    public Student(int id, String name, String email, String phone, String username, String password, String address, String major, String graduationYear, String resumePath) {
        this.id = id;
        setName(name);
        setEmail(email);
        setPhone(phone);
        setUsername(username);
        setPassword(password);
        setAddress(address);
        setMajor(major);
        setGraduationYear(graduationYear);
        setResumePath(resumePath);
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("ID cannot be negative");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.isEmpty()) throw new IllegalArgumentException("Phone cannot be null or empty");
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) throw new IllegalArgumentException("Username cannot be null or empty");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
        this.password = password; // Ideally, you should encrypt the password before storing it
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty()) throw new IllegalArgumentException("Address cannot be null or empty");
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if (major == null || major.isEmpty()) throw new IllegalArgumentException("Major cannot be null or empty");
        this.major = major;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        if (graduationYear == null || graduationYear.isEmpty()) throw new IllegalArgumentException("Graduation year cannot be null or empty");
        this.graduationYear = graduationYear;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        if (resumePath == null || resumePath.isEmpty()) throw new IllegalArgumentException("Resume path cannot be null or empty");
        this.resumePath = resumePath;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", major='" + major + '\'' +
                ", graduationYear='" + graduationYear + '\'' +
                ", resumePath='" + resumePath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
               Objects.equals(name, student.name) &&
               Objects.equals(email, student.email) &&
               Objects.equals(phone, student.phone) &&
               Objects.equals(username, student.username) &&
               Objects.equals(password, student.password) &&
               Objects.equals(address, student.address) &&
               Objects.equals(major, student.major) &&
               Objects.equals(graduationYear, student.graduationYear) &&
               Objects.equals(resumePath, student.resumePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, username, password, address, major, graduationYear, resumePath);
    }
}
