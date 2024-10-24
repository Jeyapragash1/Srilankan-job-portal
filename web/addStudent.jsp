<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
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
    input {
        margin-top: 5px;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
        width: 100%;
        box-sizing: border-box;
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
        <h1>Add Student</h1>
        <form action="student" method="post">
            <input type="hidden" name="action" value="add"/>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required/>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required/>
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" required/>
            <label for="major">Major:</label>
            <input type="text" id="major" name="major" required/>
            <label for="graduation_year">Graduation Year:</label>
            <input type="text" id="graduation_year" name="graduation_year" required/>
            <label for="resume_path">Resume Path:</label>
            <input type="text" id="resume_path" name="resume_path"/>
            <input type="submit" value="Add Student"/>
        </form>
        <a href="students.jsp">Back to Students List</a>
    </div>
</body>
</html>
