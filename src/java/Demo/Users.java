package webteam; //change this to the correct package

/*
 * we need to know if we are using a username or an email as login credentials
 * 
 */


public class Users 
{
	// should this be an int instead of long for compatibility?
	private long userID;	// note: no setter for userID because auto-increment
	private boolean isAdmin;
	private String email;
	private String username;	// do we need this?
	private String password;	// encripted?
	private String name;
	private String phoneNumber;
	private String department;
	
    
	/* CONSTRUCTORS */
	
    public Users(long userID, boolean isAdmin, String email, String username, //do we need this?
    		String password, String name, String phoneNumber, String department) 
    {
        this.userID = userID;
        this.isAdmin = isAdmin;
        this.email = email;
        this.username = username;	// do we need this?
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }
    
    /*
    * Constructor with login info (username, password)
    */
    public Users(String username, String password) // only if we need a username
    {
        this.username = username;
        this.password = password;
    }

    /* GETTERS */
    
	public long getUserID() {
		return userID;
	}
    
    public boolean isAdmin() {
		return isAdmin;
	}
    
    public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getDepartment() {
		return department;
	}
	
	/* SETTERS */
	
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}

	
    
	

}
