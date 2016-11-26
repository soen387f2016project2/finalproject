package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservesLogDAO {
    
    public void getAllReservationsForUser(int userID) {
        String sql = "SELECT rl.reservesID,rl.userID,name," +
                "rl.resourceID,startDate,endDate,description," +
                "resourceName,location,capacity,equipmentType " +
                "FROM reservesLog rl " +
                "LEFT JOIN resources r ON r.resourceId=rl.resourceId " +
                "LEFT JOIN conferenceRoom c ON c.resourceId=rl.resourceId " +
                "LEFT JOIN ITEquipment i ON i.resourceId=rl.resourceId " +
                "LEFT JOIN users u ON u.userID = rl.userId " +
                "WHERE rl.userID=" + userID;
        
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);
        
        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nreservesID: " + resultSet.getString(1) +
                        "\nuserID: " + resultSet.getString(2) +
                        "\nname: " + resultSet.getString(3) +
                        "\nresourceID: " + resultSet.getString(4) +
                        "\nstartDate: " + resultSet.getString(5) +
                        "\nendDate: " + resultSet.getString(6) +
                        "\ndescription: " + resultSet.getString(7) +
                        "\nresourceName: " + resultSet.getString(8) +
                        "\nlocation: " + resultSet.getString(9) +
                        "\ncapacity: " + resultSet.getString(10) +
                        "\nequipmentType: " + resultSet.getString(11)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void getAllReservationsForResource(int resourceID) {
        String sql = "SELECT rl.reservesID,rl.userID,name," +
                "rl.resourceID,startDate,endDate,description," +
                "resourceName,location,capacity,equipmentType " +
                "FROM reservesLog rl " +
                "LEFT JOIN resources r ON r.resourceId=rl.resourceId " +
                "LEFT JOIN conferenceRoom c ON c.resourceId=rl.resourceId " +
                "LEFT JOIN ITEquipment i ON i.resourceId=rl.resourceId " +
                "LEFT JOIN users u ON u.userID = rl.userId " +
                "WHERE rl.resourceID=" + resourceID;
        
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);
        
        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nreservesID: " + resultSet.getString(1) +
                        "\nuserID: " + resultSet.getString(2) +
                        "\nname: " + resultSet.getString(3) +
                        "\nresourceID: " + resultSet.getString(4) +
                        "\nstartDate: " + resultSet.getString(5) +
                        "\nendDate: " + resultSet.getString(6) +
                        "\ndescription: " + resultSet.getString(7) +
                        "\nresourceName: " + resultSet.getString(8) +
                        "\nlocation: " + resultSet.getString(9) +
                        "\ncapacity: " + resultSet.getString(10) +
                        "\nequipmentType: " + resultSet.getString(11)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void makeReservation(int userID, int resourceID, String startDate, String endDate) {
        String sql = "INSERT INTO reservesLog(userID,resourceID,startDate,endDate) " +
                "VALUES (" + userID + "," + resourceID + ",'" + 
                            startDate + "','" + endDate + "')";

        ConnectionFactory.executeUpdate(sql);
    }
}
