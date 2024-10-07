package Controller;

import java.io.IOException;

import Exception.CartDaoException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.CartDaoClass;

@WebServlet("/addToCart")
public class cart extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CartDaoClass cartDAO = new CartDaoClass();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try {
            cartDAO.addToCart(userId, productId, quantity);
        } catch (CartDaoException e) {
            e.printStackTrace();
        }
        response.sendRedirect("cart.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "GET method is not supported by this servlet.");
    }
}
