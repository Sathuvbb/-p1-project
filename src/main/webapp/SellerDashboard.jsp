<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .sidebar {
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            width: 250px;
            background-color: #343a40;
            color: #fff;
            padding-top: 20px;
            padding-left: 20px;
        }

        .sidebar a {
            color: #fff;
            text-decoration: none;
            font-size: 18px;
            display: block;
            margin: 10px 0;
        }

        .sidebar a:hover {
            background-color: #495057;
            border-radius: 5px;
            padding: 10px;
        }

        .main-content {
            margin-left: 270px;
            padding: 20px;
        }

        .header {
            background-color: #007bff;
            color: #fff;
            padding: 15px;
            text-align: center;
            font-size: 24px;
            font-weight: bold;
        }

        .action-card {
            margin: 20px 0;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .action-card h3 {
            margin-bottom: 20px;
        }

        .action-card a {
            display: inline-block;
            padding: 10px 20px;
            color: #fff;
            background-color: #007bff;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
        }

        .action-card a:hover {
            background-color: #0056b3;
        }

        .profile-menu {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 15px;
            margin-bottom: 20px;
        }

        .profile-menu a {
            color: #007bff;
            text-decoration: none;
        }

        .profile-menu a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="sidebar">
        <h4>Dashboard</h4>
        <a href="CreateProduct.jsp">Create Product</a>
        <a href="UpdateProduct.jsp">Update Product</a>
        <a href="DeleteProduct.jsp">Delete Product</a>
        <a href="ListProducts.jsp">View Products</a>
    </div>

    <div class="main-content">
        <div class="header">
            <div class="d-flex justify-content-between align-items-center">
                <span>Welcome, <strong>${sessionScope.username}</strong></span>
                <div>
                    <a href="profile.jsp" class="btn btn-light">View Profile</a>
                    <a href="SellerLogout.jsp" class="btn btn-danger ms-2">Logout</a>
                </div>
            </div>
        </div>

        <h1 class="text-center mb-4">Manage Products</h1>

        <!-- Create Product -->
        <div class="action-card">
            <h3>Create New Product</h3>
            <a href="CreateProduct.jsp" class="btn btn-primary">Create Product</a>
        </div>

        <!-- Update Product -->
        <div class="action-card">
            <h3>Update Existing Product</h3>
            <a href="UpdateProduct.jsp" class="btn btn-primary">Update Product</a>
        </div>

        <!-- Delete Product -->
        <div class="action-card">
            <h3>Delete Product</h3>
            <a href="DeleteProduct.jsp" class="btn btn-primary">Delete Product</a>
        </div>
        
        <!-- List Products -->
        <div class="action-card">
            <h3>List Products</h3>
            <a href="ListProducts.jsp" class="btn btn-primary">View Products</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
