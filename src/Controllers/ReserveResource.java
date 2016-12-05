/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import DAO.ReservesLogDAO;

/**
 *
 * @author Samantha Graham
 */
@WebServlet(name = "ReserveResource", urlPatterns = {"/ReserveResource"})
public class ReserveResource extends HttpServlet {

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
        String resourceId = request.getParameter("id");
        String resourceName = request.getParameter("name");
        
        String pickupDate = request.getParameter("pickup");
        String returnDate = request.getParameter("return");
        
        // Prepare to return
        RequestDispatcher rd = null;
        
        // First check if the dates are correct
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
            Date pickup = dateFormat.parse(pickupDate);
            Date dropoff = dateFormat.parse(returnDate);
            
            if(!dropoff.after(pickup)) {
                rd = request.getRequestDispatcher("viewresource.jsp?id=" + resourceId + "&name=" +resourceName);
                
                // Give them a message
                request.setAttribute("alert", "alert alert-danger");
                request.setAttribute("message", "You cannot return a resource before picking it up; you are not a time lord.");
            } else {
                // Otherwise, reserve it
                // We'll need the user's id from the session
                HttpSession session = request.getSession();
                
                // Instantiate the DAO
                ReservesLogDAO rld = new ReservesLogDAO();
                
                // Create the reservation
                rld.makeReservation(Integer.parseInt(session.getAttribute("user_id").toString()), Integer.parseInt(resourceId), pickupDate, returnDate);
                
                // Give them a message
                request.setAttribute("alert", "alert alert-success");
                request.setAttribute("message", "You have successfully reserved your item.");
                
                // Return
                rd = request.getRequestDispatcher("resources.jsp");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        
        // Return
        rd.forward(request, response);
    }
}
