package com.jobportal.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jobportal.dao.AdminDao;
import com.jobportal.dao.AdminDaoImpl;
import com.jobportal.models.Admin;

@WebServlet("/adminDashboard")
public class AdminDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDao adminDao;

    @Override
    public void init() throws ServletException {
        adminDao = new AdminDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Example of fetching some statistics or data
            int totalUsers = adminDao.getTotalUsers();
            int totalJobs = adminDao.getTotalJobs();
            
            request.setAttribute("totalUsers", totalUsers);
            request.setAttribute("totalJobs", totalJobs);
            request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while retrieving dashboard data.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
