<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Job</title>
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
            height: 100px;
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
        <h1>Edit Job</h1>
        <form action="job" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${job.id}">
            
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value="${job.title}" required>
            
            <label for="description">Description:</label>
            <textarea id="description" name="description" required>${job.description}</textarea>
            
            <label for="company">Company:</label>
            <input type="text" id="company" name="company" value="${job.company}" required>
            
            <label for="location">Location:</label>
            <input type="text" id="location" name="location" value="${job.location}" required>
            
            <input type="submit" value="Update">
        </form>
    </div>
</body>
</html>
