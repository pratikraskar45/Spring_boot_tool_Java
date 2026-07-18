<%@ page import="com.jsp.ca.entity.Contact" %>
<%@ page import="java.util.List" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contact Manager - Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
          crossorigin="anonymous">

    <style>
        body {
            background-color: #f5f7fa;
        }

        .navbar {
            background-color: #0d6efd !important;
        }

        .navbar-brand,
        .nav-link {
            color: white !important;
        }

        .navbar-brand {
            font-weight: bold;
        }

        .container {
            margin-top: 30px;
        }

        h1 {
            margin-bottom: 20px;
            font-weight: bold;
        }

        .table thead {
            background-color: #0d6efd;
            color: white;
        }

        .table td,
        .table th {
            vertical-align: middle;
        }

        a {
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<%
    String username = (String) session.getAttribute("username");
%>

<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Contact Manager</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">

                <li class="nav-item">
                    <a class="nav-link active" href="add">Add Contact</a>
                </li>

                <li class="nav-item">
                    <span class="nav-link fw-bold text-white">Welcome, <%= username %></span>
                </li>

                <li class="nav-item">
                    <a class="nav-link text-danger fw-bold" href="logout">Logout</a>
                </li>

            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <h1>Welcome</h1>
    <h5 class="text-success">${msg}</h5>

    <table class="table table-bordered table-hover shadow">
        <thead>
        <tr>
            <th>Contact ID</th>
            <th>Name</th>
            <th>Contact</th>
            <th>Aadhar No</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
            if (contacts != null && !contacts.isEmpty()) {
                for (Contact contact : contacts) {
        %>
        <tr>
            <td><%= contact.getCid() %></td>
            <td><%= contact.getName() %></td>
            <td><%= contact.getPhone() %></td>
            <td><%= contact.getAdharNo() %></td>
            <td><a class="btn btn-sm btn-warning" href="edit?cid=<%= contact.getCid() %>">Edit</a></td>
            <td><a class="btn btn-sm btn-danger" href="delete?cid=<%= contact.getCid() %>">Delete</a></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="6" class="text-center">No contacts available.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

<!-- Bootstrap Bundle JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
        crossorigin="anonymous"></script>
</body>
</html>