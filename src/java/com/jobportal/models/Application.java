package com.jobportal.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Application implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private int studentId;
    private int jobId;
    private String status;
    private LocalDate applicationDate;
    private String coverLetterPath;

    // No-argument constructor
    public Application() {}

    // Parameterized constructor
    public Application(int id, int studentId, int jobId, String status, LocalDate applicationDate, String coverLetterPath) {
        this.id = id;
        this.studentId = studentId;
        this.jobId = jobId;
        setStatus(status);
        this.applicationDate = applicationDate;
        this.coverLetterPath = coverLetterPath;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if (studentId < 0) {
            throw new IllegalArgumentException("Student ID cannot be negative");
        }
        this.studentId = studentId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        if (jobId < 0) {
            throw new IllegalArgumentException("Job ID cannot be negative");
        }
        this.jobId = jobId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
        this.status = status;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        if (applicationDate == null) {
            throw new IllegalArgumentException("Application date cannot be null");
        }
        this.applicationDate = applicationDate;
    }

    public String getCoverLetterPath() {
        return coverLetterPath;
    }

    public void setCoverLetterPath(String coverLetterPath) {
        if (coverLetterPath == null || coverLetterPath.isEmpty()) {
            throw new IllegalArgumentException("Cover letter path cannot be null or empty");
        }
        this.coverLetterPath = coverLetterPath;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", jobId=" + jobId +
                ", status='" + status + '\'' +
                ", applicationDate=" + applicationDate +
                ", coverLetterPath='" + coverLetterPath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return id == that.id && studentId == that.studentId && jobId == that.jobId && Objects.equals(status, that.status) && Objects.equals(applicationDate, that.applicationDate) && Objects.equals(coverLetterPath, that.coverLetterPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, jobId, status, applicationDate, coverLetterPath);
    }
}
