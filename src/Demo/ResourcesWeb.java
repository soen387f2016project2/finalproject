/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tino_
 */
package Demo;

import DAO.ConnectionFactory;
import java.util.Date;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.ResourcesDAO;
import DAO.ReservesLogDAO;

public class ResourcesWeb {

    //public enum Status {AVAILABLE, RESERVED};
    private static int resourceID;
    private static String resourceName;
    private static boolean isMaintained;
    private static String description;
    private static LinkedList<Reservation> reservations;
    private static boolean isAvailable;

    public ResourcesWeb(int id, String resourcename, String description) {
        this.resourceID = id;
        this.resourceName = resourcename;
        this.description = description;
        boolean isMaintained = true;//???
        reservations = new LinkedList<Reservation>();
        boolean isAvailable = true;

    }

    public ResourcesWeb(int id, String resourcename, String description, boolean isMaintained, boolean isAvailable, Date startDate, Date endDate) {

    }

    public static int getResourceID() {
        return resourceID;
    }

    //should never use, kept for testing purposes
    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public static LinkedList<ResourcesWeb> getAllResources() {
        // Create a list of resources
        LinkedList<ResourcesWeb> resources = new LinkedList<ResourcesWeb>();

        String sql = "SELECT * "
                + "FROM resources r "
                + "LEFT JOIN miscellaneous i ON i.resourceID=r.resourceID "
                + "LEFT JOIN conferenceRoom c ON c.resourceId=r.resourceID "
                + "LEFT JOIN computer comp ON comp.resourceId=r.resourceID "
                + "LEFT JOIN projector p ON p.resourceId=r.resourceID";

        ResultSet resourcesResultSet = ConnectionFactory.executeQuery(sql);

        // Loop through the resources
        try {
            while (resourcesResultSet != null && resourcesResultSet.next()) {
                // Create a resource from the result set
                ResourcesWeb res = new ResourcesWeb(Integer.parseInt(resourcesResultSet.getString("resourceID")), resourcesResultSet.getString("resourceName"),
                        resourcesResultSet.getString("description"));

                // Add it to the linked list
                resources.add(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for(int i = 0; i < resources.size(); i++) {
            System.out.println(resources.get(i).getResourceID());
        }

        // Return the resources
        return resources;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public static boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean getMaintained() {
        return isMaintained;
    }

    public void setMaintained(boolean isMaintained) {
        this.isMaintained = isMaintained;
    }

    public static String getDescription() {
        return description + " isMaintained:\t" + isMaintained + " isAvailable:\t" + isAvailable;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public void reserve(Date start, Date end, EndUser user, Date currentDate) {      
        reservations.add(new Reservation(start, end, user));
        if (start.before(currentDate) && end.after(currentDate)) {
            status = Status.RESERVED;
        }
    }*/
    /**
     *
     * @return null if the resource has never been reserved
     */
    public Reservation getLastReservation() {
        Reservation lastReservation = null;

        if (reservations.isEmpty()) {
            return lastReservation;
        } else {
            lastReservation = reservations.getFirst();
        }

        for (Reservation reservation : reservations) {
            if (reservation.getStart().before(lastReservation.getStart())) {
                lastReservation = reservation;
            }
        }
        return lastReservation;
    }

    public LinkedList<Reservation> getReservations() {
        return reservations;
    }

    // Other methods
    public static String classAsString() {
        return resourceName;
    }

    public static String descriptionString() {
        return getDescription();
    }
}
