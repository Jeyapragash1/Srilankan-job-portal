<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply for Job</title>
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
    textarea {
        margin-top: 5px;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
        width: 100%;
        box-sizing: border-box;
        resize: vertical;
        height: 100px;
    }
    button {
        margin-top: 20px;
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
        padding: 15px 20px;
        font-size: 16px;
    }
    button:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Apply for Job</h1>
        <form action="apply" method="post">
            <input type="hidden" name="jobId" value="${param.jobId}">
            <label for="coverLetter">Cover Letter:</label>
            <textarea id="coverLetter" name="coverLetter" required></textarea>
            <button type="submit">Submit Application</button>
        </form>
    </div>
</body>
</html>
