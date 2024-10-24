package com.jobportal.servlets;

import com.jobportal.dao.StudentDao;
import com.jobportal.dao.StudentDaoImpl;
import com.jobportal.models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao studentDao;

    @Override
    public void init() throws ServletException {
        // Initialize DAO
        studentDao = new StudentDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");

        // Basic validation
        if (username == null || password == null || email == null || fullName == null ||
                phoneNumber == null || address == null ||
                username.trim().isEmpty() || password.trim().isEmpty() ||
                email.trim().isEmpty() || fullName.trim().isEmpty() ||
                phoneNumber.trim().isEmpty() || address.trim().isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Hash the password
        String hashedPassword;
        try {
            hashedPassword = hashPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while processing your request.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Create a Student object
        Student student = new Student();
        student.setName(fullName); // Assuming you want to store the full name in the 'name' field
        student.setEmail(email);
        student.setPhone(phoneNumber);
        student.setAddress(address);
        student.setUsername(username);
        student.setPassword(hashedPassword); // Store the hashed password

        // Save the student using DAO
        try {
            boolean isRegistered = studentDao.addStudent(student);
            if (isRegistered) {
                // Redirect to success page or login page
                response.sendRedirect("registrationSuccess.jsp");
            } else {
                // Redirect to an error page or show an error message
                request.setAttribute("errorMessage", "Registration failed. Please try again.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while processing your request.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    // Method to hash the password
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
