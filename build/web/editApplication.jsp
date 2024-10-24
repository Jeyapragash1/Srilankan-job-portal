<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Application</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
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
    select, input[type="submit"] {
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
</style>
</head>
<body>
    <div class="container">
        <h1>Edit Application</h1>
        <form action="application" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${application.id}">
            
            <label for="status">Status:</label>
            <select id="status" name="status">
                <option value="Pending" ${application.status == 'Pending' ? 'selected' : ''}>Pending</option>
                <option value="Approved" ${application.status == 'Approved' ? 'selected' : ''}>Approved</option>
                <option value="Rejected" ${application.status == 'Rejected' ? 'selected' : ''}>Rejected</option>
            </select>
            
            <input type="submit" value="Update">
        </form>
    </div>
</body>
</html>
