/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import DAO.ConnectionFactory;
import java.util.HashMap;
import DAO.UsersDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mimi
 */
public class Accounts {
    
    // Attributes
    private HashMap endUsers; // Key = account id, Value = User object
    private HashMap admins; // Key = account id, Value = User object
    private UsersDAO usersDao;
    
    // Constructor
    public Accounts()
    {
        endUsers = new HashMap();
        admins = new HashMap();
        usersDao = new UsersDAO();
    }
    
    // Getters and setters
    public HashMap getEndUsers()
    {
        return endUsers;
    }
    
  
    public HashMap getAdmins()
    {
        return admins;
    }
    

    // Other methods
    public void createEndUsersList()
    {
        String sql = "SELECT userID,isAdmin,email,name,phoneNumber,department " +
                     "FROM users WHERE isAdmin=0";

        createUserList(endUsers, sql);
    }
    
    public void createAdminsList()
    {
        String sql = "SELECT userID,isAdmin,email,name,phoneNumber,department " +
                     "FROM users WHERE isAdmin=1";
        
        createUserList(admins, sql);
      
    }
    
    private void createUserList(HashMap list, String sql)
    {
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);
        
        try {
            while (resultSet != null && resultSet.next()) {
                
                 String id =  resultSet.getString(1);
                 boolean isAdmin = (resultSet.getInt(2) != 0);
                 String email = resultSet.getString(3);
                 String name = resultSet.getString(4);
                 String phoneNumber = resultSet.getString(5);
                 String department = resultSet.getString(6);

                 // Comment: query return password
                 UsersWeb user = new UsersWeb(Integer.getInteger(id), isAdmin, email, "password", name, phoneNumber, department);
                 list.put(id, user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public UsersWeb getEndUser(String key)
    {
        return (UsersWeb) endUsers.get(key);
    }
    
    public UsersWeb getAdmin(String key)
    {
        return (UsersWeb) admins.get(key);
    }
    
    public String getEUName(String key)
    {
        return getEndUser(key).getFullName();
    }
    
    public String getAdminFullName(String key)
    {
        return getAdmin(key).getFullName();
    }
}
