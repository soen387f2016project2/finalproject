package Demo;

import DAO.ReservesLogDAO;
import DAO.ResourcesDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MiscWeb extends ResourcesWeb {

        // Attributes
        private int id;
        private String description;
        
        // Constructor
	public MiscWeb(int id, String description){
            super(id,"Misc",description);
	}
        
        public MiscWeb(){}
	
        // Other methods
	public void updateDescription(){
            this.setDescription("Description:\t" + description);
	}
        
        
   public MiscWeb getResourceById(int resourceID){
        ResourcesDAO resourcesDAO = new ResourcesDAO();
        ResultSet resultSet = resourcesDAO.getResourceById(resourceID);
        MiscWeb mWeb = null;
        try {
            while (resultSet != null && resultSet.next()) {
               
                mWeb = new MiscWeb(Integer.parseInt(resultSet.getString("resourceID")), 
                        resultSet.getString("description")
                );
                
                mWeb.setMaintained(resultSet.getBoolean("isMaintained"));
                
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
                        mWeb.setAvailable(false);
                    }
                    
                    // Add it to the list of reservations for this resource
                    mWeb.addReservation(reserve);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        return mWeb;
    }
	
}
