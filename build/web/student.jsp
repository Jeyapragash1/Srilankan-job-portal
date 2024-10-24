<%@ page import="com.jobportal.models.Student" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Details</title>
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
            text-align: left;
        }
        h1 {
            margin-bottom: 20px;
            color: #333;
        }
        p {
            margin-bottom: 10px;
            font-size: 1.1rem;
        }
        a {
            text-decoration: none;
            margin-right: 10px;
        }
        .btn {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Student Details</h1>
        <jsp:useBean id="student" class="com.jobportal.models.Student" scope="request"/>
        <p><strong>Name:</strong> <jsp:getProperty name="student" property="name"/></p>
        <p><strong>Email:</strong> <jsp:getProperty name="student" property="email"/></p>
        <p><strong>Phone:</strong> <jsp:getProperty name="student" property="phone"/></p>
        <p><strong>Major:</strong> <jsp:getProperty name="student" property="major"/></p>
        <p><strong>Graduation Year:</strong> <jsp:getProperty name="student" property="graduationYear"/></p>
        <p><strong>Resume Path:</strong> <jsp:getProperty name="student" property="resumePath"/></p>
        <div class="btn-group">
            <a href="student?action=delete&id=<jsp:getProperty name="student" property="id"/>" class="btn btn-danger">Delete</a>
            <a href="updateStudent.jsp?id=<jsp:getProperty name="student" property="id"/>" class="btn btn-primary">Update</a>
            <a href="students.jsp" class="btn btn-secondary">Back to Students List</a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
