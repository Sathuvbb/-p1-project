package Controller;

import dao.ProductDAOImpl;


import dto.ProductRequest;
import dto.ProductResponse;
import Exception.ProductException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/product")
public class ProductController extends HttpServlet {

    private final ProductDAOImpl productDAO = new ProductDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            if ("create".equals(action)) {
                createProduct(req, resp);
            } else if ("update".equals(action)) {
                updateProduct(req, resp);
            } else if ("delete".equals(action)) {
                deleteProduct(req, resp);
            } else {
                resp.sendRedirect("error.jsp");
            }
        } catch (ProductException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ProductException {
        ProductRequest request = new ProductRequest(
            req.getParameter("name"),
            req.getParameter("description"),
            Double.parseDouble(req.getParameter("price")),
            Double.parseDouble(req.getParameter("discountedPrice")),
            req.getParameter("imageUrl"),
            Integer.parseInt(req.getParameter("categoryId")),
            Integer.parseInt(req.getParameter("sellerId")),
            Integer.parseInt(req.getParameter("stockQuantity")),
            Integer.parseInt(req.getParameter("thresholdQuantity"))
        );

        boolean isSuccess = productDAO.createProduct(request);
        if (isSuccess) {
            resp.sendRedirect("productList.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ProductException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        ProductRequest request = new ProductRequest(
            req.getParameter("name"),
            req.getParameter("description"),
            Double.parseDouble(req.getParameter("price")),
            Double.parseDouble(req.getParameter("discountedPrice")),
            req.getParameter("imageUrl"),
            Integer.parseInt(req.getParameter("categoryId")),
            Integer.parseInt(req.getParameter("sellerId")),
            Integer.parseInt(req.getParameter("stockQuantity")),
            Integer.parseInt(req.getParameter("thresholdQuantity")),
            productId
        );

        boolean isSuccess = productDAO.updateProduct(productId, request);
        if (isSuccess) {
            resp.sendRedirect("productDetails.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ProductException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        boolean isSuccess = productDAO.deleteProductById(productId);
        if (isSuccess) {
            resp.sendRedirect("productList.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<ProductResponse> products = productDAO.getAllProducts();
            req.setAttribute("products", products);
            req.getRequestDispatcher("productDetails.jsp").forward(req, resp);
        } catch (ProductException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}

