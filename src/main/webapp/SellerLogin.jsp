<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seller Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background-color: #f5f5f5;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .login-container {
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
        padding: 20px;
        width: 100%;
        max-width: 400px;
        text-align: center;
    }

    .login-container h1 {
        color: #333;
        margin-bottom: 20px;
    }

    .login-container label {
        font-weight: bold;
        color: #555;
        text-align: left;
    }

    .login-container input[type="text"],
    .login-container input[type="password"] {
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
        font-size: 14px;
        width: 100%;
        margin-bottom: 15px;
    }

    .login-container button {
        background-color: #007bff;
        color: white;
        border: none;
        padding: 10px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        width: 100%;
    }

    .login-container button:hover {
        background-color: #0056b3;
    }

    .login-container p {
        margin: 10px 0;
        font-size: 14px;
    }

    .login-container a {
        color: #007bff;
        text-decoration: none;
    }

    .login-container a:hover {
        text-decoration: underline;
    }

    .login-container .error-message {
        color: red;
    }
</style>
</head>
<body>
    <div class="login-container">
        <h1>Seller Login</h1>
        <form action="SellerLoginServlet" method="post">
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="text" id="email" name="email" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>

        <p class="forgot-password"><a href="ForgotPassword.jsp">Forgot Password?</a></p>

        <p><a href="SellerRegister.jsp">Register</a></p>

        <% String error = request.getParameter("error");
            if (error != null && error.equals("1")) { %>
                <p class="error-message">Invalid email or password. Please try again.</p>
        <% } %>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
