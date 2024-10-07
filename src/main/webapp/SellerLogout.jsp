<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Seller Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
            padding-top: 50px;
        }
        .profile-container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            max-width: 600px;
            margin: auto;
            text-align: center;
        }
        .profile-container h1 {
            font-size: 2.5rem;
            margin-bottom: 20px;
        }
        .profile-container p {
            font-size: 1.2rem;
            margin-bottom: 30px;
        }
        .btn-logout {
            background-color: #dc3545;
            border-color: #dc3545;
        }
        .btn-logout:hover {
            background-color: #c82333;
            border-color: #bd2130;
        }
        .info-text {
            margin-top: 20px;
            font-size: 0.9rem;
            color: #6c757d;
        }
    </style>
</head>
<body>
    <div class="container profile-container">
        <h1>Seller Profile</h1>
        
        <%
            HttpSession session1 = request.getSession(false);
            String sellerName = (session != null) ? (String) session.getAttribute("sellerName") : null;
            
            if (sellerName != null) {
        %>
            <p>Welcome, <strong><%= sellerName %></strong></p>
            <a href="SellerLogoutServlet" class="btn btn-danger btn-logout">Logout</a>
            <p class="info-text">Click the button above to securely log out of your account.</p>
        <%
            } else {
        %>
            <p>Please <a href="SellerLogin.jsp">login</a> to access your profile.</p>
        <%
            }
        %>
    </div>
</body>
</html>
