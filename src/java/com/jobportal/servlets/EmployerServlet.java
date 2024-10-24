package com.jobportal.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jobportal.dao.EmployerDao;
import com.jobportal.dao.EmployerDaoImpl;
import com.jobportal.models.Employer;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/employer")
public class EmployerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(EmployerServlet.class.getName());
    private EmployerDao employerDao;

    @Override
    public void init() throws ServletException {
        employerDao = new EmployerDaoImpl(); // Use the implementation class here
    }

    // Display an employer
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("view".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Employer employer = employerDao.getEmployerById(id);
                if (employer != null) {
                    request.setAttribute("employer", employer);
                    request.getRequestDispatcher("employer.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Employer not found");
                }
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                employerDao.deleteEmployer(id);
                response.sendRedirect("employers.jsp");
            }
        } catch (NumberFormatException e) {
            logger.log(Level.SEVERE, "Invalid ID format", e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error processing request", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing request");
        }
    }

    // Add or update an employer
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            Employer employer = new Employer();
            employer.setCompanyName(request.getParameter("company_name"));
            employer.setCompanyDescription(request.getParameter("company_description"));
            employer.setContactEmail(request.getParameter("contact_email"));
            employer.setContactPhone(request.getParameter("contact_phone"));
            employer.setLocation(request.getParameter("location"));
            employer.setWebsite(request.getParameter("website"));
            employer.setLogoPath(request.getParameter("logo_path"));

            if ("add".equals(action)) {
                employerDao.saveEmployer(employer);
                response.sendRedirect("employers.jsp");
            } else if ("update".equals(action)) {
                employer.setId(Integer.parseInt(request.getParameter("id")));
                employerDao.updateEmployer(employer);
                response.sendRedirect("employers.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }
        } catch (NumberFormatException e) {
            logger.log(Level.SEVERE, "Invalid ID format", e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error processing request", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing request");
        }
    }
}
