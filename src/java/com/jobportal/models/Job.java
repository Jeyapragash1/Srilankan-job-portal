package com.jobportal.models;

import java.io.Serializable;
import java.util.Objects;

public class Job implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String description;
    private String location;
    private String requirements;
    private int employerId;

    // No-argument constructor
    public Job() {}

    // Parameterized constructor
    public Job(int id, String title, String description, String location, String requirements, int employerId) {
        this.id = id;
        setTitle(title);
        setDescription(description);
        setLocation(location);
        setRequirements(requirements);
        setEmployerId(employerId);
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("ID cannot be negative");
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be null or empty");
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) throw new IllegalArgumentException("Description cannot be null or empty");
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location == null || location.isEmpty()) throw new IllegalArgumentException("Location cannot be null or empty");
        this.location = location;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        if (requirements == null || requirements.isEmpty()) throw new IllegalArgumentException("Requirements cannot be null or empty");
        this.requirements = requirements;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        if (employerId < 0) throw new IllegalArgumentException("Employer ID cannot be negative");
        this.employerId = employerId;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", requirements='" + requirements + '\'' +
                ", employerId=" + employerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id && employerId == job.employerId && 
               Objects.equals(title, job.title) && 
               Objects.equals(description, job.description) && 
               Objects.equals(location, job.location) && 
               Objects.equals(requirements, job.requirements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, location, requirements, employerId);
    }
}
