<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Job Portal</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
        }
        .navbar-brand {
            font-size: 1.5rem;
        }
        .jumbotron {
            padding: 2rem 1rem;
        }
        .jumbotron h2 {
            font-size: 2rem;
        }
        .jumbotron p {
            font-size: 1.2rem;
        }
        .btn {
            margin: 0.5rem;
        }
        footer {
            background-color: #343a40;
            color: white;
            padding: 10px 0;
            text-align: center;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
        @media (max-width: 768px) {
            .jumbotron h2 {
                font-size: 1.5rem;
            }
            .jumbotron p {
                font-size: 1rem;
            }
            .btn {
                margin: 0.3rem;
                font-size: 0.9rem;
            }
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
                    
                    <li class="nav-item"><a class="nav-link" href="jobs.jsp">Jobs</a></li>
                    <li class="nav-item"><a class="nav-link" href="applications.jsp">Applications</a></li>
                    <li class="nav-item"><a class="nav-link" href="employers.jsp">Employers</a></li>
                    <li class="nav-item"><a class="nav-link" href="logout.jsp">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container mt-5">
        <div class="jumbotron text-center">
            <h2>Welcome,</h2>
            <p>What would you like to do today?</p>
            <div class="d-flex justify-content-center flex-wrap">
               
                <a href="jobs.jsp" class="btn btn-success">Search Jobs</a>
                <a href="applications.jsp" class="btn btn-info">View Applications</a>
                <a href="employers.jsp" class="btn btn-warning">View Employers</a>
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
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
