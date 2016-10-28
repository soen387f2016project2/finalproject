
package Demo;

public class EndUser {
    
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String password; // will eventually be encrypted
    
    public EndUser(String id, String firstName, String lastName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
    
    /*
    * Constructor with login info (username, password)
    */
    public EndUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getID() {
        return id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFullName() {
        return (firstName + " " + lastName);
    }
    
    public String getPassword() {
        return password;
    }
}
