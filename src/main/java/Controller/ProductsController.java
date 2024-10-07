package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import Exception.ProductException;
import Service.ProductService;
import dao.ProductDAOImpl;
import dto.ProductResponse;

@WebServlet("/searchProducts")  // The URL pattern should match the form action in the JSP
public class ProductsController extends HttpServlet {
	 private final ProductDAOImpl productService = new ProductDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getParameter("query"); // Get the search query from the request

        // Fetch the list of products based on the search query
        List<ProductResponse> productList = null;
        if (query != null && !query.isEmpty()) {
            try {
				productList = productService.searchProductsByName(query);
			} catch (ProductException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Assuming searchProducts is a method in ProductService
        } else {
            try {
				productList = productService.searchProductsByName(query);
			} catch (ProductException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Fetch all products if no query is provided
        }

        request.setAttribute("products", productList); // Set the products as a request attribute
        RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp"); // Forward to JSP
        dispatcher.forward(request, response);
    }
}
