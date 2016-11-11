package webteam;

/*
 * ignoring inheritance for the time being because we are just using these objects as containers
 */

public class ConferenceRoom {
	
	// should this be an int instead of long for compatibility?
	private long resourceID;	// should  this have a setter? it is a foreign key
	private String location;
	private int capacity;
	private boolean hasWhiteboard;	// add these to the database
	private boolean hasPhone;		// add these to the database
	
	/* CONSTRUCTORS */
	
	public ConferenceRoom(long resourceID, String location, int capacity) 
	{
		this.resourceID = resourceID;
		this.location = location;
		this.capacity = capacity;
	}
	
	/* GETTERS */
	
	public long getResourceID() {
		return resourceID;
	}
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
	
	public void setResourceID(long resourceID) {
		this.resourceID = resourceID;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public void setHasWhiteboard(boolean hasWhiteboard) {
		this.hasWhiteboard = hasWhiteboard;
	}
	public void setHasPhone(boolean hasPhone) {
		this.hasPhone = hasPhone;
	}
	
	

}
