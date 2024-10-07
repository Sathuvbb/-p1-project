<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Confirmation</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <style>
        .confirmation-container {
            margin-top: 50px;
            text-align: center;
        }
        .alert-custom {
            background-color: #e7f4e4;
            color: #2e7d32;
            border-color: #c8e6c9;
        }
        .btn-custom {
            background-color: #007bff;
            color: white;
            border: none;
        }
        .btn-custom:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container confirmation-container">
        <div class="alert alert-custom alert-dismissible fade show" role="alert">
            <h4 class="alert-heading">Thank You for Your Payment!</h4>
            <p>Your payment has been processed successfully. Your payment details will be reviewed and you will receive a confirmation email within the next 5 to 7 days.</p>
            <hr>
            <p class="mb-0">If you have any questions, please contact our support team.</p>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>

        <a href="productList.jsp" class="btn btn-custom">Back to Home</a>
    </div>

    <!-- Include Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
