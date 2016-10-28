/*
 * DAO (model) that handles user login
 */
package Models;

import Demo.EndUser;

/**
 *
 * @author Samantha Graham
 */
public class LoginDao {

    /*
    * Method that checks the username and password
     */
    public EndUser authenticate(String username, String password) {        
        // TODO: actually connect to a database
        if(password.equals("") || username.equals("baduser")) {            
            return null;
        } else {
            EndUser user = new EndUser("1", "Bob", "Dole", "1234567890");
            return user;
        }        
    }
}
