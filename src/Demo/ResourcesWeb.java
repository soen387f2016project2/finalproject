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

import java.util.Date;
import java.util.LinkedList;

public class ResourcesWeb {
    
    //public enum Status {AVAILABLE, RESERVED};
    
    private int resourceID;
    private String resourceName;
    private boolean isMaintained;
    private String description;
    private LinkedList<Reservation> reservations;
    private boolean isAvailable;
    
    public ResourcesWeb(int id, String resourcename, String description) {
        this.resourceID = id;
	this.resourceName=resourcename;
	this.description=description;
        boolean isMaintained = true;//???
        reservations = new LinkedList<Reservation>();
	boolean isAvailable=true;
		
    }
    
    public ResourcesWeb(int id, String resourcename, String description, boolean isMaintained, boolean isAvailable, Date startDate, Date endDate) {
    
    }
      
    public int getResourceID() {
		return resourceID;
	}

    //should never use, kept for testing purposes
	public void setResourceID(int resourceID) {
		this.resourceID = resourceID;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean getMaintained(){
		return isMaintained;
	}
	
	public void setMaintained(boolean isMaintained) {
		this.isMaintained = isMaintained;
	}

	public String getDescription(){
		return description +" isMaintained:\t" +isMaintained + " isAvailable:\t" + isAvailable;
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
    public String classAsString() {
        return resourceName;
    }
    
    public String descriptionString() {
        updateDescription();
        return getDescription();
    }
        
    public void updateDescription(){
	this.setDescription("Contenation of attributes");
    }
}