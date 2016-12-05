/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import DAO.ConnectionFactory;
import DAO.UsersDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author mimi
 */
public class Accounts {
    
    // Attributes
    private LinkedList<UsersWeb> endUsers; // Key = account id, Value = User object
    private LinkedList<UsersWeb> admins; // Key = account id, Value = User object
    private UsersDAO usersDao;
    
    // Constructor
    public Accounts()
    {
        endUsers = new LinkedList<UsersWeb>();
        admins = new LinkedList<UsersWeb>();
        usersDao = new UsersDAO();
    }
    
    // Getters and setters
    public LinkedList<UsersWeb> getEndUsers()
    {
        return endUsers;
    }
    
  
    public LinkedList<UsersWeb> getAdmins()
    {
        return admins;
    }
    

    // Other methods
    public void createEndUsersList()
    {
        createUserList(usersDao.getAllEmployee(), endUsers);
    }
    
    public void createAdminsList()
    {        
        createUserList(usersDao.getAllAdmin(), admins);
    }
    
    private void createUserList(ResultSet resultSet, LinkedList<UsersWeb> list)
    {
        try {
            while (resultSet != null && resultSet.next()) {
                
                 String id =  resultSet.getString(1);
                 boolean isAdmin = (resultSet.getInt(2) != 0);
                 String email = resultSet.getString(3);
                 String name = resultSet.getString(4);
                 String phoneNumber = resultSet.getString(5);
                 String department = resultSet.getString(6);

                 // Comment: query return password
                 UsersWeb user = new UsersWeb(Integer.parseInt(id), isAdmin, email, "password", name, phoneNumber, department);
                 list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
/*    public UsersWeb getEndUser(String id)
    {
        int idInt = Integer.parseInt(id);
        System.out.println("USER ID: ");
        return (UsersWeb) endUsers.get(idInt);
    }
    
    public UsersWeb getAdmin(String id)
    {
        int idInt = Integer.parseInt(id);
        return (UsersWeb) admins.get(idInt);
    }
    
    public String getEUName(int id)
    {
        return getEndUser(id).getFullName();
    }
    
    public String getAdminFullName(int id)
    {
        return getAdmin(id).getFullName();
    }*/
}
    