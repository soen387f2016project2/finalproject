package DAO;

import Demo.Reservation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import Demo.ResourcesWeb;
import Demo.UsersWeb;

public class ResourcesDAO {

    public void getAllResources() {
        String sql = "SELECT * "
                + "FROM resources r "
                + "LEFT JOIN miscellaneous i ON i.resourceID=r.resourceID "
                + "LEFT JOIN conferenceRoom c ON c.resourceId=r.resourceID "
                + "LEFT JOIN computer comp ON comp.resourceId=r.resourceID "
                + "LEFT JOIN projector p ON p.resourceId=r.resourceID";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nresourceID: " + resultSet.getString("resourceID")
                        + "\nisMaintained: " + resultSet.getString("isMaintained")
                        + "\nresourceName: " + resultSet.getString("resourceName")
                        + "\ndescription: " + resultSet.getString("description")
                        + "\nhasPhone: " + resultSet.getString("hasPhone")
                        + "\nhasWhiteboard: " + resultSet.getString("hasWhiteboard")
                        + "\nlocation: " + resultSet.getString("location")
                        + "\ncapacity: " + resultSet.getString("capacity")
                        + "\nisDesktop: " + resultSet.getString("isDesktop")
                        + "\ncomputerModel: " + resultSet.getString("computerModel")
                        + "\nscreenSize: " + resultSet.getString("screenSize")
                        + "\ncpu: " + resultSet.getString("cpu")
                        + "\nram: " + resultSet.getString("ram")
                        + "\nstorage: " + resultSet.getString("storage")
                        + "\nprojectorModel: " + resultSet.getString("projectorModel")
                        + "\nmaxRes: " + resultSet.getString("maxRes")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getResourceById(int id) {
        String sql = "SELECT * "
                + "FROM resources r "
                + "LEFT JOIN miscellaneous i ON i.resourceID=r.resourceID "
                + "LEFT JOIN conferenceRoom c ON c.resourceId=r.resourceID "
                + "LEFT JOIN computer comp ON comp.resourceId=r.resourceID "
                + "LEFT JOIN projector p ON p.resourceId=r.resourceID "
                + "WHERE r.resourceId=" + id;
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nresourceID: " + resultSet.getString("resourceID")
                        + "\nisMaintained: " + resultSet.getString("isMaintained")
                        + "\nresourceName: " + resultSet.getString("resourceName")
                        + "\ndescription: " + resultSet.getString("description")
                        + "\nhasPhone: " + resultSet.getString("hasPhone")
                        + "\nhasWhiteboard: " + resultSet.getString("hasWhiteboard")
                        + "\nlocation: " + resultSet.getString("location")
                        + "\ncapacity: " + resultSet.getString("capacity")
                        + "\nisDesktop: " + resultSet.getString("isDesktop")
                        + "\ncomputerModel: " + resultSet.getString("computerModel")
                        + "\nscreenSize: " + resultSet.getString("screenSize")
                        + "\ncpu: " + resultSet.getString("cpu")
                        + "\nram: " + resultSet.getString("ram")
                        + "\nstorage: " + resultSet.getString("storage")
                        + "\nprojectorModel: " + resultSet.getString("projectorModel")
                        + "\nmaxRes: " + resultSet.getString("maxRes")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    * Search for a resource by name (for the search function)
     */
    public LinkedList<ResourcesWeb> getResourceByName(String name) {
        LinkedList<ResourcesWeb> resources = new LinkedList<ResourcesWeb>();

        String sql = "SELECT * "
                + "FROM resources r "
                + "LEFT JOIN miscellaneous i ON i.resourceID=r.resourceID "
                + "LEFT JOIN conferenceRoom c ON c.resourceId=r.resourceID "
                + "LEFT JOIN computer comp ON comp.resourceId=r.resourceID "
                + "LEFT JOIN projector p ON p.resourceId=r.resourceID "
                + "LEFT JOIN reservesLog rl ON rl.resourceID=r.resourceID "
                + "WHERE r.resourceName LIKE '" + name + "'";

        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                // Create a resource from the result set
                ResourcesWeb res = new ResourcesWeb(Integer.parseInt(resultSet.getString("resourceID")), resultSet.getString("resourceName"),
                        resultSet.getString("resourceName"));

                res.setMaintained(resultSet.getBoolean("isMaintained"));

                // Create a reservation object from the extra details in the query I got
                Reservation reserve = new Reservation(resultSet.getDate("startDate"), resultSet.getDate("endDate"),
                        new UsersWeb(Integer.parseInt(resultSet.getString("userID"))));

                // Add it to the resource
                res.addReservation(reserve);

                // Add the resource to the linked list
                resources.add(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resources;
    }

    public void getAllITEquipment() {
        String sql = "SELECT * "
                + "FROM resources r "
                + "LEFT JOIN miscellaneous m ON m.resourceID=r.resourceID "
                + "LEFT JOIN computer comp ON comp.resourceId=r.resourceID "
                + "LEFT JOIN projector p ON p.resourceId=r.resourceID";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nresourceID: " + resultSet.getString("resourceID")
                        + "\nisMaintained: " + resultSet.getString("isMaintained")
                        + "\nresourceName: " + resultSet.getString("resourceName")
                        + "\ndescription: " + resultSet.getString("description")
                        + "\nisDesktop: " + resultSet.getString("isDesktop")
                        + "\ncomputerModel: " + resultSet.getString("computerModel")
                        + "\nscreenSize: " + resultSet.getString("screenSize")
                        + "\ncpu: " + resultSet.getString("cpu")
                        + "\nram: " + resultSet.getString("ram")
                        + "\nstorage: " + resultSet.getString("storage")
                        + "\nprojectorModel: " + resultSet.getString("projectorModel")
                        + "\nmaxRes: " + resultSet.getString("maxRes")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllConferenceRooms() {
        String sql = "SELECT r.resourceID,r.isMaintained,r.resourceName,"
                + "c.location,c.capacity,c.hasPhone,c.hasWhiteboard "
                + "FROM resources r "
                + "JOIN conferenceRoom c ON c.resourceId=r.resourceID";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nresourceID: " + resultSet.getString(1)
                        + "\nisMaintained: " + resultSet.getString(2)
                        + "\nresourceName: " + resultSet.getString(3)
                        + "\nlocation: " + resultSet.getString(4)
                        + "\ncapacity: " + resultSet.getString(5)
                        + "\nhasPhone: " + resultSet.getString(6)
                        + "\nhasWhiteboard: " + resultSet.getString(7)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all unavailable resources, either booked by an employee or in maintenance by an admin
    public void getAllUnavailableResources() {
        String sql = "SELECT * "
                + "FROM resources r "
                + "LEFT JOIN reservesLog rl ON rl.resourceID=r.resourceID "
                + "LEFT JOIN miscellaneous m ON m.resourceID=r.resourceID"
                + "LEFT JOIN computer comp ON comp.resourceId=r.resourceID"
                + "LEFT JOIN projector p ON p.resourceId=r.resourceID"
                + "LEFT JOIN conferenceRoom c ON c.resourceId=r.resourceID "
                + "WHERE rl.startDate<NOW() AND rl.endDate>NOW() OR isMaintained";

        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nresourceID: " + resultSet.getString("resourceID")
                        + "\nisMaintained: " + resultSet.getString("isMaintained")
                        + "\nresourceName: " + resultSet.getString("resourceName")
                        + "\ndescription: " + resultSet.getString("description")
                        + "\nhasPhone: " + resultSet.getString("hasPhone")
                        + "\nhasWhiteboard: " + resultSet.getString("hasWhiteboard")
                        + "\nlocation: " + resultSet.getString("location")
                        + "\ncapacity: " + resultSet.getString("capacity")
                        + "\nisDesktop: " + resultSet.getString("isDesktop")
                        + "\ncomputerModel: " + resultSet.getString("computerModel")
                        + "\nscreenSize: " + resultSet.getString("screenSize")
                        + "\ncpu: " + resultSet.getString("cpu")
                        + "\nram: " + resultSet.getString("ram")
                        + "\nstorage: " + resultSet.getString("storage")
                        + "\nprojectorModel: " + resultSet.getString("projectorModel")
                        + "\nmaxRes: " + resultSet.getString("maxRes")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all available resources, those that are not booked and not in maintenance
    public void getAllAvailableResources() {
        String sql = "SELECT *"
                + "FROM resources r "
                + "LEFT JOIN miscellaneous m ON m.resourceID=r.resourceID"
                + "LEFT JOIN computer comp ON comp.resourceId=r.resourceID"
                + "LEFT JOIN projector p ON p.resourceId=r.resourceID"
                + "LEFT JOIN conferenceRoom c ON c.resourceId=r.resourceID "
                + "WHERE r.resourceId NOT IN ("
                + "SELECT r.resourceId "
                + "FROM resources r "
                + "LEFT JOIN reservesLog rl ON rl.resourceID=r.resourceID "
                + "WHERE rl.startDate<NOW() AND rl.endDate>NOW()"
                + ") AND NOT isMaintained";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nresourceID: " + resultSet.getString("resourceID")
                        + "\nisMaintained: " + resultSet.getString("isMaintained")
                        + "\nresourceName: " + resultSet.getString("resourceName")
                        + "\ndescription: " + resultSet.getString("description")
                        + "\nhasPhone: " + resultSet.getString("hasPhone")
                        + "\nhasWhiteboard: " + resultSet.getString("hasWhiteboard")
                        + "\nlocation: " + resultSet.getString("location")
                        + "\ncapacity: " + resultSet.getString("capacity")
                        + "\nisDesktop: " + resultSet.getString("isDesktop")
                        + "\ncomputerModel: " + resultSet.getString("computerModel")
                        + "\nscreenSize: " + resultSet.getString("screenSize")
                        + "\ncpu: " + resultSet.getString("cpu")
                        + "\nram: " + resultSet.getString("ram")
                        + "\nstorage: " + resultSet.getString("storage")
                        + "\nprojectorModel: " + resultSet.getString("projectorModel")
                        + "\nmaxRes: " + resultSet.getString("maxRes")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllComputers() {
        String sql = "SELECT *"
                + "FROM resources r "
                + "LEFT JOIN computer comp ON comp.resourceId=r.resourceID";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nresourceID: " + resultSet.getString("resourceID")
                        + "\nisMaintained: " + resultSet.getString("isMaintained")
                        + "\nresourceName: " + resultSet.getString("resourceName")
                        + "\nisDesktop: " + resultSet.getString("isDesktop")
                        + "\ncomputerModel: " + resultSet.getString("computerModel")
                        + "\nscreenSize: " + resultSet.getString("screenSize")
                        + "\ncpu: " + resultSet.getString("cpu")
                        + "\nram: " + resultSet.getString("ram")
                        + "\nstorage: " + resultSet.getString("storage")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllProjectors() {
        String sql = "SELECT *"
                + "FROM resources r "
                + "LEFT JOIN projector p ON p.resourceId=r.resourceID";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nresourceID: " + resultSet.getString("resourceID")
                        + "\nisMaintained: " + resultSet.getString("isMaintained")
                        + "\nresourceName: " + resultSet.getString("resourceName")
                        + "\nprojectorModel: " + resultSet.getString("projectorModel")
                        + "\nmaxRes: " + resultSet.getString("maxRes")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllMiscellaneous() {
        String sql = "SELECT *"
                + "FROM resources r "
                + "LEFT JOIN miscellaneous m ON m.resourceId=r.resourceID";
        ResultSet resultSet = ConnectionFactory.executeQuery(sql);

        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println(
                        "\nresourceID: " + resultSet.getString("resourceID")
                        + "\nisMaintained: " + resultSet.getString("isMaintained")
                        + "\nresourceName: " + resultSet.getString("resourceName")
                        + "\ndescription: " + resultSet.getString("description")
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

    public void updateResourcesName(int id, String name) {
        String sql = "UPDATE resources SET resourceName='" + name + "' WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Resource has been updated");
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

    public void updateConferenceRoomHasPhone(int id, int hasPhone) {
        String sql = "UPDATE conferenceRoom SET hasPhone=" + hasPhone + " WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Conference room has been updated");
    }

    public void updateConferenceRoomHasWhiteboard(int id, int hasWhiteboard) {
        String sql = "UPDATE conferenceRoom SET hasWhiteboard=" + hasWhiteboard + " WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Conference room has been updated");
    }

    public void updateComputerType(int id, int isDesktop) {
        String sql = "UPDATE computer SET isDesktop=" + isDesktop + " WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Computer has been updated");
    }

    public void updateComputerModel(int id, String computerModel) {
        String sql = "UPDATE computer SET computerModel=" + computerModel + " WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Computer has been updated");
    }

    public void updateComputerScreenSize(int id, float screenSize) {
        String sql = "UPDATE computer SET screenSize=" + screenSize + " WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Computer has been updated");
    }

    public void updateComputerCPU(int id, String cpu) {
        String sql = "UPDATE computer SET cpu=" + cpu + " WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Computer has been updated");
    }

    public void updateComputerRAM(int id, String ram) {
        String sql = "UPDATE computer SET ram=" + ram + " WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Computer has been updated");
    }

    public void updateComputerStorage(int id, String storage) {
        String sql = "UPDATE computer SET storage=" + storage + " WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Computer has been updated");
    }

    public void updateProjectorModel(int id, float projectorModel) {
        String sql = "UPDATE projector SET projectorModel=" + projectorModel + " WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Projector has been updated");
    }

    public void updateProjectorMaxRes(int id, float maxRes) {
        String sql = "UPDATE projector SET maxRes=" + maxRes + " WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Projector has been updated");
    }

    public void deleteResourceById(int id) {
        String sql = "DELETE FROM resources WHERE resourceID=" + id;
        ConnectionFactory.executeUpdate(sql);
        System.out.println("Resource has been deleted");
    }

    public void addResourceMiscellaneous(int isMaintained, String resourceName, String description) {
        String sql1 = "INSERT INTO resources (isMaintained,resourceName) VALUES ("
                + isMaintained + ", '" + resourceName + "');";
        String sql2 = "INSERT INTO miscellaneous (resourceId,description) "
                + "SELECT resourceId,'" + description + "'"
                + " FROM resources WHERE resourceName='" + resourceName + "'";
        System.out.println(sql2);
        ConnectionFactory.executeUpdate(sql1);
        ConnectionFactory.executeUpdate(sql2);
        System.out.println("Miscellaneous has been added");
    }

    public void addResourceComputer(int isMaintained, String resourceName, int isDesktop, String computerModel,
            float screenSize, String cpu, String ram, String storage) {
        String sql1 = "INSERT INTO resources (isMaintained,resourceName) VALUES ("
                + isMaintained + ", '" + resourceName + "');";
        String sql2 = "INSERT INTO computer (resourceId,isDesktop,computerModel,screenSize,cpu,ram,storage) "
                + "SELECT resourceId," + isDesktop + ",'" + computerModel + "'," + screenSize + ",'"
                + cpu + "','" + ram + "','" + storage + "'"
                + " FROM resources WHERE resourceName='" + resourceName + "'";
        ConnectionFactory.executeUpdate(sql1);
        ConnectionFactory.executeUpdate(sql2);
        System.out.println("Computer has been added");
    }

    public void addResourceProjector(int isMaintained, String resourceName, String projectorModel, String maxRes) {
        String sql1 = "INSERT INTO resources (isMaintained,resourceName) VALUES ("
                + isMaintained + ", '" + resourceName + "');";
        String sql2 = "INSERT INTO projector (resourceId,projectorModel,maxRes) "
                + "SELECT resourceId,'" + projectorModel + "','" + maxRes + "'"
                + " FROM resources WHERE resourceName='" + resourceName + "'";
        ConnectionFactory.executeUpdate(sql1);
        ConnectionFactory.executeUpdate(sql2);
        System.out.println("Projector has been added");
    }

    public void addResourceConferenceRoom(int isMaintained, String resourceName, String location, int capacity,
            int hasPhone, int hasWhiteboard) {
        String sql1 = "INSERT INTO resources (isMaintained,resourceName) VALUES ("
                + isMaintained + ", '" + resourceName + "');";
        String sql2 = "INSERT INTO conferenceRoom (resourceId,location,capacity,hasPhone,hasWhiteboard) "
                + "SELECT resourceId,'" + location + "'," + capacity + "," + hasPhone + "," + hasWhiteboard
                + " FROM resources WHERE resourceName='" + resourceName + "'";
        ConnectionFactory.executeUpdate(sql1);
        ConnectionFactory.executeUpdate(sql2);
        System.out.println("Conference room has been added");
    }

}
