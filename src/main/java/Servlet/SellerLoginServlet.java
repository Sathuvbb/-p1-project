package Servlet;

import java.io.IOException;

import Exception.SellerOperationException;
import dao.SellerDaoClass;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SellerLoginServlet")
public class SellerLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static SellerDaoClass sellerDao = new SellerDaoClass();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (sellerDao.isValidSeller(email, password)) {
		    HttpSession session = request.getSession();
		    session.setAttribute("sellerEmail", email);
		    response.sendRedirect("SellerDashboard.jsp");
		} else {
		    response.sendRedirect("SellerLogin.jsp?error=1");
		}
    }
}
