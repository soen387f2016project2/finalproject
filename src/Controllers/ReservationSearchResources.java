/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ResourcesDAO;
import Demo.ResourcesWeb;
import Demo.ComputerWeb;
import Demo.ConferenceRoomWeb;
import Demo.ProjectorWeb;
import Demo.MiscWeb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mimi
 */

@WebServlet(name = "ReservationSearchResources", urlPatterns = {"/ReservationSearchResources"})
public class ReservationSearchResources extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("search-resource-type");

        String term = request.getParameter("search-text");

        LinkedList<ResourcesWeb> list = new LinkedList<ResourcesWeb>();

        
        if (term.isEmpty() && type.equals("Room"))
        {
            try {
                list = getAllConferenceRooms();
            } catch (SQLException ex) {
                Logger.getLogger(ReservationSearchResources.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (term.isEmpty()  && type.equals("Equipment"))
        {
            try {
                list = getAllITEquipments();
            } catch (SQLException ex) {
                Logger.getLogger(ReservationSearchResources.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (term.isEmpty()&& type.equals("AllResources"))
        {
            list=null;
        }
        else if (!term.isEmpty())
        {
            System.out.println("serch " + term);
            System.out.println( (new ResourcesDAO()).getResourceByName(term).size());
            if((new ResourcesDAO()).getResourceByName(term) != null &&  (new ResourcesDAO()).getResourceByName(term).size()!=0 )
            {
                System.out.println("serch");
                ResourcesDAO resourceDao = new ResourcesDAO();
                list =  resourceDao.getResourceByName(term);
            }
            else 
            {
                list = null;
            }
        }

        // Set myList parameter
        request.setAttribute("mylist", list);
        
        // ShowResults
        RequestDispatcher rd = request.getRequestDispatcher("resources.jsp");    
        rd.forward(request, response);
    }
    
   
    public LinkedList<ResourcesWeb> getAllConferenceRooms() throws SQLException
    {
        System.out.println("getAllConferenceRooms");
        LinkedList<ResourcesWeb> tmplist  =  ResourcesWeb.getAllAvailableResources();
        LinkedList<ResourcesWeb> list = new LinkedList<ResourcesWeb>();
        
        for (int i = 0 ; i < tmplist.size() ; i++)
        {
            if (tmplist.get(i).getResourceType(tmplist.get(i).getResourceID()).equals("Conference")){
                list.add(tmplist.get(i));
            }
        }
        
  
        return list;
    }
    
    public LinkedList<ResourcesWeb> getAllITEquipments() throws SQLException
    {
        
        System.out.println("getAllConferenceRooms");
        LinkedList<ResourcesWeb> tmplist  =  ResourcesWeb.getAllAvailableResources();
        LinkedList<ResourcesWeb> list = new LinkedList<ResourcesWeb>();
        
        for (int i = 0 ; i < tmplist.size() ; i++)
        {
            if (tmplist.get(i).getResourceType(tmplist.get(i).getResourceID()).equals("Projector") ||  
                tmplist.get(i).getResourceType(tmplist.get(i).getResourceID()).equals("Computer") || 
                tmplist.get(i).getResourceType(tmplist.get(i).getResourceID()).equals("Misc")){
                list.add(tmplist.get(i));
            }
        }        
        
        return list;        
    }
    
    
}
