<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
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

    .register-container {
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
        padding: 20px;
        width: 100%;
        max-width: 400px;
        text-align: center;
    }

    .register-container h1 {
        color: #333;
        margin-bottom: 20px;
    }

    .register-container .form-label {
        font-weight: bold;
        color: #555;
        text-align: left;
    }

    .register-container input {
        border-radius: 4px;
        border: 1px solid #ddd;
        font-size: 14px;
    }

    .register-container button {
        background-color: #007bff;
        color: white;
        border: none;
        padding: 10px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        width: 100%;
    }

    .register-container button:hover {
        background-color: #0056b3;
    }

    .register-container .error-message {
        color: red;
        margin-top: 10px;
    }

    .register-container .form-text {
        margin-top: 10px;
    }

    .register-container .form-text a {
        color: #007bff;
        text-decoration: none;
    }

    .register-container .form-text a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <div class="register-container">
        <h1>Register</h1>
        <form action="RegisterServlet" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Username:</label>
                <input type="text" id="username" name="username" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="text" id="email" name="email" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
    
        <p class="form-text mt-3"><a href="Login.jsp">Back to Login</a></p>
    
        <% String error = request.getParameter("error");
           if (error != null && error.equals("1")) { %>
            <p class="error-message">Registration failed. Please try again.</p>
        <% } %>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
