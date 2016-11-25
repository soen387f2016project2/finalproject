package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservesLogDAO {
    
    public void getAllReservationsForUser(int userID) {
        String sql = "SELECT * " +
                "FROM reservesLog rl " +
                "LEFT JOIN resources r ON r.resourceId=rl.resourceId " +
                "LEFT JOIN conferenceRoom c ON c.resourceId=rl.resourceId " +
                "LEFT JOIN miscellaneous m ON m.resourceID=r.resourceID" +
                "LEFT JOIN computer comp ON comp.resourceId=r.resourceID" +
                "LEFT JOIN projector p ON p.resourceId=r.resourceID" +
                "LEFT JOIN users u ON u.userID = rl.userId " +
                "WHERE rl.userID=" + userID;
        
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);
        
        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nreservesID: " + resultSet.getString("reservesID") +
                        "\nuserID: " + resultSet.getString("userID") +
                        "\nname: " + resultSet.getString("name") +
                        "\nresourceID: " + resultSet.getString("resourceID") +
                        "\nstartDate: " + resultSet.getString("startDate") +
                        "\nendDate: " + resultSet.getString("endDate") +
                        "\nresourceName: " + resultSet.getString("resourceName") +
                        "\nlocation: " + resultSet.getString("location") +
                        "\ncapacity: " + resultSet.getString("capacity") +
                        "\nhasPhone: " + resultSet.getString("hasPhone") +
                        "\nhasWhiteboard: " + resultSet.getString("hasWhiteboard") +
                        "\ndescription: " + resultSet.getString("description") +
                        "\nisDesktop: " + resultSet.getString("isDesktop") +
                        "\ncomputerModel: " + resultSet.getString("computerModel") +
                        "\nscreenSize: " + resultSet.getString("screenSize") +
                        "\ncpu: " + resultSet.getString("cpu") +
                        "\nram: " + resultSet.getString("ram") +
                        "\nstorage: " + resultSet.getString("storage") +
                        "\nprojectorModel: " + resultSet.getString("projectorModel") +
                        "\nmaxRes: " + resultSet.getString("maxRes")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void getAllReservationsForResource(int resourceID) {
        String sql = "SELECT *" +
                "FROM reservesLog rl " +
                "LEFT JOIN resources r ON r.resourceId=rl.resourceId " +
                "LEFT JOIN conferenceRoom c ON c.resourceId=rl.resourceId " +
                "LEFT JOIN miscellaneous m ON m.resourceID=r.resourceID" +
                "LEFT JOIN computer comp ON comp.resourceId=r.resourceID" +
                "LEFT JOIN projector p ON p.resourceId=r.resourceID" +
                "LEFT JOIN users u ON u.userID = rl.userId " +
                "WHERE rl.resourceID=" + resourceID;
        
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);
        
        try {
            while (resultSet != null && resultSet.next()) {
                        "\nreservesID: " + resultSet.getString("reservesID") +
                        "\nuserID: " + resultSet.getString("userID") +
                        "\nname: " + resultSet.getString("name") +
                        "\nresourceID: " + resultSet.getString("resourceID") +
                        "\nstartDate: " + resultSet.getString("startDate") +
                        "\nendDate: " + resultSet.getString("endDate") +
                        "\nresourceName: " + resultSet.getString("resourceName") +
                        "\nlocation: " + resultSet.getString("location") +
                        "\ncapacity: " + resultSet.getString("capacity") +
                        "\nhasPhone: " + resultSet.getString("hasPhone") +
                        "\nhasWhiteboard: " + resultSet.getString("hasWhiteboard") +
                        "\ndescription: " + resultSet.getString("description") +
                        "\nisDesktop: " + resultSet.getString("isDesktop") +
                        "\ncomputerModel: " + resultSet.getString("computerModel") +
                        "\nscreenSize: " + resultSet.getString("screenSize") +
                        "\ncpu: " + resultSet.getString("cpu") +
                        "\nram: " + resultSet.getString("ram") +
                        "\nstorage: " + resultSet.getString("storage") +
                        "\nprojectorModel: " + resultSet.getString("projectorModel") +
                        "\nmaxRes: " + resultSet.getString("maxRes")
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
