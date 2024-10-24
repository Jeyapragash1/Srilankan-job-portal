package com.jobportal.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jobportal.dao.UserDao;
import com.jobportal.dao.UserDaoImpl; // Import the implementation class
import com.jobportal.models.User;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDaoImpl(); // Use the implementation class
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = userDao.getUserByEmail(email);

            if (user != null && user.getPassword().equals(password)) { // Ensure you use hashed passwords in production
                request.getSession().setAttribute("user", user);
                response.sendRedirect("dashboard.jsp");
            } else {
                response.sendRedirect("login.jsp?error=Invalid credentials");
            }
        } catch (SQLException e) {
            throw new ServletException("Database error occurred while processing login", e);
        }
    }
}
