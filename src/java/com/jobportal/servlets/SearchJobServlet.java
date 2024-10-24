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
import java.util.List;

@WebServlet("/searchJobs")
public class SearchJobServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private JobDao jobDao;

    @Override
    public void init() throws ServletException {
        jobDao = new JobDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String location = request.getParameter("location");
        String requirements = request.getParameter("requirements");

        try {
            List<Job> jobs = jobDao.searchJobs(title, location, requirements);
            request.setAttribute("jobs", jobs);
            request.getRequestDispatcher("searchResults.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while searching for jobs.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
