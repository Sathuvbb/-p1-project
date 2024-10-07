<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .error-container {
            text-align: center;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            padding: 30px;
            max-width: 600px;
            margin: 20px;
        }
        .error-container h1 {
            font-size: 80px;
            margin-bottom: 20px;
        }
        .error-container h2 {
            font-size: 36px;
            margin-bottom: 20px;
        }
        .error-container p {
            font-size: 18px;
            margin-bottom: 30px;
        }
        .error-container a {
            color: #007bff;
            text-decoration: none;
        }
        .error-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1><i class="bi bi-exclamation-triangle-fill"></i></h1>
        <h2>Something Went Wrong!</h2>
        <p>We encountered an error while processing your request. Please try again later.</p>
        <a href="Login.jsp" class="btn btn-primary">Return to Login</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
