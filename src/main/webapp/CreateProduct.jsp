<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Product</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 800px;
            margin-top: 50px;
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #004085;
        }
        .form-control {
            border-radius: 0.25rem;
        }
        .form-control:focus {
            box-shadow: none;
            border-color: #007bff;
        }
        .card {
            padding: 20px;
            border: 1px solid #dee2e6;
            border-radius: 0.375rem;
            background-color: #ffffff;
        }
        .card-header {
            background-color: #007bff;
            color: #ffffff;
            padding: 10px;
            border-bottom: 1px solid #dee2e6;
            border-radius: 0.375rem 0.375rem 0 0;
        }
    </style>
    <script>
        window.onload = function() {
            const urlParams = new URLSearchParams(window.location.search);
            if (urlParams.get('success') === 'true') {
                alert('Product created successfully!');
            }
        };
    </script>
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>Create Product</h2>
            </div>
            <div class="card-body">
                <form action="product" method="post">
                    <input type="hidden" name="action" value="create">
                    
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" id="name" name="name" required>
                    </div>
                    <div class="form-group">
                        <label for="description">Description:</label>
                        <textarea class="form-control" id="description" name="description" rows="4" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="price">Price:</label>
                        <input type="number" step="0.01" class="form-control" id="price" name="price" required>
                    </div>
                    <div class="form-group">
                        <label for="discountedPrice">Discounted Price:</label>
                        <input type="number" step="0.01" class="form-control" id="discountedPrice" name="discountedPrice" required>
                    </div>
                    <div class="form-group">
                        <label for="imageUrl">Image URL:</label>
                        <input type="text" class="form-control" id="imageUrl" name="imageUrl" required>
                    </div>
                    <div class="form-group">
                        <label for="categoryId">Category ID:</label>
                        <input type="number" class="form-control" id="categoryId" name="categoryId" required>
                    </div>
                    <div class="form-group">
                        <label for="sellerId">Seller ID:</label>
                        <input type="number" class="form-control" id="sellerId" name="sellerId" required>
                    </div>
                    <div class="form-group">
                        <label for="stockQuantity">Stock Quantity:</label>
                        <input type="number" class="form-control" id="stockQuantity" name="stockQuantity" required>
                    </div>
                    <div class="form-group">
                        <label for="thresholdQuantity">Threshold Quantity:</label>
                        <input type="number" class="form-control" id="thresholdQuantity" name="thresholdQuantity" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Create Product</button>
                </form>
            </div>
        </div>
    </div>
    
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
