package Demo;

/*
 * we need to know if we are using a username or an email as login credentials
 * 
 */


public class UsersWeb
{
	private int userID;	// note: no setter for userID because auto-increment
	private boolean isAdmin;
	private String email; // email as username
	private String password;	// encripted?
	private String name;
	private String phoneNumber;
	private String department;
	
    
	/* CONSTRUCTORS */
	
    public UsersWeb(int userID, boolean isAdmin, String email, String password, String name, String phoneNumber, String department) 
    {
        this.userID = userID;
        this.isAdmin = isAdmin;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }
    
    /*
    * Constructor with login info (username, password)
    */
    public UsersWeb(String email, String password) // only if we need a username
    {
        this.email	 = email;
        this.password = password;
    }

    /* GETTERS */
    
	public int getUserID() {
		return userID;
	}
    
    public boolean isAdmin() {
		return isAdmin;
	}
    
    public String getEmail() {
		return email;
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
