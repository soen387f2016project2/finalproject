/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/ChangePasswordServlet"})
public class ChangePasswordServlet extends HttpServlet {

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
        // Get the data from the request
        String currentPw = request.getParameter("currentPassword");
        String newPw = request.getParameter("newPassword");
        String confirmPw = request.getParameter("newPasswordConfirm");
        
        // Prepare to return
        RequestDispatcher rd = request.getRequestDispatcher("change-password.jsp");
        
        // First, make sure nothing is empty
        if(currentPw.isEmpty() || newPw.isEmpty() || confirmPw.isEmpty()) {            
            // Give them a message
            request.setAttribute("error", true);
            request.setAttribute("message", "You must fill in all fields");
        } else {
            // Next, make sure the password and its confirmation are equal
            if(!newPw.equals(confirmPw)) {
                // Give them a message
                request.setAttribute("error", true);
                request.setAttribute("message", "Passwords don't match");
            } else {
                // Now let's see if they entered the right current password! So exciting.
                // Instantiate the UsersDAO
                UsersDAO dao = new UsersDAO();
                
                // Get the user's id from the session
                HttpSession session = request.getSession();
                String userId = session.getAttribute("user_id").toString();
                
                // User it to get their password from the db
                String userPassword = dao.getPassword(userId);
                
                // Check equality
                if(!currentPw.equals(userPassword)) {
                    // Give them a message
                    request.setAttribute("error", true);
                    request.setAttribute("message", "You entered an incorrect current password");
                } else {
                    // Actually update the damn password
                    dao.updatePassword(Integer.parseInt(userId), newPw);
                    
                    // And let them know!
                    request.setAttribute("error", false);
                    request.setAttribute("message", "Password successfully updated!");
                }
            }
        }
        
        // Return
        rd.forward(request, response);
    }
}
