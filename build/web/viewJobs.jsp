<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jobportal.models.Job" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Jobs</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/style.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .navbar {
            margin-bottom: 20px;
        }
        .container {
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            margin-bottom: 20px;
        }
        .list-group-item {
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 20px;
            background-color: #fff;
        }
        .btn-apply {
            float: right;
            background-color: #007bff;
            color: white;
            border: none;
        }
        .btn-apply:hover {
            background-color: #0056b3;
        }
        .list-group-item h5 {
            color: #343a40;
        }
        .list-group-item p {
            margin: 5px 0;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Job Portal</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="register.jsp">Register</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="postJob.jsp">Post Job</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container mt-4">
        <h2>Available Jobs</h2>
        <div class="list-group">
            <% 
                List<Job> jobs = (List<Job>) request.getAttribute("jobs");
                if (jobs != null && !jobs.isEmpty()) {
                    for (Job job : jobs) {
            %>
            <div class="list-group-item">
                <h5 class="mb-1"><%= job.getTitle() %></h5>
                <p class="mb-1"><%= job.getDescription() %></p>
                <p class="mb-1"><strong>Location:</strong> <%= job.getLocation() %></p>
                <p class="mb-1"><strong>Requirements:</strong> <%= job.getRequirements() %></p>
                <p class="mb-1"><strong>Employer ID:</strong> <%= job.getEmployerId() %></p>
                <a href="applyJob.jsp?jobId=<%= job.getId() %>" class="btn btn-primary btn-sm btn-apply">Apply</a>
            </div>
            <% 
                    }
                } else {
            %>
            <p>No jobs available at the moment.</p>
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
