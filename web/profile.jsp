<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jobportal.model.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile - Job Portal</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
        }
        .navbar-brand {
            font-size: 1.75rem;
        }
        .profile-header {
            background-color: #007bff;
            color: #fff;
            padding: 2rem 0;
            text-align: center;
        }
        .profile-header h2 {
            margin: 0;
            font-size: 2.5rem;
        }
        .container {
            margin-top: 30px;
        }
        .card {
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 30px;
        }
        .card-header {
            background-color: #007bff;
            color: #fff;
            font-size: 1.25rem;
            font-weight: bold;
        }
        .card-body p {
            font-size: 1.1rem;
        }
        .btn-edit {
            background-color: #007bff;
            color: #fff;
            border: none;
            transition: background-color 0.3s ease;
            border-radius: 30px;
        }
        .btn-edit:hover {
            background-color: #0056b3;
        }
        footer {
            background-color: #343a40;
            color: white;
            padding: 10px 0;
            text-align: center;
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">Job Portal</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link" href="dashboard.jsp">Dashboard</a></li>
                    <li class="nav-item active"><a class="nav-link" href="profile.jsp">Profile</a></li>
                    <li class="nav-item"><a class="nav-link" href="jobs.jsp">Jobs</a></li>
                    <li class="nav-item"><a class="nav-link" href="applications.jsp">Applications</a></li>
                    <li class="nav-item"><a class="nav-link" href="employers.jsp">Employers</a></li>
                    <li class="nav-item"><a class="nav-link" href="logout.jsp">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="profile-header">
        <h2>User Profile</h2>
    </div>

    <div class="container mt-4">
        <div class="card">
            <div class="card-header">
                Personal Information
            </div>
            <div class="card-body">
                <p><strong>Full Name:</strong> <%= user.getFullName() %></p>
                <p><strong>Email:</strong> <%= user.getEmail() %></p>
                <p><strong>Phone Number:</strong> <%= user.getPhoneNumber() %></p>
                <p><strong>Address:</strong> <%= user.getAddress() %></p>
                <p><strong>Role:</strong> <%= user.getRole() %></p>
                <a href="editProfile.jsp" class="btn btn-edit">Edit Profile</a>
            </div>
        </div>
    </div>

    <footer>
        <div class="container">
            <p>&copy; 2024 Job Portal. All rights reserved.</p>
        </div>
    </footer>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.
