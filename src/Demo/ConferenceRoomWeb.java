package Demo;

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
	
	public void updateDescription(){
		this.setDescription("Person capacity:\t" + capacity + "Whiteboard:\t" + hasWhiteboard + " Phone:\t" + hasPhone);
	}
	
	

}
