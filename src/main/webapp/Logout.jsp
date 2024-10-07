<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 60px;
        }
        .profile-container {
            max-width: 600px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .profile-header {
            background-color: #007bff;
            color: white;
            padding: 15px;
            border-radius: 10px 10px 0 0;
            text-align: center;
        }
        .profile-body {
            padding: 20px;
        }
        .btn-logout {
            background-color: #dc3545;
            border: none;
            border-radius: 50px;
            color: white;
            padding: 10px 20px;
            text-transform: uppercase;
            transition: background-color 0.3s ease;
        }
        .btn-logout:hover {
            background-color: #c82333;
        }
        .info-text {
            margin-top: 20px;
            font-size: 0.9rem;
            color: #6c757d;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container profile-container">
        <div class="profile-header">
            <h2>User Profile</h2>
        </div>
        <div class="profile-body">
            <%
                HttpSession session1 = request.getSession(false);
                String username = (session1 != null) ? (String) session1.getAttribute("username") : null;
                
                if (username != null) {
            %>
                <p class="text-center">Welcome, <strong><%= username %></strong></p>
                <div class="d-flex justify-content-center">
                    <a href="LogoutServlet" class="btn btn-logout">Logout</a>
                </div>
                <p class="info-text">Click the "Logout" button to securely log out of your account. After logging out, you will be redirected to the homepage.</p>
            <%
                } else {
            %>
                <p>Please <a href="Login.jsp">login</a> to access your profile.</p>
            <%
                }
            %>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
