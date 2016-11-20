/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.UsersDAO;
import Demo.UsersWeb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author mimi
 */

@WebServlet(name = "EditUserServlet", urlPatterns = {"/EditUserServlet"})
public class EditUserServlet extends HttpServlet {
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
        
        // Get the input
        HttpSession session = request.getSession();
        int userId = Integer.getInteger(session.getAttribute("user_id").toString());
        
        // Verify that the delete button was clicked on
        if(request.getParameter("delete") != null)
        {
            // Remove user from the DB
            UsersDAO dao = new UsersDAO();
            dao.deleteUser(userId);
        }
        
         
        // Return to the login page
        RequestDispatcher rd = request.getRequestDispatcher("login.html");    
        rd.forward(request, response);
    }
}
