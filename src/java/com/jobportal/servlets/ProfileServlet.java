package com.jobportal.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jobportal.dao.StudentDao;
import com.jobportal.dao.StudentDaoImpl;
import com.jobportal.models.Student;
import java.sql.SQLException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao studentDao;

    @Override
    public void init() throws ServletException {
        studentDao = new StudentDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentId = (int) request.getSession().getAttribute("userId");
        try {
            Student student = studentDao.getStudentById(studentId);
            request.setAttribute("student", student);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while retrieving your profile.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentId = (int) request.getSession().getAttribute("userId");
        Student student = new Student();
        student.setId(studentId);
        student.setName(request.getParameter("name"));
        student.setEmail(request.getParameter("email"));
        student.setPhone(request.getParameter("phone"));
        student.setMajor(request.getParameter("major"));
        student.setGraduationYear(request.getParameter("graduation_year"));
        student.setResumePath(request.getParameter("resume_path"));

        try {
            studentDao.updateStudent(student);
            response.sendRedirect("profile.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while updating your profile.");
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        }
    }
}
