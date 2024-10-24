<%@page import="com.jobportal.models.User"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Users</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/style.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        .navbar {
            margin-bottom: 20px;
        }
        .container {
            flex: 1;
        }
        .list-group-item {
            margin-top: 10px;
        }
        .list-group-item h5 {
            color: #333;
        }
        .list-group-item p {
            color: #555;
        }
        .alert {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Admin Dashboard</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="viewJobs.jsp">View Jobs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="postJob.jsp">Post Job</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="adminDashboard.jsp">Dashboard</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container mt-4">
        <h2>Manage Users</h2>
        <div class="list-group">
            <% 
                List<User> users = (List<User>) request.getAttribute("users");
                if (users != null && !users.isEmpty()) {
                    for (User user : users) {
            %>
            <div class="list-group-item">
                <h5 class="mb-1"><%= user.getName() %></h5> <!-- Ensure this matches the User class method -->
                <p class="mb-1">Email: <%= user.getEmail() %></p>
                <form action="deleteUser" method="post" class="d-inline">
                    <input type="hidden" name="userId" value="<%= user.getId() %>">
                    <button type="submit" class="btn btn-danger btn-sm">Delete User</button>
                </form>
            </div>
            <% 
                    }
                } else {
            %>
            <div class="alert alert-warning" role="alert">
                No users to display.
            </div>
            <% 
                }
            %>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
