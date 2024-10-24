package com.jobportal.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

public class Employer implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String companyName;
    private String companyDescription;
    private String contactEmail;
    private String contactPhone;
    private String location;
    private String website;
    private String logoPath; // Path to the company logo image

    // No-argument constructor
    public Employer() {}

    // Parameterized constructor
    public Employer(int id, String companyName, String companyDescription, String contactEmail, String contactPhone, String location, String website, String logoPath) {
        this.id = id;
        setCompanyName(companyName);
        setCompanyDescription(companyDescription);
        setContactEmail(contactEmail);
        setContactPhone(contactPhone);
        setLocation(location);
        setWebsite(website);
        setLogoPath(logoPath);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("ID cannot be negative");
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        if (companyName == null || companyName.isEmpty()) throw new IllegalArgumentException("Company name cannot be null or empty");
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        if (companyDescription == null || companyDescription.isEmpty()) throw new IllegalArgumentException("Company description cannot be null or empty");
        this.companyDescription = companyDescription;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (contactEmail != null && pattern.matcher(contactEmail).matches()) {
            this.contactEmail = contactEmail;
        } else {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        if (contactPhone == null || contactPhone.isEmpty()) throw new IllegalArgumentException("Contact phone cannot be null or empty");
        this.contactPhone = contactPhone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location == null || location.isEmpty()) throw new IllegalArgumentException("Location cannot be null or empty");
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        if (website == null || website.isEmpty()) throw new IllegalArgumentException("Website cannot be null or empty");
        this.website = website;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        if (logoPath == null || logoPath.isEmpty()) throw new IllegalArgumentException("Logo path cannot be null or empty");
        this.logoPath = logoPath;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", location='" + location + '\'' +
                ", website='" + website + '\'' +
                ", logoPath='" + logoPath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return id == employer.id && 
               Objects.equals(companyName, employer.companyName) && 
               Objects.equals(companyDescription, employer.companyDescription) && 
               Objects.equals(contactEmail, employer.contactEmail) && 
               Objects.equals(contactPhone, employer.contactPhone) && 
               Objects.equals(location, employer.location) && 
               Objects.equals(website, employer.website) && 
               Objects.equals(logoPath, employer.logoPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, companyDescription, contactEmail, contactPhone, location, website, logoPath);
    }
}
