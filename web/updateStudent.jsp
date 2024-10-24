<%@ page import="com.jobportal.models.Student" %>
<%@ page import="com.jobportal.dao.StudentDaoImpl" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    StudentDaoImpl studentDao = new StudentDaoImpl();
    Student student = studentDao.getStudentById(id);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px;
        }
        h1 {
            margin-bottom: 20px;
            color: #333;
        }
        label {
            font-weight: bold;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .btn {
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Update Student</h1>
        <form action="student" method="post">
            <input type="hidden" name="action" value="update"/>
            <input type="hidden" name="id" value="<%= student.getId() %>"/>
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="<%= student.getName() %>" required/>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="<%= student.getEmail() %>" required/>
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" class="form-control" id="phone" name="phone" value="<%= student.getPhone() %>" required/>
            </div>
            <div class="form-group">
                <label for="major">Major:</label>
                <input type="text" class="form-control" id="major" name="major" value="<%= student.getMajor() %>" required/>
            </div>
            <div class="form-group">
                <label for="graduation_year">Graduation Year:</label>
                <input type="text" class="form-control" id="graduation_year" name="graduation_year" value="<%= student.getGraduationYear() %>" required/>
            </div>
            <div class="form-group">
                <label for="resume_path">Resume Path:</label>
                <input type="text" class="form-control" id="resume_path" name="resume_path" value="<%= student.getResumePath() %>"/>
            </div>
            <button type="submit" class="btn btn-primary">Update Student</button>
        </form>
        <a href="students.jsp" class="btn btn-secondary mt-3">Back to Students List</a>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
