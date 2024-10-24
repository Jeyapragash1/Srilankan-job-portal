<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employer</title>
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
        max-width: 500px;
    }
    h1 {
        text-align: center;
        color: #333;
    }
    form {
        display: flex;
        flex-direction: column;
    }
    label {
        margin-top: 10px;
        color: #555;
    }
    input, textarea {
        margin-top: 5px;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
        width: 100%;
        box-sizing: border-box;
    }
    textarea {
        resize: vertical;
    }
    input[type="submit"] {
        margin-top: 20px;
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
        padding: 15px 20px;
        font-size: 16px;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
    a {
        display: block;
        margin-top: 20px;
        text-align: center;
        color: #007BFF;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Add Employer</h1>
        <form action="employer" method="post">
            <input type="hidden" name="action" value="add"/>
            <label for="company_name">Company Name:</label>
            <input type="text" id="company_name" name="company_name" required/>
            <label for="company_description">Description:</label>
            <textarea id="company_description" name="company_description" required></textarea>
            <label for="contact_email">Contact Email:</label>
            <input type="email" id="contact_email" name="contact_email" required/>
            <label for="contact_phone">Contact Phone:</label>
            <input type="text" id="contact_phone" name="contact_phone" required/>
            <label for="location">Location:</label>
            <input type="text" id="location" name="location" required/>
            <label for="website">Website:</label>
            <input type="url" id="website" name="website"/>
            <label for="logo_path">Logo Path:</label>
            <input type="text" id="logo_path" name="logo_path"/>
            <input type="submit" value="Add Employer"/>
        </form>
        <a href="employers.jsp">Back to Employers List</a>
    </div>
</body>
</html>
