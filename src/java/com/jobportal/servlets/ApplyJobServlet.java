package com.jobportal.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jobportal.dao.ApplicationDAO;
import com.jobportal.dao.ApplicationDAOImpl;
import com.jobportal.models.Application;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/apply")
public class ApplyJobServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ApplyJobServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int jobId = Integer.parseInt(request.getParameter("jobId"));
            String coverLetter = request.getParameter("coverLetter");

            // Assuming user is logged in and session has user ID
            Integer studentId = (Integer) request.getSession().getAttribute("userId");

            if (studentId == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            Application application = new Application();
            application.setStudentId(studentId);
            application.setJobId(jobId);
            application.setStatus("Applied");
            application.setApplicationDate(LocalDate.now()); // Use LocalDate
            application.setCoverLetterPath(coverLetter); // Assuming coverLetter is the path

            ApplicationDAO applicationDao = new ApplicationDAOImpl();
            applicationDao.saveApplication(application);
            response.sendRedirect("viewApplications.jsp");

        } catch (NumberFormatException e) {
            logger.log(Level.SEVERE, "Invalid job ID format", e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid job ID format");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Database error occurred", e);
            throw new ServletException("Error saving application", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error occurred", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An unexpected error occurred");
        }
    }
}
