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
import DAO.ResourcesDAO;

/**
 *
 * @author Samantha Graham
 */
@WebServlet(name = "SearchInventory", urlPatterns = {"/SearchInventory"})
public class SearchInventory extends HttpServlet {

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
        // Prepare to return
        RequestDispatcher rd = request.getRequestDispatcher("search-results.jsp");  
        
        // Initialize DAO
        ResourcesDAO resourceDao = new ResourcesDAO();
        
        // Figure out what we're searching for
        String searchTerm = request.getParameter("searchInventory");  
        
        // And put it in a variable for the view
        request.setAttribute("resources", resourceDao.getResourceByName(searchTerm));        
        
        // Return
        rd.forward(request, response);
    }

}
