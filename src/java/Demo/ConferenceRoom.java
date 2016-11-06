
package Demo;

public class ConferenceRoom extends Resource {
    
    private int capacity;
    private boolean hasWhiteboard;
    private boolean hasPhone;
    
    public ConferenceRoom(String id, int capacity, boolean hasWhiteboard, boolean hasPhone) {
        super(id);
        this.capacity = capacity;
        this.hasWhiteboard = hasWhiteboard;
        this.hasPhone = hasPhone;
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
    
    public String classAsString() {
        return "Conference room";
    }
    
    public String descriptionString() {
        String whiteboard;
        if (hasWhiteboard) {
            whiteboard = "whiteboard";
        } else {
            whiteboard = "no whiteboard";
        }
              
        String phone;
        if (hasPhone) {
            phone = "phone";
        } else {
            phone = "no phone";
        }
        
        return (capacity + " person capacity, " + whiteboard + ", " + phone);
    }
}
