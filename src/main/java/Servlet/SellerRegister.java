package Servlet;

import java.io.IOException;
import Exception.SellerOperationException;
import dao.SellerDaoClass;
import dto.SellerRequest;
import entity.Seller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SellerRegisterServlet")
public class SellerRegister extends HttpServlet {
    
    private static SellerDaoClass sellerDao = new SellerDaoClass();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String businessName = request.getParameter("business_name");
        String businessDetails = request.getParameter("business_details");

        SellerRequest sellerRequest = new SellerRequest(email, password, businessName, businessDetails);
        sellerRequest.setEmail(email);
        sellerRequest.setPassword(password);
        sellerRequest.setBusinessName(businessName);
        sellerRequest.setBusinessDetails(businessDetails);

        try {
            if (sellerDao.createSeller(sellerRequest)) {
                response.sendRedirect("SellerLogin.jsp?registration=success");
            } else {
                response.sendRedirect("SellerRegister.jsp?error=1");
            }
        } catch (SellerOperationException e) {
            e.printStackTrace();
            response.sendRedirect("SellerRegister.jsp?error=1");
        } catch (IOException e) {
            e.printStackTrace();
            response.sendRedirect("SellerRegister.jsp?error=1");
        }
    }
}
