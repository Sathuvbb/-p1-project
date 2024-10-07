package Servlet;

import java.io.IOException;




import Exception.UserOperationException;
import dao.UserDaoClass;
import dto.UserRequest;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	
	private static UserDaoClass userDao=new  UserDaoClass();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        UserRequest userRequest = new UserRequest(username, password,email );
        userRequest.setName(username);
        userRequest.setEmail(email);
        userRequest.setPassword(password);

        //UserDao userDao = new UserDaoImpl();
        try {
			if (userDao.createUser(userRequest)) {
			    response.sendRedirect("Login.jsp?registration=success");
			} else {
			    response.sendRedirect("register.jsp?error=1");
			}
		} catch (UserOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}