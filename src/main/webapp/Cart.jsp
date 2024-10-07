<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 80%;
        margin: auto;
        overflow: hidden;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
        background-color: #fff;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    }
    th, td {
        padding: 10px;
        border: 1px solid #ddd;
        text-align: left;
    }
    th {
        background-color: #4CAF50;
        color: #fff;
    }
    td {
        vertical-align: middle;
    }
    .cart-actions {
        text-align: right;
        margin-top: 20px;
    }
    .cart-actions button {
        padding: 10px 20px;
        font-size: 16px;
        color: #fff;
        background-color: #4CAF50;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    .cart-actions button:hover {
        background-color: #45a049;
    }
    .cart-actions a {
        padding: 10px 20px;
        font-size: 16px;
        color: #fff;
        background-color: #f44336;
        text-decoration: none;
        border-radius: 5px;
        cursor: pointer;
    }
    .cart-actions a:hover {
        background-color: #d32f2f;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Your Cart</h2>

        <table>
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${cartItems}">
                    <tr>
                        <td>${item.productName}</td>
                        <td>${item.price}</td>
                        <td>
                            <form action="updateCart" method="post" style="display:inline;">
                                <input type="hidden" name="productId" value="${item.productId}">
                                <input type="number" name="quantity" value="${item.quantity}" min="1" style="width: 60px;">
                                <button type="submit">Update</button>
                            </form>
                        </td>
                        <td>${item.total}</td>
                        <td>
                            <form action="removeFromCart" method="post" style="display:inline;">
                                <input type="hidden" name="productId" value="${item.productId}">
                                <button type="submit">Remove</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="cart-actions">
            <a href="checkout.jsp">Proceed to Checkout</a>
            <a href="productList.jsp">Continue Shopping</a>
        </div>
    </div>
</body>
</html>
