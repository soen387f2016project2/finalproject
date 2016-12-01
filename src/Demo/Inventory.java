/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import DAO.ConnectionFactory;
import java.util.HashMap;
import DAO.ReservesLogDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mimi
 */
public class Inventory {
    
    // Attributes
    private HashMap resources; // Key = id, Value = Resource object
    private ReservesLogDAO reservesDao;
    
    // Constructor
    public Inventory()
    {
        resources = new HashMap();
        reservesDao = new ReservesLogDAO();
    }
    
    // Getters & Setters
    
    // Other methods
    private void createResourcesList()
    {
        String sql = "SELECT r.resourceID,r.isMaintained,r.description,r.resourceName," +
                "i.equipmentType,c.location,c.capacity " +
                "FROM resources r " +
                "LEFT JOIN ITEquipment i ON i.resourceID=r.resourceID " +
                "LEFT JOIN conferenceRoom c ON c.resourceId=r.resourceID";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                
                           /* 
                            Method to get a list of all the resources so we can display them in the page
                            <th>ID</th>
                            <th>Type</th>
                            <th>Description</th>
                            <th>Status</th>
                            <th>Reserved by</th>
                            <th>From</th>
                            <th>Until</th> */
                                    
                  /*      int resourceID = Integer.getInteger(resultSet.getString(1));
                        boolean isMaintained = (Integer.getInteger(resultSet.getString(2)) !=0);
                        String description = resultSet.getString(3);
                        String resourceName = resultSet.getString(4);
                        String equipmentType = resultSet.getString(5);
                        String location = resultSet.getString(6);
                        int capacity = Integer.getInteger(resultSet.getString(7));
               
                        ConferenceRoomWeb cr;
                        ProjectorWeb p;
                        ComputerWeb cp;
                        Misc m;
                        
                        if (resourceName.equals("conferenceRoom")
                            cr = new ConferenceRoomWeb(resourceID, location, capacity, false, false);
                        else if (resourceName.equals("Projector"))
                            p = new ProjectorWeb(resourceID, resourceName, description, "model", "resolution");
                        else if (resourceName.equals("Computer"))
                        {    
                            //cp;
                        }
                        else if (resourceName.equals("Misc"))
                        {    
                            //m;
                        }*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }
    
    public void createUnavailableRessourcesList()
    {
                    /*UI  <th>ID</th>
                            <th>Type</th>
                            <th>Description</th>
                            <th>Reserved by</th>
                            <th>From</th>
                            <th>Until</th>*/
                                    
        String sql = "SELECT r.resourceID,r.isMaintained,r.description,r.resourceName," +
                "i.equipmentType,c.location,c.capacity,rl.startDate,rl.endDate " +
                "FROM resources r " +
                "LEFT JOIN reservesLog rl ON rl.resourceID=r.resourceID " +
                "LEFT JOIN ITEquipment i ON i.resourceID=r.resourceID " +
                "LEFT JOIN conferenceRoom c ON c.resourceId=r.resourceID " +
                "WHERE rl.startDate<NOW() AND rl.endDate>NOW() OR isMaintained";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        /*int resourceID =  resultSet.getString(1;
                        boolean isMaintained: " + resultSet.getString(2);
                        String description: " + resultSet.getString(3);
                        String resourceName: " + resultSet.getString(4);
                        String location: " + resultSet.getString(5);
                        String capacity: " + resultSet.getString(6);*/
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
