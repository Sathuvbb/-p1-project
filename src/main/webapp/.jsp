<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Product Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .product-details {
            max-width: 600px;
            margin: auto;
        }
        .product-details img {
            max-width: 300px;
            max-height: 300px;
        }
    </style>
</head>
<body>
    <div class="product-details">
        <h1>${product.name}</h1>
        <p>${product.description}</p>
        <p>Price: $${product.price}</p>
        <c:if test="${product.discountedPrice != null}">
            <p>Discounted Price: $${product.discountedPrice}</p>
        </c:if>
        <p>Stock: ${product.stockQuantity}</p>
        <c:if test="${product.imageUrl != null}">
            <img src="${product.imageUrl}" alt="${product.name} Image" />
        </c:if>
    </div>
</body>
</html>