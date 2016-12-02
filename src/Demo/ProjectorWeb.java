package Demo;

import DAO.ReservesLogDAO;
import DAO.ResourcesDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ProjectorWeb extends ResourcesWeb {

    // Attributes
    private String model;
    private String resolution;
	
    // Constructor
    public ProjectorWeb(int id, String resourcename, String description, String model, String resolution) {
	super(id, "Projector", "model:\t" +model +" resolution:\t" + resolution);
	this.model = model;
	this.resolution = resolution;
    }
    
    
    public ResourcesWeb getResourceById(int resourceID){
        ResourcesDAO resourcesDAO = new ResourcesDAO();
        ResultSet resultSet = resourcesDAO.getResourceById(resourceID);
        ProjectorWeb pWeb = null;
        try {
            while (resultSet != null && resultSet.next()) {
     
                pWeb = new ProjectorWeb(Integer.parseInt(resultSet.getString("resourceID")), 
                        resultSet.getString("resourceName"),
                        resultSet.getString("description"),
                        resultSet.getString("projectorModel"),
                        resultSet.getString("maxRes")
                );

                pWeb.setMaintained(resultSet.getBoolean("isMaintained"));
                
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
                        pWeb.setAvailable(false);
                    }
                    
                    // Add it to the list of reservations for this resource
                    pWeb.addReservation(reserve);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        return pWeb;
    }

    // Getters and setters
    public String getModel() {
        return model;
    }

    public String getResolution() {
        return resolution;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    // Other methods
    public void updateDescription(){
        this.setDescription("Model:\t" +model +" Resolution:\t" +resolution);
    }
    
    
}
