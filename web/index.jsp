<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Portal</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }
        .navbar-brand {
            font-weight: bold;
            color: #fff !important;
        }
        .navbar-nav .nav-link {
            color: #fff !important;
        }
        .jumbotron {
            background: url('1.jpg') no-repeat center center;
            background-size: cover;
            color: white;
            padding: 6rem 1rem;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.6);
        }
        .jumbotron .display-4 {
            font-weight: bold;
            text-transform: uppercase;
        }
        .jumbotron .lead {
            font-size: 1.25rem;
            margin-bottom: 2rem;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
            transition: background-color 0.3s ease;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .features, .about-section {
            padding: 3rem 0;
        }
        .features h3, .about-section h2, .about-section h1 {
            color: #333;
            margin-bottom: 1.5rem;
        }
        .features p, .about-section p, .about-section ul {
            color: #666;
        }
        .features ul {
            padding-left: 1.5rem;
        }
        .features ul li {
            margin-bottom: 0.5rem;
        }
        .about-section {
            background-color: #fff;
            border: 1px solid #dee2e6;
            border-radius: 0.5rem;
            padding: 2rem;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .about-section ul {
            list-style-type: square;
        }
        footer {
            background-color: #343a40;
            color: #fff;
            padding: 1rem 0;
        }
        footer p {
            margin: 0;
        }
        @media (max-width: 768px) {
            .jumbotron {
                padding: 4rem 1rem;
            }
            .features .col-md-4 {
                margin-bottom: 2rem;
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
                    <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
                    <li class="nav-item"><a class="nav-link" href="register.jsp">Register</a></li>
                    <li class="nav-item"><a class="nav-link" href="about.jsp">About Us</a></li>
                    <li class="nav-item"><a class="nav-link" href="contact.jsp">Contact Us</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="jumbotron jumbotron-fluid text-center">
        <div class="container">
            <h1 class="display-4">Welcome to Job Portal</h1>
            <p class="lead">Your Dream Job Awaits</p>
            <a href="register.jsp" class="btn btn-primary btn-lg">Get Started</a>
        </div>
    </div>
    <div class="container features text-center">
        <div class="row">
            <div class="col-md-4 mb-4">
                <h3>Wide Range of Jobs</h3>
                <p>Explore job listings from various industries and find the perfect fit for you.</p>
            </div>
            <div class="col-md-4 mb-4">
                <h3>Easy to Use</h3>
                <p>Our user-friendly interface makes job searching and applying effortless.</p>
            </div>
            <div class="col-md-4 mb-4">
                <h3>Secure and Reliable</h3>
                <p>Your data is safe with us. We prioritize your privacy and security.</p>
            </div>
        </div>
    </div>
    <div class="container about-section">
        <h1>About Job Portal Sri Lanka</h1>
        <p>Welcome to Job Portal Sri Lanka, your number one source for job opportunities across various sectors and regions in Sri Lanka. Our mission is to connect job seekers with potential employers in the most efficient and user-friendly manner.</p>
        
        <h2>Our Mission</h2>
        <p>Our mission is to simplify the job search process and provide a platform where job seekers can find and apply for jobs with ease, and employers can find the best candidates for their job openings. We aim to bridge the gap between job seekers and employers through innovative and reliable services.</p>
        
        <h2>Features</h2>
        <ul>
            <li><strong>Job Listings:</strong> A comprehensive listing of job opportunities across various sectors and regions.</li>
            <li><strong>User Profiles:</strong> Job seekers can create detailed profiles with resumes, skills, and experience.</li>
            <li><strong>Application Tracking:</strong> Employers can manage applications and track the hiring process.</li>
            <li><strong>Advanced Search:</strong> Implement advanced search and filtering options to help users find relevant jobs or candidates quickly.</li>
        </ul>
        
        <h2>Our Team</h2>
        <p>Our dedicated team works tirelessly to ensure that the job portal is always up-to-date with the latest job openings and that our users have the best experience possible. We are committed to providing excellent service and support to both job seekers and employers.</p>
        
        <h2>Contact Us</h2>
        <p>If you have any questions or suggestions, feel free to contact us at <a href="mailto:support@jobportalsrilanka.com">support@jobportalsrilanka.com</a>.</p>
    </div>
    <footer class="text-center">
        <div class="container">
            <p>&copy; 2024 Job Portal. All rights reserved.</p>
        </div>
    </footer>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
