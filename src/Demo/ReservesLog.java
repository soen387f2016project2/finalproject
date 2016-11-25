

public class ReservesLog {
	
	private int reservesID;	// note: no setter for reservesID because auto-increment
	private int userID;
	private int resourseID;
	private String startDate;	// should this be of Date type?
	private String endDate;		// should this be of Date type?
	
	/* CONSTRUCTORS */
	
	public ReservesLog(int reservesID, int userID, int resourseID, String startDate, String endDate) 
	{
		this.reservesID = reservesID;
		this.userID = userID;
		this.resourseID = resourseID;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/* GETTERS */
	
	public int getReservesID() {
		return reservesID;
	}

	public int getUserID() {
		return userID;
	}

	public int getResourseID() {
		return resourseID;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	/* SETTERS */
	
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setResourseID(int resourseID) {
		this.resourseID = resourseID;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	
	

}
