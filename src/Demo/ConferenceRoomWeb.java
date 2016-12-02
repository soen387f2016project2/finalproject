package Demo;

import DAO.ReservesLogDAO;
import DAO.ResourcesDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/*
 * ignoring inheritance for the time being because we are just using these objects as containers
 */

public class ConferenceRoomWeb extends ResourcesWeb {
	
	// should this be an int instead of long for compatibility? YES
	private int resourceID;	// should  this have a setter? it is a foreign key
	private String location;
	private int capacity;
	private boolean hasWhiteboard;	// add these to the database
	private boolean hasPhone;		// add these to the database
	
	/* CONSTRUCTORS */
	
	public ConferenceRoomWeb(int resourceID, String location, int capacity, boolean hasWhiteboard, boolean hasPhone) 
	{
		super(resourceID,"Conference Room","Person capacity" + capacity + "Whiteboard:\t" + hasWhiteboard + " Phone:\t" + hasPhone);
		this.hasWhiteboard=hasWhiteboard;
		this.hasPhone=hasPhone;
		this.location = location;
		this.capacity = capacity;
	}
        
        public ConferenceRoomWeb(){}
        
        
    public ResourcesWeb getResourceById(int resourceID){
        ResourcesDAO resourcesDAO = new ResourcesDAO();
        ResultSet resultSet = resourcesDAO.getResourceById(resourceID);
        ConferenceRoomWeb cRWeb = null;
        try {
            while (resultSet != null && resultSet.next()) {
             
                cRWeb = new ConferenceRoomWeb(Integer.parseInt(resultSet.getString("resourceID")), 
                        resultSet.getString("location"),
                        Integer.parseInt(resultSet.getString("capacity")),
                        Boolean.parseBoolean(resultSet.getString("hasWhiteboard")),
                        Boolean.parseBoolean(resultSet.getString("hasPhone"))
                );

                
                cRWeb.setMaintained(resultSet.getBoolean("isMaintained"));
                
                // Get the last reservation for this resource
                ReservesLogDAO reservesLogDAO = new ReservesLogDAO();
                // Get the result set
                ResultSet reservationResultSet = reservesLogDAO.getLastReservationByID(Integer.parseInt(resultSet.getString("resourceID")));
                
                // Get the next (should only be one
                while (reservationResultSet != null && reservationResultSet.next()) {                      
                    // Create an object with it
                    Reservation reserve = new Reservation(reservationResultSet.getDate("startDate"), reservationResultSet.getDate("endDate"), 
                                            new UsersWeb(Integer.parseInt(reservationResultSet.getString("userID"))));
                    
                    // See if it's an active reservation
                    Date now = new Date();
                    if(reservationResultSet.getDate("startDate").before(now) && reservationResultSet.getDate("endDate").after(now)) {
                        cRWeb.setAvailable(false);
                    }
                    
                    // Add it to the list of reservations for this resource
                    cRWeb.addReservation(reserve);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        return cRWeb;
    }        
	
	/* GETTERS */
	
	public String getLocation() {
		return location;
	}
	public int getCapacity() {
		return capacity;
	}
	public boolean hasWhiteboard() {
		return hasWhiteboard;
	}
	public boolean hasPhone() {
		return hasPhone;
	}
	
	/* SETTERS */
	public void setLocation(String location) {
		this.location = location;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
		this.updateDescription();		
	}
	public void setHasWhiteboard(boolean hasWhiteboard) {
		this.hasWhiteboard = hasWhiteboard;
		this.updateDescription();
	}
	public void setHasPhone(boolean hasPhone) {
		this.hasPhone = hasPhone;
		this.updateDescription();
	}
	
        
        // Other methods
	public void updateDescription(){
		this.setDescription("Person capacity:\t" + capacity + "Whiteboard:\t" + hasWhiteboard + " Phone:\t" + hasPhone);
	}
	
	

}
