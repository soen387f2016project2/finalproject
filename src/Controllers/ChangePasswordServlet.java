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
      
        String newPw = request.getParameter("newPassword");
        String confirmPw = request.getParameter("newPasswordConfirm");
        String goToPage =  request.getParameter("whichUser");
        
        RequestDispatcher rd = null;
        // Prepare to return
        if(goToPage.equals("loginUser"))
        	rd = request.getRequestDispatcher("change-password.jsp");
        else{
        	rd = request.getRequestDispatcher("edit-user.jsp?id=" + request.getParameter("editID"));
        }
        
        // First, make sure nothing is empty
        if(newPw.isEmpty() || confirmPw.isEmpty()) {            
            // Give them a message
            request.setAttribute("alert", "alert alert-danger");
            request.setAttribute("message", "You must fill in all fields");
        } else if(!newPw.equals(confirmPw)) { // Next, make sure the password and its confirmation are equal
                // Give them a message
                request.setAttribute("alert", "alert alert-danger");
                request.setAttribute("message", "Passwords don't match");
            } else {
            	
            	
                // Now let's see if they entered the right current password! So exciting.
                // Instantiate the UsersDAO
                UsersDAO dao = new UsersDAO();
                
                // Get the user's id from the session and do the logic for change-password.jsp page request
                if(goToPage.equals("loginUser")){
                
	                HttpSession session = request.getSession();
	                String userId = session.getAttribute("user_id").toString();
	                
	                // User it to get their password from the db
	                String userPassword = dao.getPassword(userId);
	                String currentPw = request.getParameter("currentPassword");
	                // Check equality
	                if(!currentPw.equals(userPassword)) {
	                    // Give them a message
	                    request.setAttribute("alert", "alert alert-danger");
	                    request.setAttribute("message", "You entered an incorrect current password");
	                } else {
	                    // Actually update the damn password
	                    dao.updatePassword(Integer.parseInt(userId), newPw);
	                
	                    // And let them know!
	                    request.setAttribute("alert", "alert alert-success");
	                    request.setAttribute("message", "Password successfully updated!");
	                	}
	                
	                }//end of if statement for checking is request comes from change-password.jsp
                //else for changing password request from edit-user.jsp
                else {
               	 dao.updatePassword(Integer.parseInt(request.getParameter("editID")), newPw);
               	 request.setAttribute("alert", "alert alert-success");
               	 request.setAttribute("message", "Password successfully updated!");
               	}
            
             }
        
        // Return
        rd.forward(request, response);
    }
}
