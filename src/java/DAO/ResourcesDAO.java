package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResourcesDAO {

    public void getAllResources() {
        String sql = "SELECT * " +
                "FROM resources r " +
                "LEFT JOIN miscellaneous i ON i.resourceID=r.resourceID " +
                "LEFT JOIN conferenceRoom c ON c.resourceId=r.resourceID " +
                "LEFT JOIN computer comp ON comp.resourceId=r.resourceID " +
                "LEFT JOIN projector p ON p.resourceId=r.resourceID";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nresourceID: " + resultSet.getString("resourceID") +
                        "\nisMaintained: " + resultSet.getString("isMaintained") +
                        "\nresourceName: " + resultSet.getString("resourceName") +
                        "\ndescription: " + resultSet.getString("description") +
                        "\nhasPhone: " + resultSet.getString("hasPhone") +
                        "\nhasWhiteboard: " + resultSet.getString("hasWhiteboard") +
                        "\nlocation: " + resultSet.getString("location") +
                        "\ncapacity: " + resultSet.getString("capacity") +
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

    public void getResourceById(int id) {
        String sql = "SELECT * " +
                "FROM resources r " +
                "LEFT JOIN miscellaneous i ON i.resourceID=r.resourceID " +
                "LEFT JOIN conferenceRoom c ON c.resourceId=r.resourceID " +
                "LEFT JOIN computer comp ON comp.resourceId=r.resourceID " +
                "LEFT JOIN projector p ON p.resourceId=r.resourceID " +
                "WHERE r.resourceId=" + id;
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nresourceID: " + resultSet.getString("resourceID") +
                        "\nisMaintained: " + resultSet.getString("isMaintained") +
                        "\nresourceName: " + resultSet.getString("resourceName") +
                        "\ndescription: " + resultSet.getString("description") +
                        "\nhasPhone: " + resultSet.getString("hasPhone") +
                        "\nhasWhiteboard: " + resultSet.getString("hasWhiteboard") +
                        "\nlocation: " + resultSet.getString("location") +
                        "\ncapacity: " + resultSet.getString("capacity") +
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

    public void getAllITEquipment() {
        String sql = "SELECT * " +
                "FROM resources r " +
                "LEFT JOIN miscellaneous m ON m.resourceID=r.resourceID " +
                "LEFT JOIN computer comp ON comp.resourceId=r.resourceID " +
                "LEFT JOIN projector p ON p.resourceId=r.resourceID";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nresourceID: " + resultSet.getString("resourceID") +
                        "\nisMaintained: " + resultSet.getString("isMaintained") +
                        "\nresourceName: " + resultSet.getString("resourceName") +
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

    public void getAllConferenceRooms() {
        String sql = "SELECT r.resourceID,r.isMaintained,r.resourceName," +
                "c.location,c.capacity,c.hasPhone,c.hasWhiteboard " +
                "FROM resources r " +
                "JOIN conferenceRoom c ON c.resourceId=r.resourceID";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nresourceID: " + resultSet.getString(1) +
                        "\nisMaintained: " + resultSet.getString(2) +
                        "\nresourceName: " + resultSet.getString(3) +
                        "\nlocation: " + resultSet.getString(4) +
                        "\ncapacity: " + resultSet.getString(5) +
                        "\nhasPhone: " + resultSet.getString(6) +
                        "\nhasWhiteboard: " + resultSet.getString(7)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllUnavailableResources() {
        String sql = "SELECT r.resourceID,r.isMaintained,r.description,r.resourceName," +
                "i.equipmentType,c.location,c.capacity,rl.startDate,rl.endDate " +
                "FROM resources r " +
                "LEFT JOIN reservesLog rl ON rl.resourceID=r.resourceID " +
                "LEFT JOIN ITEquipment i ON i.resourceID=r.resourceID " +
                "LEFT JOIN conferenceRoom c ON c.resourceId=r.resourceID " +
                "WHERE rl.startDate<NOW() AND rl.endDate>NOW() OR isMaintained";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nresourceID: " + resultSet.getString(1) +
                        "\nisMaintained: " + resultSet.getString(2) +
                        "\ndescription: " + resultSet.getString(3) +
                        "\nresourceName: " + resultSet.getString(4) +
                        "\nlocation: " + resultSet.getString(5) +
                        "\ncapacity: " + resultSet.getString(6)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllAvailableResources() {
        String sql = "SELECT r.resourceID,r.isMaintained,r.description,r.resourceName," +
                "i.equipmentType,c.location,c.capacity " +
                "FROM resources r " +
                "LEFT JOIN ITEquipment i ON i.resourceID=r.resourceID " +
                "LEFT JOIN conferenceRoom c ON c.resourceId=r.resourceID " +
                "WHERE r.resourceId NOT IN (" +
                    "SELECT r.resourceId " +
                    "FROM resources r " +
                    "LEFT JOIN reservesLog rl ON rl.resourceID=r.resourceID " +
                "WHERE rl.startDate<NOW() AND rl.endDate>NOW()" +
                ") AND NOT isMaintained";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nresourceID: " + resultSet.getString(1) +
                        "\nisMaintained: " + resultSet.getString(2) +
                        "\ndescription: " + resultSet.getString(3) +
                        "\nresourceName: " + resultSet.getString(4) +
                        "\nequipmentType: " + resultSet.getString(5) +
                        "\nlocation: " + resultSet.getString(6) +
                        "\ncapacity: " + resultSet.getString(7)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateResourcesIsMaintained(int id, int isMaintained) {
        String sql = "UPDATE resources SET isMaintained=" + isMaintained + " WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Resource has been updated");
    }

    public void updateResourcesDescription(int id, String description) {
        String sql = "UPDATE resources SET description='" + description + "' WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Resource has been updated");
    }

    public void updateResourcesName(int id, String name) {
        String sql = "UPDATE resources SET resourceName='" + name + "' WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Resource has been updated");
    }

    public void updateITEquipmentType(int id, String equipmentType) {
        String sql = "UPDATE ITEquipment SET equipmentType='" + equipmentType + "' WHERE resourceId=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("IT equipment has been updated");
    }

    public void updateConferenceRoomLocation(int id, String location) {
        String sql = "UPDATE conferenceRoom SET location='" + location + "' WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Conference room has been updated");
    }

    public void updateConferenceRoomCapacity(int id, int capacity) {
        String sql = "UPDATE conferenceRoom SET capacity=" + capacity + " WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Conference room has been updated");
    }

    public void deleteResourceById(int id) {
        String sql = "DELETE FROM resources WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Resource has been deleted");
    }

    public void addResourceITEquipment(int isMaintained, String description, String resourceName, String equipmentType) {
        String sql1 = "INSERT INTO resources (isMaintained,description,resourceName) VALUES (" +
                isMaintained + ", '" + description + "', '" + resourceName + "');";
        String sql2 = "INSERT INTO ITEquipment (resourceId,equipmentType) " +
                "SELECT resourceId,'" + equipmentType + "' FROM resources WHERE resourceName='"+ resourceName + "'";
        ConnectionFactory.executeUpdate(sql1);
        ConnectionFactory.executeUpdate(sql2);
        System.out.println("IT equipment has been added");
    }

    public void addResourceConferenceRoom(int isMaintained, String description, String resourceName,
                                          String location, int capacity) {
        String sql1 = "INSERT INTO resources (isMaintained,description,resourceName) VALUES (" +
                isMaintained + ", '" + description + "', '" + resourceName + "');";
        String sql2 = "INSERT INTO conferenceRoom (resourceId,location,capacity) " +
                "SELECT resourceId,'" + location + "'," + capacity +
                    " FROM resources WHERE resourceName='"+ resourceName + "'";
        ConnectionFactory.executeUpdate(sql1);
        ConnectionFactory.executeUpdate(sql2);
        System.out.println("Conference room has been added");
    }

}
