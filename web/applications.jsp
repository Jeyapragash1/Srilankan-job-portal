<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Jobs List</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        h1 {
            text-align: center;
            margin-top: 20px;
        }
        a {
            text-decoration: none;
            color: #007BFF;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .actions a {
            margin-right: 10px;
        }
        @media screen and (max-width: 768px) {
            table, th, td {
                display: block;
                width: 100%;
            }
            th, td {
                text-align: right;
            }
            th {
                display: none;
            }
            td {
                position: relative;
                padding-left: 50%;
                text-align: left;
            }
            td::before {
                content: attr(data-label);
                position: absolute;
                left: 10px;
                white-space: nowrap;
                font-weight: bold;
            }
            .actions {
                text-align: right;
            }
            .actions a {
                display: block;
                margin: 5px 0;
            }
        }
    </style>
</head>
<body>
    <h1>Jobs List</h1>
  
    <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Company</th>
            <th>Location</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="job" items="${jobs}">
            <tr>
                <td data-label="ID">${job.id}1</td>
                <td data-label="Title">${job.title}Software Engineer</td>
                <td data-label="Description">${job.description} Develop and maintain software applications</td>
                <td data-label="Company">${job.company}TechCorp</td>
                <td data-label="Location">${job.location} Srilanka Batticaloa</td>
                <td data-label="Actions" class="actions">
                    <a href="job?action=view&id=${job.id}">View</a>
                    <a href="job?action=edit&id=${job.id}">Edit</a>
                    <a href="job?action=delete&id=${job.id}" onclick="return confirm('Are you sure?');">Delete</a>
                </td>
            </tr>
            <tr>
                <td data-label="ID">${job.id}2</td>
                <td data-label="Title">${job.title}Data Analyst</td>
                <td data-label="Description">${job.description} Analyze and interpret complex data sets</td>
                <td data-label="Company">${job.company}Pearson</td>
                <td data-label="Location">${job.location} Colombo, Sri Lanka</td>
                <td data-label="Actions" class="actions">
                    <a href="job?action=view&id=${job.id}">View</a>
                    <a href="job?action=edit&id=${job.id}">Edit</a>
                    <a href="job?action=delete&id=${job.id}" onclick="return confirm('Are you sure?');">Delete</a>
                </td>
            </tr>
            <tr>
                <td data-label="ID">${job.id}3</td>
                <td data-label="Title">${job.title}Web Developer</td>
                <td data-label="Description">${job.description} Develop and maintain websites</td>
                <td data-label="Company">${job.company}Innovative Solutions</td>
                <td data-label="Location">${job.location} Kandy, Sri Lanka</td>
                <td data-label="Actions" class="actions">
                    <a href="job?action=view&id=${job.id}">View</a>
                    <a href="job?action=edit&id=${job.id}">Edit</a>
                    <a href="job?action=delete&id=${job.id}" onclick="return confirm('Are you sure?');">Delete</a>
                </td>
            </tr>
            <tr>
                <td data-label="ID">${job.id}4</td>
                <td data-label="Title">${job.title}Project Manager</td>
                <td data-label="Description">${job.description} Manage project timelines and deliverables</td>
                <td data-label="Company">${job.company}Pearson</td>
                <td data-label="Location">${job.location} Galle, Sri Lanka</td>
                <td data-label="Actions" class="actions">
                    <a href="job?action=view&id=${job.id}">View</a>
                    <a href="job?action=edit&id=${job.id}">Edit</a>
                    <a href="job?action=delete&id=${job.id}" onclick="return confirm('Are you sure?');">Delete</a>
                </td>
            </tr>
            <tr>
                <td data-label="ID">${job.id}5</td>
                <td data-label="Title">${job.title}System Administrator</td>
                <td data-label="Description">${job.description} Maintain and troubleshoot IT systems</td>
                <td data-label="Company">${job.company}TechHub</td>
                <td data-label="Location">${job.location} Jaffna, Sri Lanka</td>
                <td data-label="Actions" class="actions">
                    <a href="job?action=view&id=${job.id}">View</a>
                    <a href="job?action=edit&id=${job.id}">Edit</a>
                    <a href="job?action=delete&id=${job.id}" onclick="return confirm('Are you sure?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
