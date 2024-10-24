package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Job Portal</title>\r\n");
      out.write("    <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            font-family: Arial, sans-serif;\r\n");
      out.write("            background-color: #f8f9fa;\r\n");
      out.write("        }\r\n");
      out.write("        .navbar-brand {\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            color: #fff !important;\r\n");
      out.write("        }\r\n");
      out.write("        .navbar-nav .nav-link {\r\n");
      out.write("            color: #fff !important;\r\n");
      out.write("        }\r\n");
      out.write("        .jumbotron {\r\n");
      out.write("            background: url('path-to-your-image.jpg') no-repeat center center;\r\n");
      out.write("            background-size: cover;\r\n");
      out.write("            color: white;\r\n");
      out.write("            padding: 6rem 1rem;\r\n");
      out.write("            text-shadow: 2px 2px 4px rgba(0,0,0,0.6);\r\n");
      out.write("        }\r\n");
      out.write("        .jumbotron .display-4 {\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            text-transform: uppercase;\r\n");
      out.write("        }\r\n");
      out.write("        .jumbotron .lead {\r\n");
      out.write("            font-size: 1.25rem;\r\n");
      out.write("            margin-bottom: 2rem;\r\n");
      out.write("        }\r\n");
      out.write("        .btn-primary {\r\n");
      out.write("            background-color: #007bff;\r\n");
      out.write("            border: none;\r\n");
      out.write("            transition: background-color 0.3s ease;\r\n");
      out.write("        }\r\n");
      out.write("        .btn-primary:hover {\r\n");
      out.write("            background-color: #0056b3;\r\n");
      out.write("        }\r\n");
      out.write("        .features, .about-section {\r\n");
      out.write("            padding: 3rem 0;\r\n");
      out.write("        }\r\n");
      out.write("        .features h3, .about-section h2, .about-section h1 {\r\n");
      out.write("            color: #333;\r\n");
      out.write("            margin-bottom: 1.5rem;\r\n");
      out.write("        }\r\n");
      out.write("        .features p, .about-section p, .about-section ul {\r\n");
      out.write("            color: #666;\r\n");
      out.write("        }\r\n");
      out.write("        .features ul {\r\n");
      out.write("            padding-left: 1.5rem;\r\n");
      out.write("        }\r\n");
      out.write("        .features ul li {\r\n");
      out.write("            margin-bottom: 0.5rem;\r\n");
      out.write("        }\r\n");
      out.write("        .about-section {\r\n");
      out.write("            background-color: #fff;\r\n");
      out.write("            border: 1px solid #dee2e6;\r\n");
      out.write("            border-radius: 0.5rem;\r\n");
      out.write("            padding: 2rem;\r\n");
      out.write("            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n");
      out.write("        }\r\n");
      out.write("        .about-section ul {\r\n");
      out.write("            list-style-type: square;\r\n");
      out.write("        }\r\n");
      out.write("        footer {\r\n");
      out.write("            background-color: #343a40;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            padding: 1rem 0;\r\n");
      out.write("        }\r\n");
      out.write("        footer p {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("        }\r\n");
      out.write("        @media (max-width: 768px) {\r\n");
      out.write("            .jumbotron {\r\n");
      out.write("                padding: 4rem 1rem;\r\n");
      out.write("            }\r\n");
      out.write("            .features .col-md-4 {\r\n");
      out.write("                margin-bottom: 2rem;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Job Portal</a>\r\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n");
      out.write("                <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"index.jsp\">Home</a></li>\r\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"login.jsp\">Login</a></li>\r\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"register.jsp\">Register</a></li>\r\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"about.jsp\">About Us</a></li>\r\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"contact.jsp\">Contact Us</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("    <div class=\"jumbotron jumbotron-fluid text-center\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <h1 class=\"display-4\">Welcome to Job Portal</h1>\r\n");
      out.write("            <p class=\"lead\">Your Dream Job Awaits</p>\r\n");
      out.write("            <a href=\"register.jsp\" class=\"btn btn-primary btn-lg\">Get Started</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"container features text-center\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-4 mb-4\">\r\n");
      out.write("                <h3>Wide Range of Jobs</h3>\r\n");
      out.write("                <p>Explore job listings from various industries and find the perfect fit for you.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-4 mb-4\">\r\n");
      out.write("                <h3>Easy to Use</h3>\r\n");
      out.write("                <p>Our user-friendly interface makes job searching and applying effortless.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-4 mb-4\">\r\n");
      out.write("                <h3>Secure and Reliable</h3>\r\n");
      out.write("                <p>Your data is safe with us. We prioritize your privacy and security.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"container about-section\">\r\n");
      out.write("        <h1>About Job Portal Sri Lanka</h1>\r\n");
      out.write("        <p>Welcome to Job Portal Sri Lanka, your number one source for job opportunities across various sectors and regions in Sri Lanka. Our mission is to connect job seekers with potential employers in the most efficient and user-friendly manner.</p>\r\n");
      out.write("        \r\n");
      out.write("        <h2>Our Mission</h2>\r\n");
      out.write("        <p>Our mission is to simplify the job search process and provide a platform where job seekers can find and apply for jobs with ease, and employers can find the best candidates for their job openings. We aim to bridge the gap between job seekers and employers through innovative and reliable services.</p>\r\n");
      out.write("        \r\n");
      out.write("        <h2>Features</h2>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><strong>Job Listings:</strong> A comprehensive listing of job opportunities across various sectors and regions.</li>\r\n");
      out.write("            <li><strong>User Profiles:</strong> Job seekers can create detailed profiles with resumes, skills, and experience.</li>\r\n");
      out.write("            <li><strong>Application Tracking:</strong> Employers can manage applications and track the hiring process.</li>\r\n");
      out.write("            <li><strong>Advanced Search:</strong> Implement advanced search and filtering options to help users find relevant jobs or candidates quickly.</li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        \r\n");
      out.write("        <h2>Our Team</h2>\r\n");
      out.write("        <p>Our dedicated team works tirelessly to ensure that the job portal is always up-to-date with the latest job openings and that our users have the best experience possible. We are committed to providing excellent service and support to both job seekers and employers.</p>\r\n");
      out.write("        \r\n");
      out.write("        <h2>Contact Us</h2>\r\n");
      out.write("        <p>If you have any questions or suggestions, feel free to contact us at <a href=\"mailto:support@jobportalsrilanka.com\">support@jobportalsrilanka.com</a>.</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <footer class=\"text-center\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <p>&copy; 2024 Job Portal. All rights reserved.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
