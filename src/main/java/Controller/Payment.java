package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/buyNow")
public class Payment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve product details from the request parameters
        String productId = request.getParameter("productId");
        String price = request.getParameter("price");
        String discountedPrice = request.getParameter("discountedPrice");
        String stockQuantity = request.getParameter("stockQuantity");

        // Set the product details as request attributes
        request.setAttribute("productId", productId);
        request.setAttribute("price", price);
        request.setAttribute("discountedPrice", discountedPrice);
        request.setAttribute("stockQuantity", stockQuantity);

        // Forward to BuyNow.jsp
        request.getRequestDispatcher("BuyNow.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process payment
        boolean paymentSuccessful = processPayment(request);

        if (paymentSuccessful) {
            // Set payment details as request attributes
            request.setAttribute("productId", request.getParameter("productId"));
            request.setAttribute("price", request.getParameter("price"));
            request.setAttribute("discountedPrice", request.getParameter("discountedPrice"));
            request.setAttribute("stockQuantity", request.getParameter("stockQuantity"));
            request.setAttribute("paymentDate", request.getParameter("payment_date"));
            request.setAttribute("amount", request.getParameter("amount"));
            request.setAttribute("paymentMethod", request.getParameter("payment_method"));
            request.setAttribute("paymentStatus", "Successful");

            // Forward to paymentConfirmation.jsp
            request.getRequestDispatcher("paymentConfirmation.jsp").forward(request, response);
        } else {
            // Redirect to BuyNow.jsp with an error message
            response.sendRedirect("BuyNow.jsp?success=false");
        }
    }

    private boolean processPayment(HttpServletRequest request) {
        // Simulate payment processing logic
        // In a real implementation, you would handle actual payment processing and database updates

        // Return true if payment was successful, false otherwise
        return true; // Change this to actual payment success condition
    }
}
