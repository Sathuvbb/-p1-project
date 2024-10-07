<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Seller Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f7f7f7;
        }
        .registration-form {
            width: 400px;
            margin: 50px auto;
            padding: 30px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-title {
            margin-bottom: 20px;
            text-align: center;
            font-weight: bold;
            font-size: 24px;
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-register {
            width: 100%;
            background-color: #5cb85c;
            color: white;
            font-weight: bold;
        }
        .btn-register:hover {
            background-color: #4cae4c;
        }
    </style>
</head>
<body>
    <div class="registration-form">
        <h2 class="form-title">Seller Registration</h2>
        <form action="SellerRegisterServlet" method="post">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
            </div>
            <div class="form-group">
                <label for="businessName">Business Name:</label>
                <input type="text" class="form-control" id="businessName" name="business_name" placeholder="Enter business name">
            </div>
            <div class="form-group">
                <label for="businessDetails">Business Details:</label>
                <textarea class="form-control" id="businessDetails" name="business_details" placeholder="Enter business details" rows="4"></textarea>
            </div>
            <button type="submit" class="btn btn-register">Register</button>
        </form>
    </div>
</body>
</html>
