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
import java.sql.SQLException;

@WebServlet("/jobDetails")
public class JobDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private JobDao jobDao;

    @Override
    public void init() throws ServletException {
        jobDao = new JobDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int jobId = Integer.parseInt(request.getParameter("id"));
            Job job = jobDao.getJobById(jobId);
            if (job == null) {
                request.setAttribute("error", "Job not found.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                request.setAttribute("job", job);
                request.getRequestDispatcher("jobDetails.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid job ID.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
