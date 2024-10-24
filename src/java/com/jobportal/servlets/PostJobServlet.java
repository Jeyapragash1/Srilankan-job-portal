package com.jobportal.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jobportal.dao.JobDao;
import com.jobportal.dao.JobDaoImpl;
import com.jobportal.models.Job;

@WebServlet("/postJob")
public class PostJobServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private JobDao jobDao;

    @Override
    public void init() throws ServletException {
        jobDao = new JobDaoImpl(); // Initialize JobDao here
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String location = request.getParameter("location");
        String requirements = request.getParameter("requirements");

        // Assuming user is logged in and session has employer ID
        Integer employerId = (Integer) request.getSession().getAttribute("userId");

        // Basic validation
        if (title == null || description == null || location == null || requirements == null || employerId == null) {
            response.sendRedirect("postJob.jsp?error=All fields are required");
            return;
        }

        Job job = new Job();
        job.setTitle(title);
        job.setDescription(description);
        job.setLocation(location);
        job.setRequirements(requirements);
        job.setEmployerId(employerId);

        try {
            jobDao.saveJob(job);
            response.sendRedirect("dashboard.jsp");
        } catch (Exception e) {
            throw new ServletException("Error saving job posting", e);
        }
    }
}
