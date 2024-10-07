
package Servlet;
import java.io.IOException;


import Exception.UserOperationException;
import dao.UserDaoClass;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static UserDaoClass UserDao = new UserDaoClass();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String username = request.getParameter("username");
	        String password = request.getParameter("password");
	    
	        if (UserDao.isValidUser(username, password)) {
	        	 System.out.println("Hi - "+username);
	            HttpSession session = request.getSession();
	            session.setAttribute("username", username);
	            response.sendRedirect("DashBoard.jsp");
	           
	        } else {
	            response.sendRedirect("Login.jsp?error=1");
	        	System.out.println("Error");
	        }
}


}
