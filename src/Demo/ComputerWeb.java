package Demo;

import DAO.ReservesLogDAO;
import DAO.ResourcesDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

public class ComputerWeb extends ResourcesWeb {
	
    private String resourceName;
    private String model;
    private int screenSize;
    private String cpu;
    private String ram;
    private String storage;
	
    public ComputerWeb(int id, String resourceName, String model, int screenSize, String cpu, String ram, String storage) {
        super(id,resourceName,"Mode:\t" + model + "Screensize:\t" + screenSize + " cpu:\t" + cpu + " ram:\t" + ram +
                        " storage:\t"+ storage);
        this.model = model;
        this.screenSize = screenSize;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
    }
    
    public ComputerWeb(){}
    
    public ComputerWeb getResourceById(int resourceID){
        ResourcesDAO resourcesDAO = new ResourcesDAO();
        ResultSet resultSet = resourcesDAO.getResourceById(resourceID);
        ComputerWeb cWeb = null;
        
        try {
            while (resultSet != null && resultSet.next()) {
                cWeb = new ComputerWeb(Integer.parseInt(resultSet.getString("resourceID")), 
                        resultSet.getString("resourceName"),
                        resultSet.getString("computerModel"),
                        Integer.parseInt(resultSet.getString("screenSize")),
                        resultSet.getString("cpu"),
                        resultSet.getString("ram"),
                        resultSet.getString("storage")
                );
                
                cWeb.setMaintained(resultSet.getBoolean("isMaintained"));
                
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
                        cWeb.setAvailable(false);
                    }
                    
                    // Add it to the list of reservations for this resource
                    cWeb.addReservation(reserve);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        return cWeb;
    }

    //getters
    public String getModel() {
            return model;
    }

    public int getScreenSize() {
            return screenSize;
    }

    public String getCpu() {
            return cpu;
    }

    public String getRam() {
            return ram;
    }

    public String getStorage() {
            return storage;
    }
	
    //setters
    public void setModel(String model) {
            this.model = model;
            this.updateDescription();
    }

    public void setScreenSize(int screenSize) {
            this.screenSize = screenSize;
            this.updateDescription();
    }

    public void setCpu(String cpu) {
            this.cpu = cpu;
            this.updateDescription();
    }

    public void setRam(String ram) {
            this.ram = ram;
            this.updateDescription();
    }

    public void setStorage(String storage) {
            this.storage = storage;
            this.updateDescription();
    }

    // Other methods       
    public void updateDescription(){
        this.setDescription("Type:\t" + resourceName + "Model:\t" + model + "Screensize:\t" + screenSize + " cpu:\t" + cpu + " ram:\t" + ram +
                            " storage:\t"+ storage);
    }
    
    
}
