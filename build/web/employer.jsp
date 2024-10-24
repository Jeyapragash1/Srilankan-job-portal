<%@ page import="com.jobportal.models.Employer" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employer Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            width: 100%;
            max-width: 600px;
            box-sizing: border-box;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        p {
            margin: 10px 0;
            color: #555;
        }
        a {
            display: inline-block;
            margin: 10px 5px;
            padding: 10px 15px;
            background-color: #007BFF;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Employer Details</h1>
        <jsp:useBean id="employer" class="com.jobportal.models.Employer" scope="request"/>
        <p>Company Name: <jsp:getProperty name="employer" property="companyName"/></p>
        <p>Description: <jsp:getProperty name="employer" property="companyDescription"/></p>
        <p>Contact Email: <jsp:getProperty name="employer" property="contactEmail"/></p>
        <p>Contact Phone: <jsp:getProperty name="employer" property="contactPhone"/></p>
        <p>Location: <jsp:getProperty name="employer" property="location"/></p>
        <p>Website: <jsp:getProperty name="employer" property="website"/></p>
        <p>Logo Path: <jsp:getProperty name="employer" property="logoPath"/></p>
        <a href="employer?action=delete&id=<jsp:getProperty name="employer" property="id"/>">Delete</a>
        <a href="updateEmployer.jsp?id=<jsp:getProperty name="employer" property="id"/>">Update</a>
        <a href="employers.jsp">Back to Employers List</a>
    </div>
</body>
</html>
