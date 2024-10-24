package com.jobportal.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jobportal.dao.ApplicationDAO;
import com.jobportal.dao.ApplicationDAOImpl;
import com.jobportal.models.Application;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/applicationStatus")
public class ApplicationStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ApplicationDAO applicationDao;

    @Override
    public void init() throws ServletException {
        applicationDao = new ApplicationDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentId = (int) request.getSession().getAttribute("userId");
        try {
            List<Application> applications = applicationDao.getApplicationsByStudentId(studentId);
            request.setAttribute("applications", applications);
            request.getRequestDispatcher("applicationStatus.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while retrieving your applications.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
