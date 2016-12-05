/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Demo.UsersWeb;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kathy
 */
public class UsersDAO {

    
    public void addUser(int isAdmin, String email, String password, String name, String phoneNumber, String department) {
        String sql = "INSERT INTO users (isAdmin,email,PASSWORD,NAME,phoneNumber,department) " +
                     "VALUES ("+ isAdmin + ",'" + email + "','" + password + "','" +
                               name + "','" + phoneNumber + "','" + department + "');";
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Users table has been updated; user has been added.");
    }
    
    
    public void deleteUser(int userId) {
        String sql = "DELETE FROM users " + 
                     "WHERE userId=" + userId + ";";
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Users table has been updated; user has been deleted.");
    }
    
    public void updatePassword(int userId, String password) {
        String sql = "UPDATE users " + 
                     "SET PASSWORD='" + password + "' WHERE userId=" +userId + ";";
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Users table has been updated; password has been updated.");
    }
        
    public ResultSet getAllAdmin() {
        String sql = "SELECT userID,isAdmin,email,name,phoneNumber,department " +
                     "FROM users WHERE isAdmin=1";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);
        
        
        return resultSet;
    }
    
    public ResultSet getAllEmployee() {
        String sql = "SELECT userID,isAdmin,email,name,phoneNumber,department " +
                     "FROM users WHERE isAdmin=0";
        
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);
   
     
        return resultSet;
    }
    
//    a isAdmin bit of 0 should redirect to employee page, 
//    a bit of 1 should redirect to the admin page and 
//    if it is an empty result set the user does not exist

    public UsersWeb login(String email, String password) {
        String sql = "SELECT userID,isAdmin,email,name,phoneNumber,department " + 
                     "FROM users WHERE email='" + email + "' AND password='" + password + "';";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);
        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nuserID: " + resultSet.getString(1) +
                        "\nisAdmin: " + resultSet.getString(2) +
                        "\nemail: " + resultSet.getString(3) +
                        "\nname: " + resultSet.getString(4) +
                        "\nphoneNumber: " + resultSet.getString(5) +
                        "\ndepartment: " + resultSet.getString(6)
                );

                int id = Integer.parseInt(resultSet.getString(1));
                
                boolean admin;
                if(resultSet.getString(2).equals("1")){
                    admin = true;
                }
                else{
                    admin = false;
                }
                
                String mail = resultSet.getString(3);
                String name = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String department = resultSet.getString(6);
                
                System.out.println("DAO:" + admin);
                // Store resultset data into the user class object and return it
                UsersWeb user = new UsersWeb(id, admin, mail, password, name, phone, department);  
                
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    // Function to get a user's password from their id number
    public String getPassword(String userId) {
        String sql = "SELECT password FROM users WHERE userId=" + userId;
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);
        
        String returnStr = "";
        try {
            while (resultSet != null && resultSet.next()) {
                returnStr = resultSet.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return returnStr;
    }

}
