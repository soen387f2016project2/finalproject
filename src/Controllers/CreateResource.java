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
@WebServlet(name = "CreateResource", urlPatterns = {"/CreateResource"})
public class CreateResource extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("inventory-report.jsp");  
        
        // Initialize DAO
        ResourcesDAO resourceDao = new ResourcesDAO();
        
        // Figure out what kind of resource we're adding
        String resourceType = request.getParameter("resourceType");       
        
        // And create it
        switch(resourceType) {
            case "computer":
                int isDesktop = 1;
                System.out.println(request.getParameter("computerType"));
                if(request.getParameter("computerType").equals("Laptop"))
                    isDesktop = 0;
                resourceDao.addResourceComputer(0, request.getParameter("computerName"), isDesktop, request.getParameter("computerModel"), 
                        Float.parseFloat(request.getParameter("computerSize")), request.getParameter("computerCPU"), request.getParameter("computerRAM"), 
                        request.getParameter("computerStorage"));
                break;
            case "projector":
                resourceDao.addResourceProjector(0, request.getParameter("projectorName"), request.getParameter("projectorModel"), request.getParameter("projectorRes"));
                break;
            case "conferenceRoom":
                int hasWhiteboard = 0;
                if(request.getParameter("whiteboard").equals("hasWhiteboard"))
                    hasWhiteboard = 1;
                
                int hasPhone = 0;
                if(request.getParameter("telephone").equals("hasTelephone"))
                    hasPhone = 1;
                
                resourceDao.addResourceConferenceRoom(0, request.getParameter("roomName"), request.getParameter("roomLocation"), Integer.parseInt(request.getParameter("roomCapacity")),
                        hasWhiteboard, hasPhone);
                break;
            case "misc":
                resourceDao.addResourceMiscellaneous(0, request.getParameter("miscName"), request.getParameter("description"));
                break;
        }
        
        // Return
        rd.forward(request, response);
    }

}
