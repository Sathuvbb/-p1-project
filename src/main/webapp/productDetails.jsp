<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="dto.ProductResponse" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Details</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; }
        .card { border: none; border-radius: 10px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        .card-img-top { height: 300px; object-fit: cover; }
    </style>
</head>
<body>
<div class="container mt-4">
    <h1 class="text-center mb-4">Product Details</h1>
    <%
        ProductResponse product = (ProductResponse) request.getAttribute("product");
        if (product != null) {
    %>
    <div class="row">
        <div class="col-md-6">
            <img src="<%= product.getImageUrl() %>" class="img-fluid" alt="<%= product.getName() %>">
        </div>
        <div class="col-md-6">
            <h2><%= product.getName() %></h2>
            <p><%= product.getDescription() %></p>
            <p>Price: $<%= product.getPrice() %></p>
            <p class="text-success">Discounted Price: $<%= product.getDiscountedPrice() %></p>
            <p>Stock Quantity: <%= product.getStockQuantity() %></p>
            <form action="addToCart" method="post">s
                <input type="hidden" name="userId" value="<%= session.getAttribute("userId") %>">
                <input type="hidden" name="productId" value="<%= product.getProductId() %>">
                <input type="hidden" name="quantity" value="1">
                <button type="submit" class="btn btn-primary">Add to Cart</button>
            </form>
            <a href="buyNow?productId=<%= product.getProductId() %>&price=<%= product.getPrice() %>&discountedPrice=<%= product.getDiscountedPrice() %>&stockQuantity=<%= product.getStockQuantity() %>" class="btn btn-success mt-2">Buy Now</a>
        </div>
    </div>
    <%
        } else {
    %>
    <p>Product not found.</p>
    <%
        }
    %>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
