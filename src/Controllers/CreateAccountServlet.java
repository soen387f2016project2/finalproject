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

@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {
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
        
        // Get the inputs and create a new record in the Users table
        createNewAccount(request);
      
        // Return to the dashboard
        RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");    
        rd.forward(request, response);
    }
    
    private void createNewAccount(HttpServletRequest request)
    {
        // Get the inputs
        HttpSession session = request.getSession();
        String userName = request.getParameter("endUserName");   
        String firstName = request.getParameter("endUserFirstName");   
        String lastName = request.getParameter("endUserLastName");   
        String fullName = firstName + ", " + lastName;
        String password = request.getParameter("endUserPassword");      
        int userId = Integer.getInteger(session.getAttribute("user_id").toString());
        
        // Comment: UI missing email, phone number and department field
        // Assume that the information is valid and update in the DB
        UsersDAO dao = new UsersDAO();
        dao.addUser(0, "email", password, fullName, "phoneNumber", "department");
    }
}
