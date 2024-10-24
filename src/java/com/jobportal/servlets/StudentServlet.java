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

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao studentDao;

    @Override
    public void init() throws ServletException {
        studentDao = new StudentDaoImpl();
    }

    // Display a student
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("view".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Student student = studentDao.getStudentById(id);
                request.setAttribute("student", student);
                request.getRequestDispatcher("student.jsp").forward(request, response);
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                studentDao.deleteStudent(id);
                response.sendRedirect("students.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while processing your request.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    // Add or update a student
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("add".equals(action)) {
                Student student = new Student();
                student.setName(request.getParameter("name"));
                student.setEmail(request.getParameter("email"));
                student.setPhone(request.getParameter("phone"));
                student.setMajor(request.getParameter("major"));
                student.setGraduationYear(request.getParameter("graduation_year"));
                student.setResumePath(request.getParameter("resume_path"));

                // Validate required fields
                if (student.getName() == null || student.getEmail() == null || student.getPhone() == null ||
                    student.getMajor() == null || student.getGraduationYear() == null) {
                    request.setAttribute("errorMessage", "All fields are required.");
                    request.getRequestDispatcher("studentForm.jsp").forward(request, response);
                    return;
                }

                studentDao.addStudent(student);
                response.sendRedirect("students.jsp");
            } else if ("update".equals(action)) {
                Student student = new Student();
                student.setId(Integer.parseInt(request.getParameter("id")));
                student.setName(request.getParameter("name"));
                student.setEmail(request.getParameter("email"));
                student.setPhone(request.getParameter("phone"));
                student.setMajor(request.getParameter("major"));
                student.setGraduationYear(request.getParameter("graduation_year"));
                student.setResumePath(request.getParameter("resume_path"));

                // Validate required fields
                if (student.getName() == null || student.getEmail() == null || student.getPhone() == null ||
                    student.getMajor() == null || student.getGraduationYear() == null) {
                    request.setAttribute("errorMessage", "All fields are required.");
                    request.getRequestDispatcher("studentForm.jsp").forward(request, response);
                    return;
                }

                studentDao.updateStudent(student);
                response.sendRedirect("students.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while processing your request.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
