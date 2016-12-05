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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mimi
 */

@WebServlet(name = "SearchResources", urlPatterns = {"/SearchResources"})
public class SearchResources extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String type = request.getParameter("search-resource-type");
        String term = request.getParameter("search-text");
        ArrayList<ResourcesWeb> list = new ArrayList<ResourcesWeb>();
        
        if (term.isEmpty() && type.equals("AllConferenceRooms"))
        {
            try {
                list = getAllConferenceRooms();
            } catch (SQLException ex) {
                Logger.getLogger(SearchResources.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (term.isEmpty()  && type.equals("AllEquipments"))
        {
            try {
                list = getAllITEquipments();
            } catch (SQLException ex) {
                Logger.getLogger(SearchResources.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (term.isEmpty()&& type.equals("AllResources"))
        {
            try {
                list = getAllResources();
            } catch (SQLException ex) {
                Logger.getLogger(SearchResources.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (!term.isEmpty())
        {
            
        }

        // Set myList parameter
        request.setAttribute("mylist", list);
        
        // ShowResults
        RequestDispatcher rd = request.getRequestDispatcher("resources.jsp");    
        rd.forward(request, response);
    }
    
    private ArrayList<ResourcesWeb> getAllResources() throws SQLException
    {
        ArrayList<ResourcesWeb> list = new ArrayList<ResourcesWeb>();
        ResourcesDAO dao = new ResourcesDAO();
        ResultSet resultSet = dao.getAllResources();
        
        while (resultSet != null && resultSet.next()) {

            int resourceID =  Integer.getInteger(resultSet.getString("resourceID"));
            boolean isMaintained = (Integer.getInteger(resultSet.getString(2)) !=0);
            String resourceName = resultSet.getString("resourceName");
            String description = resultSet.getString("description");
            int hasPhone = Integer.getInteger(resultSet.getString("hasPhone"));
            int hasWhiteboard = Integer.getInteger(resultSet.getString("hasWhiteboard"));
            String location = resultSet.getString("location");
            int capacity = Integer.getInteger(resultSet.getString("capacity"));
            int isDesktop = Integer.getInteger(resultSet.getString("isDesktop"));
            String computerModel = resultSet.getString("computerModel");
            int screenSize = Integer.getInteger(resultSet.getString("screenSize"));
            String cpu = resultSet.getString("cpu");
            String ram = resultSet.getString("ram");
            String storage = resultSet.getString("storage");
            String projectorModel = resultSet.getString("projectorModel");
            String maxRes = resultSet.getString("maxRes");
            
            ConferenceRoomWeb cr;
            ProjectorWeb p;
            ComputerWeb cp;
            MiscWeb m;

            if (resourceName.equals("conferenceRoom"))
            {
                boolean hasWhiteboardBool = hasWhiteboard != 0;
                boolean hasPhoneBool = hasPhone != 0;
                cr = new ConferenceRoomWeb(resourceID, location, capacity, hasWhiteboardBool, hasPhoneBool);
                list.add(cr);
            }
            else if (resourceName.equals("Projector"))
            {
                p = new ProjectorWeb(resourceID, resourceName, description, projectorModel, maxRes);
                list.add(p);
            }
            else if (resourceName.equals("Computer"))
            {    
                cp = new ComputerWeb(resourceID, resourceName, computerModel,screenSize, cpu, ram, storage, isDesktop);
                list.add(cp);
            }
            else if (resourceName.equals("Misc"))
            {    
                m = new MiscWeb(resourceID, description);
                list.add(m);
            }
        }
        
        return list;
    }
    
    public ArrayList<ResourcesWeb> getAllConferenceRooms() throws SQLException
    {
        ArrayList<ResourcesWeb> list = new ArrayList<ResourcesWeb>();
        
        ResourcesDAO dao = new ResourcesDAO();
        ResultSet resultSet = dao.getAllResources();
        
        while (resultSet != null && resultSet.next()) {

            int resourceID =  Integer.getInteger(resultSet.getString("resourceID"));
            boolean isMaintained = (Integer.getInteger(resultSet.getString(2)) !=0);
            String resourceName = resultSet.getString("resourceName");
            String description = resultSet.getString("description");
            int hasPhone = Integer.getInteger(resultSet.getString("hasPhone"));
            int hasWhiteboard = Integer.getInteger(resultSet.getString("hasWhiteboard"));
            String location = resultSet.getString("location");
            int capacity = Integer.getInteger(resultSet.getString("capacity"));
            
            ConferenceRoomWeb cr;

            if (resourceName.equals("conferenceRoom"))
            {
                boolean hasWhiteboardBool = hasWhiteboard != 0;
                boolean hasPhoneBool = hasPhone != 0;
                cr = new ConferenceRoomWeb(resourceID, location, capacity, hasWhiteboardBool, hasPhoneBool);
                list.add(cr);
            }

        }
        
        return list;
    }
    
    public ArrayList<ResourcesWeb> getAllITEquipments() throws SQLException
    {
        ArrayList<ResourcesWeb> list = new ArrayList<ResourcesWeb>();
        ResourcesDAO dao = new ResourcesDAO();
        ResultSet resultSet = dao.getAllResources();
        
        while (resultSet != null && resultSet.next()) {

            int resourceID =  Integer.getInteger(resultSet.getString("resourceID"));
            boolean isMaintained = (Integer.getInteger(resultSet.getString(2)) !=0);
            String resourceName = resultSet.getString("resourceName");
            String description = resultSet.getString("description");
            int isDesktop = Integer.getInteger(resultSet.getString("isDesktop"));
            String computerModel = resultSet.getString("computerModel");
            int screenSize = Integer.getInteger(resultSet.getString("screenSize"));
            String cpu = resultSet.getString("cpu");
            String ram = resultSet.getString("ram");
            String storage = resultSet.getString("storage");
            String projectorModel = resultSet.getString("projectorModel");
            String maxRes = resultSet.getString("maxRes");
            
            ProjectorWeb p;
            ComputerWeb cp;
            MiscWeb m;

            if (resourceName.equals("Projector"))
            {
                p = new ProjectorWeb(resourceID, resourceName, description, projectorModel, maxRes);
                list.add(p);
            }
            else if (resourceName.equals("Computer"))
            {    
                cp = new ComputerWeb(resourceID, resourceName, computerModel,screenSize, cpu, ram, storage, isDesktop);
                list.add(cp);
            }
            else if (resourceName.equals("Misc"))
            {    
                m = new MiscWeb(resourceID, description);
                list.add(m);
            }
        }
        
        return list;        
    }
    
    
}
