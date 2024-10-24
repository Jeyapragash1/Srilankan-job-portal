<%@ page import="com.jobportal.models.Employer" %>
<%@ page import="com.jobportal.dao.EmployerDao" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    EmployerDao employerDao = new EmployerDaoImpl(); // Ensure EmployerDaoImpl is implemented
    Employer employer = employerDao.getEmployerById(id);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Employer</title>
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
        <h1>Update Employer</h1>
        <form action="employer" method="post">
            <input type="hidden" name="action" value="update"/>
            <input type="hidden" name="id" value="<%= employer.getId() %>"/>
            <div class="form-group">
                <label for="company_name">Company Name:</label>
                <input type="text" class="form-control" id="company_name" name="company_name" value="<%= employer.getCompanyName() %>" required/>
            </div>
            <div class="form-group">
                <label for="company_description">Description:</label>
                <textarea class="form-control" id="company_description" name="company_description" required><%= employer.getCompanyDescription() %></textarea>
            </div>
            <div class="form-group">
                <label for="contact_email">Contact Email:</label>
                <input type="email" class="form-control" id="contact_email" name="contact_email" value="<%= employer.getContactEmail() %>" required/>
            </div>
            <div class="form-group">
                <label for="contact_phone">Contact Phone:</label>
                <input type="text" class="form-control" id="contact_phone" name="contact_phone" value="<%= employer.getContactPhone() %>" required/>
            </div>
            <div class="form-group">
                <label for="location">Location:</label>
                <input type="text" class="form-control" id="location" name="location" value="<%= employer.getLocation() %>" required/>
            </div>
            <div class="form-group">
                <label for="website">Website:</label>
                <input type="url" class="form-control" id="website" name="website" value="<%= employer.getWebsite() %>"/>
            </div>
            <div class="form-group">
                <label for="logo_path">Logo Path:</label>
                <input type="text" class="form-control" id="logo_path" name="logo_path" value="<%= employer.getLogoPath() %>"/>
            </div>
            <button type="submit" class="btn btn-primary">Update Employer</button>
        </form>
        <a href="employers.jsp" class="btn btn-secondary mt-3">Back to Employers List</a>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
