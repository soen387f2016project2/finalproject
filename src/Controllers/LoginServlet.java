/*
 * Servlet (controller) that handles user login
 */
package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import DAO.UsersDAO;
import Demo.UsersWeb;

/**
 *
 * @author Samantha Graham
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the username and password from the request
        String username = request.getParameter("account");
        String password = request.getParameter("password");        
        
        // Instantiate the model that will authenticate the user
        UsersDAO dao = new UsersDAO();
        
        // Authenticate the user
        UsersWeb user = dao.login(username, password);
        
        // Prepare to return
        RequestDispatcher rd;
        
        // If the authentication failed
        if(user == null) {            
            // Send back to login form
            rd = request.getRequestDispatcher("login.jsp");
            
            // Give them a message
            request.setAttribute("message", "Your login details were incorrect; please try again");
        } else {            
            // Set the session things
            HttpSession session = request.getSession();
            session.setAttribute("user_id", user.getUserID());

            // Redirect to the dashboard
            rd = request.getRequestDispatcher("dashboard.jsp");            
            request.setAttribute("user", user.getFullName());
        }
        
        // Return
        rd.forward(request, response);
    }
}
