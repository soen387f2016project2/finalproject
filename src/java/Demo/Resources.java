/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tino_
 */
//package Demo;
package webteam;


import java.util.Date;
import java.util.LinkedList;

public class Resources {
    
    //public enum Status {AVAILABLE, RESERVED};
    
    private int resourceID;
    private String resourceName;
    private boolean isMaintained;
    private String description;
    private LinkedList<Reservation> reservations;
        
    private Date currentDate;
    
    public Resources(int id) {
        this.resourceID = id;
        boolean isMaintained = true;//???
        reservations = new LinkedList<Reservation>();
    }
      
    public int getID() {
        return resourceID;
    }
    
    public String getName(){
        return resourceName;
    }
    
    public boolean isMaintained(){
        return isMaintained;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void updateName(String name){
        this.resourceName = name;
    }
    
    public void updateDescription(String description){
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
}