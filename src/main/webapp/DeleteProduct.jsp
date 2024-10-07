<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header bg-danger text-white">
                <h4 class="mb-0">Delete Product</h4>
            </div>
            <div class="card-body">
                <form action="product" method="post">
                    <input type="hidden" name="action" value="delete">
                    
                    <div class="form-group">
                        <label for="productId">Product ID</label>
                        <input type="text" id="productId" name="productId" class="form-control" placeholder="Enter product ID" required>
                    </div>
                    
                    <div class="alert alert-warning mt-3" role="alert" id="warningAlert" style="display:none;">
                        <strong>Warning!</strong> Are you sure you want to delete the product with ID <strong id="productIdAlert"></strong>?
                    </div>
                    
                    <button type="submit" class="btn btn-danger btn-lg">Delete Product</button>
                    <a href="SellerDashboard.jsp" class="btn btn-secondary btn-lg">Cancel</a>
                </form>
            </div>
        </div>
    </div>

    <script>
        document.querySelector('form').addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent form submission to show alert first
            
            const productId = document.getElementById('productId').value;
            if (productId) {
                // Show warning alert
                document.getElementById('productIdAlert').textContent = productId;
                document.getElementById('warningAlert').style.display = 'block';
                
                // Optionally, you can use a confirmation dialog
                if (confirm(`Are you sure you want to delete the product with ID ${productId}?`)) {
                    this.submit(); // Submit the form if confirmed
                }
            } else {
                alert('Please enter a product ID.');
            }
        });
    </script>
</body>
</html>
