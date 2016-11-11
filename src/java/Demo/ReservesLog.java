package webteam;	// change this to the correct package

public class ReservesLog {
	
	private long reservesID;	// note: no setter for reservesID because auto-increment
	private long userID;
	private long resourseID;
	private String startDate;	// should this be of Date type?
	private String endDate;		// should this be of Date type?
	
	/* CONSTRUCTORS */
	
	public ReservesLog(long reservesID, long userID, long resourseID, String startDate, String endDate) 
	{
		this.reservesID = reservesID;
		this.userID = userID;
		this.resourseID = resourseID;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/* GETTERS */
	
	public long getReservesID() {
		return reservesID;
	}

	public long getUserID() {
		return userID;
	}

	public long getResourseID() {
		return resourseID;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	/* SETTERS */
	
	public void setUserID(long userID) {
		this.userID = userID;
	}

	public void setResourseID(long resourseID) {
		this.resourseID = resourseID;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	
	

}
