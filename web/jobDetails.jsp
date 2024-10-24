<%@ page import="com.jobportal.model.Job" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Details</title>
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
        .card {
            margin-top: 20px;
        }
        .card-title {
            color: #333;
            font-size: 1.5rem;
        }
        .card-text {
            color: #555;
            font-size: 1rem;
        }
        .alert {
            margin-top: 20px;
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

    <div class="container">
        <% 
            Job job = (Job) request.getAttribute("job");
            if (job != null) {
        %>
        <div class="card">
            <div class="card-body">
                <h2 class="card-title"><%= job.getTitle() %></h2>
                <p class="card-text"><strong>Location:</strong> <%= job.getLocation() %></p>
                <p class="card-text"><strong>Description:</strong> <%= job.getDescription() %></p>
                <p class="card-text"><strong>Requirements:</strong> <%= job.getRequirements() %></p>
                <p class="card-text"><strong>Posted by:</strong> Employer ID <%= job.getEmployerId() %></p>
            </div>
        </div>
        <% 
            } else {
        %>
        <div class="alert alert-warning" role="alert">
            Job details not available.
        </div>
        <% 
            }
        %>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
