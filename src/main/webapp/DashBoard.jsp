<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<style>
    body {
        padding-top: 70px; /* Adjusted to account for the fixed navbar */
    }
    .hero-section {
        background: url('https://via.placeholder.com/1200x400') no-repeat center center;
        background-size: cover;
        color: white;
        padding: 80px 0;
        text-align: center;
    }
    .hero-section h1 {
        font-size: 3rem;
        font-weight: bold;
    }
    .card-deck .card {
        border: none;
        border-radius: 15px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        transition: all 0.3s ease-in-out;
    }
    .card-deck .card:hover {
        transform: translateY(-10px);
        box-shadow: 0 6px 12px rgba(0,0,0,0.3);
    }
    .card-header {
        background-color: #007bff;
        color: white;
        font-weight: bold;
        border-bottom: none;
        border-radius: 15px 15px 0 0;
    }
    .dashboard-container {
        margin: 30px auto;
        max-width: 1200px;
    }
    .footer {
        background-color: #f1f1f1;
        padding: 20px 0;
        text-align: center;
        border-top: 1px solid #ddd;
    }
</style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Sai Dashboard</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="Home.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="productDetails.jsp">Product</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Orders.jsp">Orders</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Cart.jsp"><i class="fas fa-shopping-cart"></i> Cart</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarProfile" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Profile
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarProfile">
                            <li><a class="dropdown-item" href="Profile.jsp">My Profile</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="Logout.jsp">Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="hero-section">
        <h1>Welcome to Your Dashboard</h1>
        <p>Manage your products, orders, and more with ease.</p>
    </div>

    <div class="container dashboard-container">
        <div class="row">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-header">Product Overview</div>
                    <div class="card-body">
                        <h5 class="card-title">Latest Products</h5>
                        <p class="card-text">View and manage your latest products here.</p>
                        <a href="productList.jsp" class="btn btn-primary">View Products</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-header">Order Summary</div>
                    <div class="card-body">
                        <h5 class="card-title">Recent Orders</h5>
                        <p class="card-text">Check your recent orders and their statuses.</p>
                        <a href="Orders.jsp" class="btn btn-primary">View Orders</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-header">Cart Status</div>
                    <div class="card-body">
                        <h5 class="card-title">Current Cart</h5>
                        <p class="card-text">Manage items in your cart.</p>
                        <a href="Cart.jsp" class="btn btn-primary">View Cart</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="footer">
        <p>&copy; 2024 Sai Dashboard. All Rights Reserved.</p>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
