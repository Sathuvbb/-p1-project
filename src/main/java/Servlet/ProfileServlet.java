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
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Assuming you have a method to get the logged-in user's data
        User user = getUserFromSessionOrDatabase(request); // Implement this method
        
        request.setAttribute("user", user);
        request.getRequestDispatcher("Profile.jsp").forward(request, response);
    }

    private User getUserFromSessionOrDatabase(HttpServletRequest request) {
        // Retrieve the user object from the session or database
        HttpSession session = request.getSession();
        return (User) session.getAttribute("loggedInUser");
    }
}
